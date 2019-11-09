package com.example.integrador2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RegistrarProfesional extends AppCompatActivity {
    //defining view objects
    private EditText Text_NombreProfe;
    private EditText Text_ApellidoProfe;
    private EditText TextProfesion;
    private EditText TextEmailProfe;
    private EditText TextPasswordRegProfe;
    private Button btnRegistrarProfes;
    private ProgressDialog progressDialog;


    //Declaramos un objeto firebaseAuth
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_profesional);

        //inicializamos el objeto firebaseAuth
        firebaseAuth = FirebaseAuth.getInstance();
        Log.e("error", firebaseAuth.toString());
        //Referenciamos los views
        Text_NombreProfe = (EditText) findViewById(R.id.Txt_NombreProfe);
        Text_ApellidoProfe = (EditText) findViewById(R.id.Txt_ApellidoProfe);
        TextProfesion = (EditText) findViewById(R.id.Txt_Profesion);
        TextEmailProfe = (EditText) findViewById(R.id.TxtEmailProfe);
        TextPasswordRegProfe = (EditText) findViewById(R.id.TxtPasswordRegProfe);
        btnRegistrarProfes = (Button) findViewById(R.id.botonRegistrarProfe);

        progressDialog = new ProgressDialog(this);

        btnRegistrarProfes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarUsuario();
                //codigo de cloud  Firestore

            }
        });

    }

    private void registrarUsuario() {

        //Obtenemos el email y la contraseña desde las cajas de texto
        final String email = TextEmailProfe.getText().toString().trim();
        String password = TextPasswordRegProfe.getText().toString().trim();

        //Verificamos que las cajas de texto no esten vacías
        if (TextUtils.isEmpty(password) | password.length() < 5) {
            Toast.makeText(this, "contraseña invalida", Toast.LENGTH_LONG).show();
            return;
        }
        //verificamos que las cajas de texto no esten vacias
        if (TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Se debe ingresar un email valido", Toast.LENGTH_LONG).show();
            return;
        }

        progressDialog.setMessage("Realizando registro en linea...");
        progressDialog.show();

        //creating a new user
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                registrar();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(RegistrarProfesional.this, "Error el usuario no pudo ser creado: " + e.toString(), Toast.LENGTH_LONG).show();
            }
        });

    }


    void registrar() {

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String, Object> usuarios = new HashMap<>();
        usuarios.put("tipo", "profesional"); // persona / empresa / profesional
        usuarios.put("nombre", Text_NombreProfe.getText().toString());
        usuarios.put("apellido", Text_ApellidoProfe.getText().toString());
        usuarios.put("profesion", TextProfesion.getText().toString());


        db.collection("usuarios").document(TextEmailProfe.getText().toString()).set(usuarios).addOnSuccessListener(new OnSuccessListener<Void>() {

            @Override
            public void onSuccess(Void aVoid) {
                progressDialog.dismiss();
                startActivity(new Intent(RegistrarProfesional.this, HomeProfesional.class));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(RegistrarProfesional.this, "Error los datos del usuario no fueron guardados", Toast.LENGTH_LONG).show();

            }
        });

    }
}
