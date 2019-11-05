package com.example.integrador2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;


public class RegistrarPersona extends AppCompatActivity {

    //defining view objects
    private EditText Text_NombrePers;
    private EditText Text_ApellidoPers;
    private EditText TextEmailPers;
    private EditText TextPasswordRegPers;
    private Button btnRegistrarPers;
    private ProgressDialog progressDialog;


    //Declaramos un objeto firebaseAuth
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_persona);


        //inicializamos el objeto firebaseAuth
        firebaseAuth = FirebaseAuth.getInstance();


        Log.e("error", firebaseAuth.toString());
        //Referenciamos los views
        Text_NombrePers = (EditText) findViewById(R.id.Txt_NombrePers);
        Text_ApellidoPers = (EditText) findViewById(R.id.Txt_ApellidoPers);
        TextEmailPers = (EditText) findViewById(R.id.TxtEmailPers);
        TextPasswordRegPers = (EditText) findViewById(R.id.TxtPasswordRegPers);


        btnRegistrarPers = (Button) findViewById(R.id.botonRegistrarPers);

        progressDialog = new ProgressDialog(this);
        btnRegistrarPers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        private void registrarUsuario(){

            //Obtenemos el email y la contraseña desde las cajas de texto
            String email = TextEmailPers.getText().toString().trim();
            String password = TextPasswordRegPers.getText().toString().trim();

            //Verificamos que las cajas de texto no esten vacías
            if (TextUtils.isEmpty(password) | password.length() < 5) {
                Toast.makeText(this, "Falta ingresar contraseña", Toast.LENGTH_LONG).show();
                Toast.makeText(this, "Falta ingresar la contraseña", Toast.LENGTH_LONG).show();
                return;
            }
            //verificamos que las cajas de texto no esten vacias
            if (TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Se debe ingresar un email", Toast.LENGTH_LONG).show();
                return;
            }


            progressDialog.setMessage("Realizando registro en linea...");
            progressDialog.show();

            //creating a new user
            firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    //checking if success
                    if (task.isSuccessful()) {

                        Toast.makeText(RegistrarPersona.this, "Se ha registrado el usuario con el email: " + TextEmailPers.getText(), Toast.LENGTH_LONG).show();
                    } else {

                        Toast.makeText(RegistrarPersona.this, "No se pudo registrar el usuario ", Toast.LENGTH_LONG).show();
                        Toast.makeText(RegistrarPersona.this, task.toString(), Toast.LENGTH_SHORT).show();

                    }
                    progressDialog.dismiss();
                }
            });


        }


        FirebaseFirestore db = FirebaseFirestore.getInstance();
        // aqui agregaras el codigo de la seccion "Agregar datos de la documentacion de Firebase"
        // Crea un nuevo usuario con nombre y apellido
        Map<String, Object> usuarios = new HashMap<>();
        usuarios.put("correo", "Alan@hotmail.com");
        usuarios.put("contraseña", "paladins");


// Agregar un nuevo documento con una ID generada
        db.collection("usuarios")
                .add(usuarios)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "Documento agregado con ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error al agregar documento", e);
                    }
                });

        db.collection("usuarios")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w(TAG, "Error al obtener documentos.", task.getException());
                        }
                    }
                });
    }

        }








