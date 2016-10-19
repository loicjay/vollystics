/**
 *  Copyright (c) 2016, Loïc, Dominique, Jean-Pierre Jay. All rights reserved.
 */
package com.lodojay.volleystics;

import android.app.Activity;
import android.app.NativeActivity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.lodojay.volleystics.ui.ToolbarActivity;

public class HomeActivity extends ToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setupActionBar();
    }

    public void toLiveGames(View view)
    {
        final Intent i = new Intent();
    }

    public void toStats(View view)
    {
    }

    public void toTeamActivity(View view)
    {
        final Intent i = new Intent(this, TeamActivity.class);
        startActivity(i);
    }
}
