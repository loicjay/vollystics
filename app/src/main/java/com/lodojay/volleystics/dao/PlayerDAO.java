package com.lodojay.volleystics.dao;

import android.content.ContentValues;
import android.database.Cursor;

import com.lodojay.volleystics.model.Player;
import com.lodojay.volleystics.model.Team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.lodojay.volleystics.dao.Repo.PLAYER.NAME;
import static com.lodojay.volleystics.dao.Repo.PLAYER.ROLE;
import static com.lodojay.volleystics.dao.Repo.PLAYER.TABLE;
import static com.lodojay.volleystics.dao.Repo.PLAYER.TEAM;

/**
 * Created by ljay on 15/10/2016.
 */

public class PlayerDAO {

    private Repo repo;

    public PlayerDAO(Repo repo) {
        this.repo = repo;
    }

    public long createPlayer(Player player) {
        ContentValues c = new ContentValues();
        c.put(NAME,player.name);
        c.put(ROLE,player.role.name());
        c.put(TEAM, player.team.id);
        return repo.rw().insert(TABLE, null, c);
    }

    public void deletePlayer(long playerId) {
        repo.rw().delete(TABLE, "id = ?", new String[] {String.valueOf(playerId)});
    }

    public List<Player.Builder> byTeam(long teamId) {
        Cursor r = repo.ro().rawQuery("SELECT id,name,role FROM player where team=?",
                new String[]{Long.toString(teamId)});
        if (!r.moveToFirst())
            return Collections.emptyList();

        List<Player.Builder> players = new ArrayList<>();
        do {
            players.add(Player.Builder.restore(
                    r.getLong(0),
                    r.getString(1),
                    Player.Role.valueOf(r.getString(2))));
        } while (r.moveToNext());

        return players;
    }
}
