package com.example.umm.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;

public class practice extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practice);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.layout.practice, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void beginPractice(View v) {
        final RadioGroup radgrp = (RadioGroup)findViewById(R.id.rad);
        int i = radgrp.getCheckedRadioButtonId();
        if(i == 1) {
            beginEasyPractice();
        } else if(i == 2) {
            beginMedPractice();
        } else if(i == 3) {
            beginHardPractice();
        } else {}
    }

    void beginEasyPractice() {

    }

    void beginMedPractice() {

    }

    void beginHardPractice() {

    }

    public void logout(View v) {
        new login_menu();
    }

    public void toMainMenu() {
        new main_menu();
    }

}
