package com.cosw.eci.brothergames_android.brothergames_android.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cosw.eci.brothergames_android.brothergames_android.R;
import com.cosw.eci.brothergames_android.brothergames_android.data.entity.User;
import com.cosw.eci.brothergames_android.brothergames_android.database.DatabaseManagerUser;
import com.cosw.eci.brothergames_android.brothergames_android.ui.activity.Exchanges;
import com.cosw.eci.brothergames_android.brothergames_android.ui.activity.SettingsActivity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private DatabaseManagerUser databaseManagerUser;
    private User itemUsuario;
    private String ident2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //final Intent intentbusqueda = new Intent(getApplication(),games.class);
       String email=(String) getIntent().getSerializableExtra("IDENT");
        String user=(String) getIntent().getSerializableExtra("IDENTNAME");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button buscarJuego= (Button) findViewById(R.id.searchgame);
         //TextView busqueda = (TextView) findViewById(R.id.videojuego);
        //EditText busqueda = (EditText) findViewById(R.id.videojuego);
        buscarJuego.setOnClickListener(new View.OnClickListener() {
            EditText busqueda = (EditText) findViewById(R.id.videojuego);
            Intent intentbusqueda = new Intent(getApplication(),games.class);
            public void onClick(View v) {
                //EditText busqueda = (EditText) findViewById(R.id.videojuego);
                //intentbusqueda = new Intent(getApplicationContext(),games.class);
                System.out.println("Main "+busqueda.getText());
                intentbusqueda.putExtra("gamesearch", busqueda.getText());
                System.out.println("Main "+intentbusqueda.getSerializableExtra("gamesearch"));
                startActivity(intentbusqueda);
            }
        });

      //  databaseManagerUser= new DatabaseManagerUser(getApplicationContext());
    // itemUsuario = databaseManagerUser.getUsuario(user);
     View header = ((NavigationView)findViewById(R.id.nav_view)).getHeaderView(0);
     ((TextView) header.findViewById(R.id.tv_nombre_usuario_menu)).setText(user);
        ((TextView) header.findViewById(R.id.tv_correo_menu)).setText(email);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent intent1 = new Intent(getApplicationContext(), prueba.class);
            startActivity(intent1);

        } else if (id == R.id.nav_profile) {
            Intent intent3=new Intent(getApplicationContext(),Profile.class);
            startActivity(intent3);
        } else if (id == R.id.nav_mychanges) {
            Intent intent = new Intent(getApplicationContext(), Exchanges.class);
            startActivity(intent);

        }else if(id==R.id.nav_logout){
            finish();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
