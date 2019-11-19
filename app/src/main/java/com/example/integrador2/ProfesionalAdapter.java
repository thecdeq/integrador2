package com.example.integrador2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class ProfesionalAdapter extends FirestoreRecyclerAdapter<DatosProfesional, ProfesionalAdapter.ViewHolder> {

     /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public ProfesionalAdapter(@NonNull FirestoreRecyclerOptions<DatosProfesional> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull DatosProfesional datosProfesional) {
    holder.textprofesion.setText(datosProfesional.getProfesion());
    holder.textNombre.setText(datosProfesional.getNombre());
    holder.textApellido.setText(datosProfesional.getApellido());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tarjetadatosprofesional,viewGroup,false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textprofesion;
        TextView textNombre;
        TextView textApellido;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textprofesion = itemView.findViewById(R.id.textprofesion);
            textNombre = itemView.findViewById(R.id.textNombre);
            textApellido = itemView.findViewById(R.id.textApellido);
        }
    }
}
