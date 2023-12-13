package com.example.trabsub.controller;

import android.content.Context;

import com.example.trabsub.dao.PaisDao;

import java.util.ArrayList;

import com.example.trabsub.model.Pais;
import com.example.trabsub.retrofit.PaisDTO;
import com.example.trabsub.retrofit.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Controller {

    private Context context;
    public static void getPaises(Context context){
        try{
            retrofit2.Call<ArrayList <PaisDTO>> call = new RetrofitConfig().paisService().getPaises();
            call.enqueue(new Callback<ArrayList<PaisDTO>>() {
                @Override
                public void onResponse(Call<ArrayList<PaisDTO>> call, Response<ArrayList<PaisDTO>> response) {
                    ArrayList<PaisDTO> listaPais = response.body();

                    for (int i = 0 ; i <listaPais.size(); i++){
                        PaisDTO pais = listaPais.get(i);

                        salvar(pais.getCodigo(), pais.getDescricao(),context);

                    }
                }
                @Override
                public void onFailure(Call<ArrayList<PaisDTO>> call, Throwable t) {
                }
            });
        }catch (Exception ex){}
    }
    public static String salvar(int ID, String Descricao, Context context){
        try {
            Pais pais = new Pais();
            pais.setID(ID);
            pais.setDescricao(Descricao);
            PaisDao.getInstancia(context).insert(pais);
        } catch (Exception ex) {
            return "Erro ao gravar pais." + ex.getMessage();
        }
        return null;
    }

    public static  ArrayList<Pais> retornaPaises(Context context){
        return PaisDao.getInstancia(context).getAll();

    }

}