package com.example.integrador2;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import java.util.ArrayList;

public class ProfeAdapter extends RecyclerView.Adapter<ProfeAdapter.ViewHolder> {

    ArrayList<DatosProfesional> lista;

    public ProfeAdapter(ArrayList<DatosProfesional> lista) {
        this.lista = lista;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjetadatosprofesional, parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final DatosProfesional obj = lista.get(position);

        holder.TEXTO_PROFESION.setText(obj.getProfesion());
        holder.TEXTO_NOMBRE.setText(obj.getNombre());
        holder.TEXTO_APELLIDO.setText(obj.getApellido());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView TEXTO_PROFESION;
        TextView TEXTO_NOMBRE;
        TextView TEXTO_APELLIDO;

        public ViewHolder(View itemView) {
            super(itemView);
            TEXTO_PROFESION = itemView.findViewById(R.id.textprofesion);
            TEXTO_NOMBRE = itemView.findViewById(R.id.textNombre);
            TEXTO_APELLIDO = itemView.findViewById(R.id.textApellido);
        }
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
