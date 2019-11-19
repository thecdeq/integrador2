package com.example.integrador2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.os.Bundle;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class MostrarListaProfesionales extends AppCompatActivity {

    RecyclerView recyclerViewDatosProfesional;
    ProfesionalAdapter mProAdapter;
    FirebaseFirestore mfirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_lista_profesionales);

        recyclerViewDatosProfesional = findViewById(R.id.recyclerDatosProfesionales);
        recyclerViewDatosProfesional.setLayoutManager(new LinearLayoutManager(this));
        mfirestore =  FirebaseFirestore.getInstance();

        Query query = mfirestore.collection("usuarios");

        FirestoreRecyclerOptions<DatosProfesional> firestoreRecyclerOptions  = new FirestoreRecyclerOptions.Builder<DatosProfesional>()
                    .setQuery(query,DatosProfesional.class).build();

        mProAdapter = new ProfesionalAdapter(firestoreRecyclerOptions);
        mProAdapter.notifyDataSetChanged();

        recyclerViewDatosProfesional.setAdapter(mProAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();

        mProAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mProAdapter.stopListening();
    }
}
