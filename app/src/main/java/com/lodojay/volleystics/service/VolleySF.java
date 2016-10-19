package com.lodojay.volleystics.service;

import android.content.Context;

import com.lodojay.volleystics.dao.VolleyDAO;
import com.lodojay.volleystics.model.Player;
import com.lodojay.volleystics.model.Team;

import java.util.List;

/**
 * Created by ljay on 15/10/2016.
 */

public class VolleySF {
    private final VolleyDAO dao;

    public VolleySF(Context context) {
        dao = new VolleyDAO(context);
    }

    public Team getTeam() {
        Team team = dao.teams().latest();
        if (team == null)
            return null;

        fillTeamPlayers(team);
        return team;
    }

    public Team createTeam(String name) {
        long id = dao.teams().create(name);
        return Team.Builder.restore(id, name).build();
    }
    public void updateTeam(long id, String name) {
        dao.teams().update(id, name);
    }
    public Team getTeam(long id) {
        Team team = dao.teams().byId(id);
        if (team == null)
            return null;

        fillTeamPlayers(team);
        return team;
    }

    public void createPlayer(Player p) {
        dao.players().createPlayer(p);
    }

    private void fillTeamPlayers(Team team) {
        List<Player.Builder> players = dao.players().byTeam(team.id);
        for (Player.Builder p : players) {
            team.addPlayer(p);
        }
    }
}

