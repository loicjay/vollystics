package com.lodojay.volleystics.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ljay on 15/10/2016.
 */
class Repo extends SQLiteOpenHelper {
    private static final String DB_NAME="VOLLYSTICS";
    private static final int DB_VERSION=2;

    public Repo(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public SQLiteDatabase ro() {
        return getReadableDatabase();
    }
    public SQLiteDatabase rw() {
        return getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TEAM_CREATE_TABLE);
        db.execSQL(PLAYER_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static final class PLAYER {
        public static final String TABLE = "player";
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String ROLE = "role";
        public static final String TEAM = "team";
    }
    private static final String PLAYER_CREATE_TABLE = "CREATE TABLE player("+
            "id INTEGER PRIMARY KEY,"+
            "name TEXT,"+
            "role TEXT," +
            "team INTEGER," +
            "FOREIGN KEY(team) REFERENCES team(id))";
    public static final class TEAM {
        public static final String TABLE = "team";
        public static final String ID = "id";
        public static final String NAME = "name";
    }
    private static final String TEAM_CREATE_TABLE = "CREATE TABLE team("+
            "id INTEGER PRIMARY KEY,"+
            "name TEXT)";
}
