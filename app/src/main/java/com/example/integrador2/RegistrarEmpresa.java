package com.example.integrador2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
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
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegistrarEmpresa extends AppCompatActivity {
    int contador=0;

    //defining view objects
    private EditText Text_NombreEmpr;
    private EditText Text_Rubro;
    private EditText Text_RUC;
    private EditText TextEmailEmpre;
    private EditText TextPasswordRegEmpre;
    private Button btnRegistrarEmpresa;
    private ProgressDialog progressDialog;



    //Declaramos un objeto firebaseAuth
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_empresa);

        //inicializamos el objeto firebaseAuth
        firebaseAuth = FirebaseAuth.getInstance();
        Log.e("error", firebaseAuth.toString());
        //Referenciamos los views
        Text_NombreEmpr = (EditText) findViewById(R.id.Txt_NombreEmpr);
        Text_Rubro = (EditText) findViewById(R.id.Txt_Rubro);
        Text_RUC = (EditText) findViewById(R.id.Txt_RUC);
        TextEmailEmpre = (EditText) findViewById(R.id.TxtEmailEmpre);
        TextPasswordRegEmpre = (EditText) findViewById(R.id.TxtPasswordRegEmpre);
        btnRegistrarEmpresa = (Button) findViewById(R.id.botonRegistrarEmpresa);

        progressDialog = new ProgressDialog(this);

        btnRegistrarEmpresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Vibrator vibrator = (Vibrator)getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(1000);

                registrarUsuario();
                //codigo de cloud  Firestore
            }
        });
    }

        private void registrarUsuario() {

            //Obtenemos el email y la contraseña desde las cajas de texto
            final String email = TextEmailEmpre.getText().toString().trim();
            String password = TextPasswordRegEmpre.getText().toString().trim();
            String nombreempresa = Text_NombreEmpr.getText().toString();
            String rubro = Text_Rubro.getText().toString();
            String ruc = Text_RUC.getText().toString();

            //verificamos que el campo rubro no este vacio
            if (rubro.equals("")){
                Toast.makeText(this, "Escribir su Rubro !!!", Toast.LENGTH_SHORT).show();
                // Focus en jugar y abrir el Teclado
                return;
            }

            //verificamos que el campo ruc no este vacio
            if (ruc.equals("")){
                Toast.makeText(this, "Escribir su RUC !!!", Toast.LENGTH_SHORT).show();
                // Focus en jugar y abrir el Teclado
                return;
            }

            //verificamos que el campo nombre no este vacio
            if (nombreempresa.equals("")){
                Toast.makeText(this, "Escribir Nombre !!!", Toast.LENGTH_SHORT).show();
                // Focus en jugar y abrir el Teclado
                return;
            }

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
                    Toast.makeText(RegistrarEmpresa.this, "Error el usuario no pudo ser creado: "+e.toString(), Toast.LENGTH_LONG).show();
                }
            });

        }

    void registrar() {

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String, Object> usuarios = new HashMap<>();
        usuarios.put("tipo", "empresa"); // persona / empresa / profesional
        usuarios.put("nombre", Text_NombreEmpr.getText().toString());
        usuarios.put("rubro", Text_Rubro.getText().toString());
        usuarios.put("ruc", Text_RUC.getText().toString());




        db.collection("usuarios").document(TextEmailEmpre.getText().toString()).set(usuarios).addOnSuccessListener(new OnSuccessListener<Void>() {

            @Override
            public void onSuccess(Void aVoid) {
                progressDialog.dismiss();
                startActivity(new Intent(RegistrarEmpresa.this, HomeEmpresa.class));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(RegistrarEmpresa.this, "Error los datos del usuario no fueron guardados", Toast.LENGTH_LONG).show();

            }
        });


        }

    public void onBackPressed(){

        if (contador==0){
            Toast.makeText(getApplicationContext(),"Presione de nuevo para salir de la aplicacion", Toast.LENGTH_SHORT).show();
            contador++;
        }else{
            super.onBackPressed();
        }

        new CountDownTimer(3000,1000){

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                contador=0;
            }
        }.start();
    }
}
