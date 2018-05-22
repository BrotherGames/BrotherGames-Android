package com.cosw.eci.brothergames_android.brothergames_android.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.cosw.eci.brothergames_android.brothergames_android.R;
import com.cosw.eci.brothergames_android.brothergames_android.data.entity.Team;
import com.cosw.eci.brothergames_android.brothergames_android.network.NetworkException;
import com.cosw.eci.brothergames_android.brothergames_android.network.RequestCallback;
import com.cosw.eci.brothergames_android.brothergames_android.network.RetrofitNetwork;
import com.cosw.eci.brothergames_android.brothergames_android.ui.adapter.TeamsAdapter;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class games extends AppCompatActivity {


    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);
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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = (RecyclerView) findViewById( R.id.recyclerView);
        configureRecyclerView();

        games.ConectToApiNetwork ca = new games.ConectToApiNetwork();
        //hola


    }


    private void configureRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

    }

    private class ConectToApiNetwork {
        RetrofitNetwork rfN;
        ExecutorService executorService;
        private List<Team> teamList;

        public ConectToApiNetwork() {
            rfN = new RetrofitNetwork();
            executorService = Executors.newFixedThreadPool(1);
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    rfN.getGame((String) getIntent().getSerializableExtra("namegame"), new RequestCallback<List<Team>>() {
                        @Override
                        public void onSuccess(List<Team> response) {
                            teamList = response;
                        }

                        @Override
                        public void onFailed(NetworkException e) {
                            e.printStackTrace();
                        }
                    });
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            recyclerView.setAdapter(new TeamsAdapter(teamList));
                        }
                    });
                }
            });
        }


    }
}