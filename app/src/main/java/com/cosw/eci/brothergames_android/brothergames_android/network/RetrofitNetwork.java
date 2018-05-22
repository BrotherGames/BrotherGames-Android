package com.cosw.eci.brothergames_android.brothergames_android.network;


import java.io.IOException;
import java.util.List;


import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.cosw.eci.brothergames_android.brothergames_android.data.entity.Team;
import com.cosw.eci.brothergames_android.brothergames_android.data.entity.User;
import com.cosw.eci.brothergames_android.brothergames_android.services.*;


public class RetrofitNetwork {
    private static final String BASE_URL = "https://brothergames.herokuapp.com";

    private TeamsService teamsService;

    public RetrofitNetwork() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl( BASE_URL ).addConverterFactory( GsonConverterFactory.create() ).build();
        teamsService = retrofit.create( TeamsService.class );
    }

    public void getTeams( RequestCallback<List<Team>> requestCallback ){
       try {
            Call<List<Team>> call = teamsService.getTeamsList( );
            Response<List<Team>> execute = call.execute();
            requestCallback.onSuccess( execute.body() );
        }
        catch ( IOException e ) {
            requestCallback.onFailed( new NetworkException( 0, null, e ) );
        }
    }
    public void getGame( String gamesearch, RequestCallback<List<Team>> requestCallback ){
        try {
            System.out.println("retrofil "+gamesearch);
            Call<List<Team>> call = teamsService.getGame("tera");
            Response<List<Team>> execute = call.execute();
            requestCallback.onSuccess( execute.body() );
        }
        catch ( IOException e ) {
            requestCallback.onFailed( new NetworkException( 0, null, e ) );
        }
    }
}
