package com.example.eventos.database.Entity;

import android.provider.BaseColumns;

public final class EventoEntity implements BaseColumns {

    private EventoEntity(){}

    public static final String TABLE_NAME = "evento";
    public static final String COLUNN_NAME = "nome";
    public static final String COLUNN_LOCAL = "local";
    public static final String COLUNN_DATA = "data";

}
