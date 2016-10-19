package com.lodojay.volleystics.dao;

import android.content.ContentValues;
import android.database.Cursor;

import com.lodojay.volleystics.model.Team;
import static com.lodojay.volleystics.dao.Repo.TEAM.TABLE;
import static com.lodojay.volleystics.dao.Repo.TEAM.ID;
import static com.lodojay.volleystics.dao.Repo.TEAM.NAME;

/**
 * Created by ljay on 15/10/2016.
 */
public class TeamDAO {
    private Repo repo;

    public TeamDAO(Repo repo) {
        this.repo = repo;
    }

    public long create(String name) {
        ContentValues c = new ContentValues();
        c.put(NAME,name);
        return repo.rw().insert(TABLE, null, c);
    }

    public long update(long id, String name ) {
        ContentValues c = new ContentValues();
        c.put(NAME, name);
        return repo.rw().update(TABLE, c, "id=?", new String[] {String.valueOf(id)});
    }

    public Team latest() {
        Cursor r = repo.ro().rawQuery("SELECT id,name FROM team", new String[0]);

        if (r.moveToFirst())
            return Team.Builder.restore(r.getLong(0), r.getString(1)).build();

        return null;
    }
    public Team byId(long id) {
        Cursor r = repo.ro().rawQuery("SELECT id,name FROM team where id=?",
                new String[] {String.valueOf(id)});

        if (r.moveToFirst())
            return Team.Builder.restore(r.getLong(0), r.getString(1)).build();

        return null;
    }
}
