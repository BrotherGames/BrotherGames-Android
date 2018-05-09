package com.cosw.eci.brothergames_android.brothergames_android.data;

import android.content.Context;

import com.cosw.eci.brothergames_android.brothergames_android.data.dao.TeamDao;

/**
 * @author Santiago Carrillo
 */

public interface Model
{
    void init(Context context);

    TeamDao getTeamDao();
}
