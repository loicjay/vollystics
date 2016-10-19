package com.lodojay.volleystics.ui;

import android.content.Context;
import android.content.SharedPreferences;

import com.lodojay.volleystics.model.Team;

/**
 * Created by ljay on 18/10/2016.
 */

public class VolleyPrefs {
    private static final String SESSION = "com.lodojay.volleystics.SESSION";

    private static final String TEAM_ID = "team.id";

    private final SharedPreferences session;

    public VolleyPrefs(Context context) {
        this.session = context.getSharedPreferences(SESSION, Context.MODE_PRIVATE);
    }

    public void setTeamId(long teamId) {
        SharedPreferences.Editor editor = session.edit();
        editor.putLong(TEAM_ID, teamId);
        editor.commit();
    }
    public long getTeamId() {
        return session.getLong(TEAM_ID, -1);
    }

}