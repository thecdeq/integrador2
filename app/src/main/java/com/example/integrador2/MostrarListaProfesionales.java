package com.example.integrador2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.ArrayList;

import javax.annotation.Nullable;

public class MostrarListaProfesionales extends AppCompatActivity {
        private FirebaseFirestore db = FirebaseFirestore.getInstance();

        private ProfeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_lista_profesionales);

         db.collection("usuarios").whereEqualTo("tipo","profesional")
            .addSnapshotListener(new EventListener<QuerySnapshot>() {

            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                    ArrayList<DatosProfesional> arreglo = new ArrayList<DatosProfesional>();

                for(DocumentSnapshot documento : queryDocumentSnapshots.getDocuments()){
                    DatosProfesional obj = new DatosProfesional(documento.get("nombre").toString(),documento.get("apellido").toString(),documento.get("profesion").toString(),documento.get("tipo").toString());
                    arreglo.add(obj);
                }

                adapter = new ProfeAdapter(arreglo);
                RecyclerView recyclerView = findViewById(R.id.recycler_view);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                recyclerView.setAdapter(adapter);
            }
        });

        //"for each" - Investigalo, es bastante util :D


    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
