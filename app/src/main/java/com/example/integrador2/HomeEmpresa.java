package com.example.integrador2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomeEmpresa extends AppCompatActivity {

    TextView txtuserEm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_empresa);

        recibirDatosEmpresa();
    }

    private void recibirDatosEmpresa(){
        Bundle extrasE = getIntent().getExtras();
        String d2 = extrasE.getString("nombreE");



        txtuserEm = (TextView) findViewById(R.id.txtuserEm);
        txtuserEm.setText("BIENVENIDO  "+d2);

    }
}
