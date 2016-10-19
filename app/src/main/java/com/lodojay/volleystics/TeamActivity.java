/**
 *  Copyright (c) 2016, Loïc, Dominique, Jean-Pierre Jay. All rights reserved.
 */
package com.lodojay.volleystics;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.lodojay.volleystics.model.Player;
import com.lodojay.volleystics.model.Team;
import com.lodojay.volleystics.service.VolleySF;
import com.lodojay.volleystics.ui.ToolbarActivity;
import com.lodojay.volleystics.ui.VolleyPrefs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.Inflater;

public class TeamActivity extends ToolbarActivity {

    private VolleyPrefs prefs;
    private VolleySF vsf;

    private Team team;

    private TextView nameField;
    private RecyclerView playersView;

    private final String[] players = new String[]{
            "Cyril",
            "Fred",
            "Lison",
            "Nico",
    };

    private ListView playersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        setupActionBar();

        nameField = (TextView) findViewById(R.id.nameField);
        playersView = (RecyclerView) findViewById(R.id.playersList);

        vsf = new VolleySF(this);
        prefs = new VolleyPrefs(this);

        ((FloatingActionButton)findViewById(R.id.fab)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        fetchBM();

        buildUI();
    }

    private void fetchBM() {
        long teamId = prefs.getTeamId();
        if (teamId < 0) {
            team = vsf.getTeam();
        } else {
            team = vsf.getTeam(teamId);
        }
        if (team == null) {
            team = vsf.createTeam("");
        }
        prefs.setTeamId(team.id);
    }

    private void onAddPlayer(View view){

    }

    private void buildUI() {
        nameField.setText(team.name);
        setupPlayerList();
    }

    private void setupPlayerList() {
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        //playersView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager=new LinearLayoutManager(this);
        playersView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        PlayersAdapter mAdapter=new PlayersAdapter(team.players);

        playersView.setAdapter(mAdapter);
    }

    private static class PlayersAdapter  extends RecyclerView.Adapter<PlayersAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // create a new view
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.player_list_item, parent, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final boolean empty = position >= data.size();

            final ImageView icon = (ImageView)holder.itemView.findViewById(R.id.playerImage);
            icon.setVisibility(empty ? View.INVISIBLE : View.VISIBLE);

            final TextView text = (TextView) holder.itemView.findViewById(R.id.playerName);
            String textValue;
            if (!empty) {
                textValue = data.get(position).name;
            } else {
                textValue = text.getContext().getString(R.string.no_player);
            }
            text.setText(textValue);

            final View check = holder.itemView.findViewById(R.id.playerCheck);
            check.setVisibility(empty ? View.INVISIBLE : View.VISIBLE);
        }

        @Override
        public int getItemCount() {
            return Math.max(1, data.size());
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            public ViewHolder(View itemView) {
                super(itemView);
            }
        }

        public PlayersAdapter(List<Player> players) {
            this.data = players;
        }

        private List<Player> data;
    }
}
