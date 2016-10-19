package com.lodojay.volleystics.dao;

import android.content.Context;

/**
 * Created by ljay on 15/10/2016.
 */

public class VolleyDAO {
    public final Repo repo;

    public VolleyDAO(Context context) {
        this.repo = new Repo(context);
    }
    public PlayerDAO players() {
        return new PlayerDAO(repo);
    }
    public TeamDAO teams() {
        return new TeamDAO(repo);
    }
}
