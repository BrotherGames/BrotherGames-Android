package com.cosw.eci.brothergames_android.brothergames_android.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cosw.eci.brothergames_android.brothergames_android.R;
import com.cosw.eci.brothergames_android.brothergames_android.data.OrmModel;
import com.cosw.eci.brothergames_android.brothergames_android.data.entity.Team;
import com.cosw.eci.brothergames_android.brothergames_android.network.NetworkException;
import com.cosw.eci.brothergames_android.brothergames_android.network.RequestCallback;
import com.cosw.eci.brothergames_android.brothergames_android.network.RetrofitNetwork;
import com.cosw.eci.brothergames_android.brothergames_android.ui.adapter.TeamsAdapter;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private OrmModel ormModel;


    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.home_activity );
        recyclerView = (RecyclerView) findViewById( R.id.recyclerView );
        configureRecyclerView();
        //createTeamLocalDB();
        //getAllTeamsLocalDB();
        ConectToApiNetwork ca = new ConectToApiNetwork();
    }


    private void configureRecyclerView() {
        recyclerView = (RecyclerView) findViewById( R.id.recyclerView );
        recyclerView.setHasFixedSize( true );
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager( this );
        recyclerView.setLayoutManager( layoutManager );

    }



    private class ConectToApiNetwork{
        RetrofitNetwork rfN;
        ExecutorService executorService;
        private List<Team> teams;


        public ConectToApiNetwork() {
            rfN = new RetrofitNetwork();
            executorService = Executors.newFixedThreadPool(1);
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    rfN.getTeams(new RequestCallback<List<Team>>() {
                        @Override
                        public void onSuccess(List<Team> response) {
                            teams = response;
                        }

                        @Override
                        public void onFailed(NetworkException e) {
                            e.printStackTrace();
                        }
                    });
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            recyclerView.setAdapter(new TeamsAdapter(teams));
                        }
                    });
                }
            });
        }





    }
}
