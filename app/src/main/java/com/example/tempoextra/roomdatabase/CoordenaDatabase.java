package com.example.tempoextra.roomdatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {CoordenaEntity.class}, version = 1)
public abstract class CoordenaDatabase extends RoomDatabase {

    private static final String dbName = "coordenador";
    private static CoordenaDatabase coordenaDatabase;

    public static synchronized CoordenaDatabase getCoordenaDatabase(Context context) {

        if (coordenaDatabase == null) {

            coordenaDatabase = Room.databaseBuilder(context, CoordenaDatabase.class, dbName)
                    .fallbackToDestructiveMigration()
                    .build();

        }

        return coordenaDatabase;

    }

    public abstract CoordenaDao coordenaDao();

}
