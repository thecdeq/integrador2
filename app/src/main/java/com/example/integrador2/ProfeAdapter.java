package com.example.integrador2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class ProfeAdapter extends FirestoreRecyclerAdapter<DatosProfesional, ProfeAdapter.ProfesHolder> {

    public ProfeAdapter(@NonNull FirestoreRecyclerOptions<DatosProfesional> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ProfesHolder holder, int position, @NonNull DatosProfesional model) {
        holder.TEXTO_PROFESION.setText(model.getProfesion());
        holder.TEXTO_NOMBRE.setText(model.getNombre());
        holder.TEXTO_APELLIDO.setText(model.getApellido());
    }

    @NonNull
    @Override
    public ProfesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjetadatosprofesional,
                 parent,false);
        return new ProfesHolder(v);
    }

    class ProfesHolder extends RecyclerView.ViewHolder{
        TextView TEXTO_PROFESION;
        TextView TEXTO_NOMBRE;
        TextView TEXTO_APELLIDO;

        public ProfesHolder(@NonNull View itemView) {
            super(itemView);
            TEXTO_PROFESION = itemView.findViewById(R.id.textprofesion);
            TEXTO_NOMBRE = itemView.findViewById(R.id.textNombre);
            TEXTO_APELLIDO = itemView.findViewById(R.id.textApellido);

        }
    }
}
