package com.cosw.eci.brothergames_android.brothergames_android.services;

import com.cosw.eci.brothergames_android.brothergames_android.data.entity.Team;

import java.util.List;


import retrofit2.Call;
import retrofit2.http.GET;


public interface TeamsService {

    @GET( "teams.json" )
    Call<List<Team>> getTeamsList();
}
