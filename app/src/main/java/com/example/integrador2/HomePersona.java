package com.example.integrador2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomePersona extends AppCompatActivity {
    public static final String user="nombre" ;

    TextView txtuserPerso;
    Button botonMostrarDatosProfesional;
    TextView editarConsulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_persona);

        botonMostrarDatosProfesional = findViewById(R.id.btnMostrarDatosProfesional);
        editarConsulta = findViewById(R.id.editConsulta);

        botonMostrarDatosProfesional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePersona.this,MostrarListaProfesionales.class));
            }
        });

    recibirDatosPersona();

    }

    private void recibirDatosPersona(){
        Bundle extrasP = getIntent().getExtras();
        String d1 = extrasP.getString("nombre");



        txtuserPerso = (TextView) findViewById(R.id.textuserPerso);
        txtuserPerso.setText("BIENVENIDO  "+d1);


    }
}
