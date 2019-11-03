package com.example.integrador2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

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
        Log.e("error",firebaseAuth.toString());
        //Referenciamos los views
        Text_NombrePers = (EditText) findViewById(R.id.Txt_NombrePers);
        Text_ApellidoPers = (EditText) findViewById(R.id.Txt_ApellidoPers);
        TextEmailPers= (EditText) findViewById(R.id.TxtEmailPers);
        TextPasswordRegPers = (EditText) findViewById(R.id.TxtPasswordRegPers);



        btnRegistrarPers = (Button) findViewById(R.id.botonRegistrarPers);


        progressDialog = new ProgressDialog(this);
    }
}
