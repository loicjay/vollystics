/**
 *  Copyright (c) 2016, Loïc, Dominique, Jean-Pierre Jay. All rights reserved.
 */
package com.lodojay.volleystics.ui;

import android.app.Activity;
import android.app.NativeActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.lodojay.volleystics.R;
import com.lodojay.volleystics.service.VolleySF;

/**
 * Created by ljay on 12/10/2016.
 */
public abstract class ToolbarActivity extends AppCompatActivity {

    protected VolleyPrefs prefs;
    protected VolleySF vsf;

    protected void setupActionBar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.vls_action_bar);
        setSupportActionBar(myToolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        vsf = new VolleySF(this);
        prefs = new VolleyPrefs(this);


    }
}
