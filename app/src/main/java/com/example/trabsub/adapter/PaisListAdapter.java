package com.example.trabsub.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.trabsub.R;
import com.example.trabsub.model.Pais;


import java.util.ArrayList;



public class PaisListAdapter extends RecyclerView.Adapter<PaisListAdapter.PaisViewHolder>

{

    private ArrayList<Pais> listaPais;
    private Context context;

    public PaisListAdapter(ArrayList<Pais> listaPais, Context context) {
        this.listaPais = listaPais;
        this.context = context;
    }

    /**
     * Método responsável em carregar o xml para cada elemento da lista
     *
     * @return
     */
    @NonNull
    @Override
    public PaisViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listView = inflater.inflate(R.layout.itemlistpais, parent,false);

        return new PaisViewHolder(listView);
    }

    /**
     * Escrever os dados do aluno no layout
     */
    @Override
    public void onBindViewHolder(@NonNull PaisViewHolder holder, int position) {
        Pais PaisSelecionado = listaPais.get(position);

        holder.tvID.setText(String.valueOf((PaisSelecionado.getID())));
        holder.tvDesc.setText(PaisSelecionado.getDescricao());
    }

    @Override
    public int getItemCount() {
        return listaPais.size();
    }

    public class PaisViewHolder extends RecyclerView.ViewHolder{
        public TextView tvID;
        public TextView tvDesc;

        public PaisViewHolder(@NonNull View itemView) {
            super(itemView);

            this.tvID = itemView.findViewById(R.id.tvID);
            this.tvDesc = itemView.findViewById(R.id.tvDesc);
        }
    }
}
