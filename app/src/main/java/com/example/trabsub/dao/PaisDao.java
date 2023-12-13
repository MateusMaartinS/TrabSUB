package com.example.trabsub.dao;

import  android.content.Context;
import  android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.trabsub.helper.SQLiteDataHelper;

import java.util.ArrayList;

import com.example.trabsub.model.Pais;

public class PaisDao {

    private SQLiteOpenHelper openHelper;

    //Base de Dados
    private SQLiteDatabase bd;

    //Nome da tabela
    private String nomeTabela = "PAISES";

    //Nome das colunas da tabela
    private String[]colunas = {"ID", "PAIS"};

    private Context context;

    private static PaisDao instancia;

    public static PaisDao getInstancia(Context context){

        if(instancia == null){
            return instancia = new PaisDao(context);
        }else{
            return instancia;
        }
    }

    private  PaisDao(Context context) {
        this.context = context;

        //Abrir uma conexão da BD
        openHelper = new SQLiteDataHelper(this.context, "PAISES_BD",
                null, 1);
        //Carrega a BD e da permissão para escrever na tabela
        bd = openHelper.getWritableDatabase();
    }

    public long insert(Pais obj) {
        try{
            ContentValues valores = new ContentValues();
            valores.put(colunas[0], obj.getID());
            valores.put(colunas[1], obj.getDescricao());

            return bd.insert(nomeTabela, null, valores);

        }catch (SQLException ex){
            Log.e("ERRO", "PaisDao.insert(): "+ex.getMessage());
        }
        return 0;
    }

    public ArrayList<Pais> getAll() {
        ArrayList<Pais> lista = new ArrayList<>();
        try{
            Cursor cursor = bd.query(nomeTabela, colunas,
                    null, null, null,
                    null, colunas[0]);

            //Verifica se é possível retornar o ponteiro para
            // a primeira posição do cursor
            if(cursor.moveToFirst()){
                do{
                    Pais pais = new Pais();
                    pais.setID(cursor.getInt(0));
                    pais.setDescricao(cursor.getString(1));

                    lista.add(pais);

                }while (cursor.moveToNext());
            }
        }catch (SQLException ex){
            Log.e("ERRO", "AlunoDao.getAll(): "+ex.getMessage());
        }
        return lista;
    }

}
