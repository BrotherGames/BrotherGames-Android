package com.cosw.eci.brothergames_android.brothergames_android.data;

/**
 * @author Santiago Carrillo
 */

public class DBException
    extends Exception
{
    public DBException(String detailMessage, Throwable throwable )
    {
        super( detailMessage, throwable );
    }
}
