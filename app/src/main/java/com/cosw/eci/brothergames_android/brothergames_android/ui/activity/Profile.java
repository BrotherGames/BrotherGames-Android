package com.cosw.eci.brothergames_android.brothergames_android.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.cosw.eci.brothergames_android.brothergames_android.R;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //View header = ((NavigationView)findViewById(R.id.nav_view)).getHeaderView(0);
        String email=(String) getIntent().getSerializableExtra("IDENTNAME");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView displayInfo=(TextView)findViewById(R.id.textView_email);
               displayInfo.setText(email);
    }

}
