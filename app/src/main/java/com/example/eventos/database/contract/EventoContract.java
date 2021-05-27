package com.example.eventos.database.contract;

import com.example.eventos.database.Entity.EventoEntity;

public final class EventoContract {

    private EventoContract(){}

    public static final String criarTabela(){
        return "CREATE TABLE " + EventoEntity.TABLE_NAME + " (" +
                EventoEntity._ID + " INTEGER PRIMARY KEY," +
                EventoEntity.COLUNN_NAME + " TEXT," +
                EventoEntity.COLUNN_LOCAL + " TEXT," +
                EventoEntity.COLUNN_DATA + " TEXT)";
    }

    public static final String removerTabela(){
        return "DROP TABLE IF EXISTS " + EventoEntity.TABLE_NAME;
    }
}
