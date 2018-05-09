package com.cosw.eci.brothergames_android.brothergames_android.data.dao;

import com.j256.ormlite.dao.Dao;

import com.cosw.eci.brothergames_android.brothergames_android.data.entity.Team;

/**
 * @author Santiago Carrillo
 */

public class TeamOrmLiteDao
    extends OrmLiteDao<Team, Long>
    implements TeamDao
{
    public TeamOrmLiteDao( Dao<Team, Long> dao )
    {
        super( dao, Team.class );
    }
}
