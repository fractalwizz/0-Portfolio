package com.fract.nano.williamyoung.portfolio;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view) {
        Context context = getApplicationContext();

        String notif = "";
        switch (view.getId())
        {
            case R.id.movie_btn:
                notif = "com.fract.nano.williamyoung.popularmovies";
                break;
            case R.id.scores_btn:
                //notif = "Scores App";
                break;
            case R.id.library_btn:
                //notif = "Library App";
                break;
            case R.id.xyz_btn:
                //notif = "XYZ Reader";
                break;
            case R.id.capstone_btn:
                //notif = "Capstone Project";
                break;
        }

        Intent i;
        PackageManager manager = getPackageManager();
        try {
            i = manager.getLaunchIntentForPackage(notif);
            if (i == null)
                throw new PackageManager.NameNotFoundException();
            i.addCategory(Intent.CATEGORY_LAUNCHER);
            startActivity(i);
        } catch (PackageManager.NameNotFoundException e) { Log.e("PackageManager", e.getMessage()); }

        //Toast.makeText(context, notif + " will launch", Toast.LENGTH_SHORT).show();
    }
}