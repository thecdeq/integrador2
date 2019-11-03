package com.example.integrador2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class RegistrarEmpresa extends AppCompatActivity {

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
        Log.e("error",firebaseAuth.toString());
        //Referenciamos los views
        Text_NombreEmpr = (EditText) findViewById(R.id.Txt_NombreEmpr);
        Text_Rubro = (EditText) findViewById(R.id.Txt_Rubro);
        Text_RUC = (EditText) findViewById(R.id.Txt_RUC);
        TextEmailEmpre = (EditText) findViewById(R.id.TxtEmailEmpre);
        TextPasswordRegEmpre = (EditText) findViewById(R.id.TxtPasswordRegEmpre);


        btnRegistrarEmpresa = (Button) findViewById(R.id.botonRegistrarEmpresa);
        btnRegistrarEmpresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //codigo de cloud  Firestore
            }
        });

        progressDialog = new ProgressDialog(this);

    }
}
