package edu.sti.stats;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        switchFragment(new DashboardFragment());

        findViewById(R.id.dashboardButton).setBackgroundColor(getResources().getColor(R.color.dark_selected));

        findViewById(R.id.dashboardButton)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        switchFragment(new DashboardFragment());
                        findViewById(R.id.dashboardButton).setBackgroundColor(getResources().getColor(R.color.dark_selected));
                        findViewById(R.id.attendanceButton).setBackgroundColor(getResources().getColor(R.color.gray));
                        findViewById(R.id.recordingSheetButton).setBackgroundColor(getResources().getColor(R.color.gray));
                    }
                });
        findViewById(R.id.attendanceButton)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        switchFragment(new AttendanceFragment());
                        findViewById(R.id.attendanceButton).setBackgroundColor(getResources().getColor(R.color.dark_selected));
                        findViewById(R.id.dashboardButton).setBackgroundColor(getResources().getColor(R.color.gray));
                        findViewById(R.id.recordingSheetButton).setBackgroundColor(getResources().getColor(R.color.gray));
                    }
                });
        findViewById(R.id.recordingSheetButton)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        switchFragment(new RecordingSheetFragment());
                        findViewById(R.id.recordingSheetButton).setBackgroundColor(getResources().getColor(R.color.dark_selected));
                        findViewById(R.id.attendanceButton).setBackgroundColor(getResources().getColor(R.color.gray));
                        findViewById(R.id.dashboardButton).setBackgroundColor(getResources().getColor(R.color.gray));
                    }
                });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

         navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.getMenu().getItem(0).getSubMenu().getItem(0).setChecked(true);

        /*        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    public void switchFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_frame_layout,fragment)
                .commit();
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        navigationView.getMenu().getItem(0).getSubMenu().getItem(0).setChecked(false);

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_maintenance) {

        } else if (id == R.id.nav_utilities) {
            startActivity(new Intent(this,ScoreActivity.class));
        } else if (id == R.id.nav_reports) {
            startActivity(new Intent(this,Score.class));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
