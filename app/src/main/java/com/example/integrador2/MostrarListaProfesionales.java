package com.example.integrador2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.os.Bundle;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class MostrarListaProfesionales extends AppCompatActivity {
        private FirebaseFirestore db = FirebaseFirestore.getInstance();
        private CollectionReference notebookRef = db.collection("usuarios");

        private ProfeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_lista_profesionales);

        setUpRecyclerView();
    }

    private void setUpRecyclerView(){
        Query query = notebookRef.orderBy("profesion");

        FirestoreRecyclerOptions<DatosProfesional> options = new FirestoreRecyclerOptions.Builder<DatosProfesional>()
                .setQuery(query,DatosProfesional.class)
                .build();
        adapter = new ProfeAdapter(options);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
