package com.cosw.eci.brothergames_android.brothergames_android.network;



public interface RequestCallback<T>{

    void onSuccess(T response);

    void onFailed(NetworkException e);
}
