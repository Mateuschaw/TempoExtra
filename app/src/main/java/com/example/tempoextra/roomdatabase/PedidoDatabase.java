package com.example.tempoextra.roomdatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {PedidoEntity.class}, version = 1)
public abstract class PedidoDatabase extends RoomDatabase {

    private static final String dbName = "pedido";
    private static PedidoDatabase pedidoDatabase;

    public static synchronized PedidoDatabase getPedidoDatabase(Context context) {

        if (pedidoDatabase == null) {

            pedidoDatabase = Room.databaseBuilder(context, PedidoDatabase.class, dbName)
                    .fallbackToDestructiveMigration()
                    .build();

        }

        return pedidoDatabase;

    }

    public abstract PedidoDao pedidoDao();

}
