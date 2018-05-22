package com.cosw.eci.brothergames_android.brothergames_android.services;

import com.cosw.eci.brothergames_android.brothergames_android.data.entity.Team;

import java.util.List;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface TeamsService {

    @GET( "/searchGame/games" )
    Call<List<Team>> getTeamsList();
    @GET( "/searchGame/{gamesearch}" )
    Call<List<Team>> getGame(@Path("gamesearch") String gamesearch);
}
