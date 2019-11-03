package com.example.integrador2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;


import java.io.IOException;

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
        Log.e("error",firebaseAuth.toString());
        //Referenciamos los views
        Text_NombreProfe = (EditText) findViewById(R.id.Txt_NombreProfe);
        Text_ApellidoProfe = (EditText) findViewById(R.id.Txt_ApellidoProfe);
        TextProfesion= (EditText) findViewById(R.id.Txt_Profesion);
        TextEmailProfe = (EditText) findViewById(R.id.TxtEmailProfe);
        TextPasswordRegProfe = (EditText) findViewById(R.id.TxtPasswordRegProfe);


        btnRegistrarProfes = (Button) findViewById(R.id.botonRegistrarProfe);
        btnRegistrarProfes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //codigo de cloud  Firestore

            }
        });


        progressDialog = new ProgressDialog(this);


    }

}
