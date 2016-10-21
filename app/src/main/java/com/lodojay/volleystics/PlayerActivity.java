/**
 * Copyright (c) 2016, Loïc, Dominique, Jean-Pierre Jay. All rights reserved.
 */
package com.lodojay.volleystics;


import android.os.Bundle;

import com.lodojay.volleystics.model.Player;
import com.lodojay.volleystics.ui.ToolbarActivity;

/**
 * The activity to enter or modify a new team player.
 */
public class PlayerActivity extends ToolbarActivity{

    public static final String PLAYER_ID = "com.lodojay.volleystics.PlayerActivity.playerId";
    public static final String TEAM_ID ="com.lodojay.volleystics.PlayerActivity.teamId";

    private long teamId;
    private long playerId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        setupActionBar();

        restore(getIntent().getExtras());
        restore(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Player player = fetchBM();

        buildUI(player);
    }

    private void restore(Bundle state) {
        if (state == null)
            return;
        playerId = state.getLong(PLAYER_ID, -1);
        teamId = state.getLong(TEAM_ID, -1);
    }

    private Player fetchBM() {

//        if (playerId > -1) {
//            return  vsf.getPlayer(playerId);
//        }
        return null;
    }

    private void buildUI(Player player) {

    }
}

