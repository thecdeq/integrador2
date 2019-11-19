package com.example.integrador2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomeProfesional extends AppCompatActivity {

    TextView txtuserProfe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_profesional);

        recibitDatosProfesional();
    }

        private void recibitDatosProfesional(){

            Bundle extrasPRO = getIntent().getExtras();
            String d3 = extrasPRO.getString("nombrePRO");



            txtuserProfe = (TextView) findViewById(R.id.txtuserProfe);
            txtuserProfe.setText("BIENVENIDO  "+d3);
        }
}
