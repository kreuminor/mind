package jm.mind.mobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import jm.mind.mobile.apply.ApplyActivity;
import jm.mind.mobile.calender.AnnounceActivity;
import jm.mind.mobile.courses.CourseActivity;
import jm.mind.mobile.faq.FaqActivity;
import jm.mind.mobile.evaluation.Registration;
import jm.mind.mobile.products.ProductActivity;
import jm.mind.mobile.social.FacebookActivity;
import jm.mind.mobile.social.TweetActivity;
import jm.mind.mobile.social.YoutubeActivity;
import jm.mind.mobile.speaker.SpeakerActivity;
import jm.mind.mobile.vacancy.VacancyActivity;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    FragmentTransaction fragmentTransaction;
    FloatingActionButton fab_plus, fab_twitter, fab_facebook, fab_youtube;
    Animation FabOpen, FabClose, FabRClockwise, FabRAntiClockwise;
    boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(MainActivity.this);

        //Home Page

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frame, new HomeFragment());
        fragmentTransaction.commit();


    }

    boolean doubleBackPressed = false;

    @Override
    public void onBackPressed() {

        if (doubleBackPressed) {

            super.onBackPressed();
        } else {
            doubleBackPressed = true;
            final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

            Snackbar.make(drawerLayout, getString(R.string.pressbackagain), Snackbar.LENGTH_SHORT).show();
            new android.os.Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackPressed = false;
                }
            }, 2500);


        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_more) {
            startActivity(new Intent(this, AboutActivity.class));
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")

    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_schedule) {

            Intent intent = new Intent(MainActivity.this, ScheduleActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            item.setChecked(true);
            finish();

        } else if (id == R.id.nav_location) {

            Intent intent = new Intent(MainActivity.this, Maps2Activity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            item.setChecked(true);
            finish();

        } else if (id == R.id.nav_question) {

            Intent intent = new Intent(MainActivity.this, FaqActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            item.setChecked(true);
            finish();

        } else if (id == R.id.nav_conference) {

            Intent intent = new Intent(MainActivity.this, ConferenceMain.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            item.setChecked(true);
            finish();
        }else if (id == R.id.nav_about) {

            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            item.setChecked(true);
            finish();
        }else if (id == R.id.nav_call) {

            Intent intent = new Intent(MainActivity.this, ContactActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            item.setChecked(true);
            finish();

        }else if (id == R.id.nav_app) {

            Intent intent = new Intent(MainActivity.this, ApplyActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            item.setChecked(true);
            finish();

        }else if (id == R.id.nav_courses) {

            Intent intent = new Intent(MainActivity.this, CourseActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            item.setChecked(true);
            finish();

        }else if (id == R.id.nav_products) {

            Intent intent = new Intent(MainActivity.this, ProductActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            item.setChecked(true);
            finish();

        }else if (id == R.id.nav_cal) {

            Intent intent = new Intent(MainActivity.this, AnnounceActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            item.setChecked(true);
            finish();

        }else if (id == R.id.nav_job) {

            Intent intent = new Intent(MainActivity.this, VacancyActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            item.setChecked(true);
            finish();

        }
/*
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
        return true;
    }

}
