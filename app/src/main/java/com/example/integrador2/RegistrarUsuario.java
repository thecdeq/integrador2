package com.example.integrador2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class RegistrarUsuario extends AppCompatActivity {

    //definir botones
    private Button btnEMPRERSA,btnPROFESIONAL,btnPERSONA;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);

        btnEMPRERSA = (Button) findViewById(R.id.botonEmpresa);
        btnPERSONA = (Button) findViewById(R.id.botonPersona);
        btnPROFESIONAL = (Button) findViewById(R.id.botonProfesional);

        btnEMPRERSA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   //    Actividad Actual        -   Clase destino
                //Android maneja contextos, el contexto es el estado actual del usuario, es decir donde esta, el "this" significa la clase o el contexto actual,
                // mas adelante veras ejemplos donde se usa el contexto
                startActivity(new Intent(RegistrarUsuario.this, RegistrarEmpresa.class)); // si, este metodo cambiara a la siguiente ventana al presionar el boton registrar
            }
        });

        btnPERSONA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   //    Actividad Actual        -   Clase destino
                //Android maneja contextos, el contexto es el estado actual del usuario, es decir donde esta, el "this" significa la clase o el contexto actual,
                // mas adelante veras ejemplos donde se usa el contexto
                startActivity(new Intent(RegistrarUsuario.this, RegistrarPersona.class)); // si, este metodo cambiara a la siguiente ventana al presionar el boton registrar
            }
        });

        btnPROFESIONAL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   //    Actividad Actual        -   Clase destino
                //Android maneja contextos, el contexto es el estado actual del usuario, es decir donde esta, el "this" significa la clase o el contexto actual,
                // mas adelante veras ejemplos donde se usa el contexto
                startActivity(new Intent(RegistrarUsuario.this, RegistrarProfesional.class)); // si, este metodo cambiara a la siguiente ventana al presionar el boton registrar
            }
        });
    }
}
