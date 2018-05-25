package com.cactus_team.testfinallllllll;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.KeyEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;

import java.util.HashMap;
import java.util.zip.Inflater;

import static com.cactus_team.testfinallllllll.R.drawable.abc_vector_test;
import static com.cactus_team.testfinallllllll.R.drawable.grey;
import static com.cactus_team.testfinallllllll.R.drawable.ic_menu_camera;
import static com.cactus_team.testfinallllllll.R.drawable.qr;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    int Curent_page=R.id.signup_page;
    int back_page=R.id.signup_page;
    boolean exit_page=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_launcher_round); // just setNavigationIcon
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        SliderLayout mDemoSlider = (SliderLayout) findViewById(R.id.slider);

        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("t1", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
        url_maps.put("t2", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
        url_maps.put("t3", "https://api.shanstakhfif.com/coinnnnn.png");


        for(String name : url_maps.keySet()){
            DefaultSliderView textSliderView = new DefaultSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);
            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);
            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Default);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setDuration(3000);
        mDemoSlider.setIndicatorVisibility(PagerIndicator.IndicatorVisibility.Invisible);
        
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Typeface tf= Typeface.createFromAsset(getAssets(),"IRANSans_Bold.ttf");

        //TextView text1 = (TextView) findViewById(R.id.testcontent);
        //text1.setTypeface(tf);
        //text1.setText("شانص");

        View headerView = navigationView.getHeaderView(0);
        TextView text2 = (TextView) headerView.findViewById(R.id.l1);
        text2.setText("پوریا افضلی");
        text2.setTypeface(tf);

        TextView text3 = (TextView) headerView.findViewById(R.id.l2);
        text3.setText("اعتبار کیف پول : ۲۰۰،۰۰۰ تومان");
        text3.setTypeface(tf);

        TextView toolbar_title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        //toolbar_title.setText("اعتبار کیف پول : ۲۰۰،۰۰۰ تومان");
        toolbar_title.setTypeface(tf);

        //MyTextView.generateViewId();
    }

    boolean doubleBackToExitPressedOnce;

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            if(Curent_page!=R.id.signup_page){
                LinearLayout newpage = (LinearLayout) findViewById(back_page);
                LinearLayout oldpage = (LinearLayout) findViewById(Curent_page);
                oldpage.setVisibility(View.INVISIBLE);
                newpage.setVisibility(View.VISIBLE);
                int Temp=back_page;
                back_page=Curent_page;
                Curent_page=Temp;
                return;
            }else {
                if (doubleBackToExitPressedOnce) {
                    finish();
                    return;
                }

                this.doubleBackToExitPressedOnce = true;
                Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        doubleBackToExitPressedOnce = false;
                    }
                }, 2000);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
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
        int id = item.getItemId();
        showpage(id);
        back_page=R.id.signup_page;
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (Integer.parseInt(android.os.Build.VERSION.SDK) > 5
                && keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {
            onBackPressed();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void showpage(int id){
        LinearLayout newpage = (LinearLayout) findViewById(id);
        LinearLayout oldpage = (LinearLayout) findViewById(Curent_page);
        oldpage.setVisibility(View.INVISIBLE);
        newpage.setVisibility(View.VISIBLE);
        back_page=Curent_page;
        Curent_page=id;
    }

}
