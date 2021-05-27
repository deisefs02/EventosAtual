package com.example.eventos.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.eventos.database.Entity.EventoEntity;
import com.example.eventos.modelo.Evento;

import java.util.ArrayList;
import java.util.List;

public class EventoDAO {

    private final String SQL_LISTAR_TODOS = "SELECT * FROM " + EventoEntity.TABLE_NAME;
    private DBGateway dbGateway;

    public EventoDAO(Context context){
        dbGateway = DBGateway.getInstance(context);
    }

    public boolean salvar(Evento evento){
        ContentValues contentValues = new ContentValues();
        contentValues.put(EventoEntity.COLUNN_NAME, evento.getNome());
        contentValues.put(EventoEntity.COLUNN_LOCAL, evento.getLocal());
        contentValues.put(EventoEntity.COLUNN_DATA, evento.getData());
        long id = dbGateway.getDatabase().insert(EventoEntity.TABLE_NAME,
                null, contentValues);
        return id > 0;
    }

    public List<Evento> listar() {
        List<Evento> eventos = new ArrayList<>();
        Cursor cursor = dbGateway.getDatabase().rawQuery(SQL_LISTAR_TODOS, null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex(EventoEntity._ID));
            String nome = cursor.getString(cursor.getColumnIndex(EventoEntity.COLUNN_NAME));
            String local = cursor.getString(cursor.getColumnIndex(EventoEntity.COLUNN_LOCAL));
            String data = cursor.getString(cursor.getColumnIndex(EventoEntity.COLUNN_DATA));
            eventos.add(new Evento(id, nome, local, data));
        }
        cursor.close();
        return eventos;
    }
}
