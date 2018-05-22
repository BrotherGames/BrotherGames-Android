package com.cosw.eci.brothergames_android.brothergames_android.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.cosw.eci.brothergames_android.brothergames_android.R;

/**
 * Created by 3070465 on 5/18/18.
 */

public class Profile extends Activity {

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );
        String email=(String) getIntent().getSerializableExtra("IDENT");
        TextView displayInfo=(TextView) findViewById(R.id.tv_name);
        displayInfo.setText(email);



    }






}
