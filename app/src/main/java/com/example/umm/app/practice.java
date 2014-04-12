package com.example.umm.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
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

  /*  public void addListenerOnButtons() {
        Button backButton;

        final Context context = this;

        backButton = (Button) findViewById(R.id.button2);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, main_menu.class);
                startActivity(intent);
            }
        });
    }*/

    public void beginPractice(View v) {
        final RadioGroup radgrp = (RadioGroup) findViewById(R.id.rad);
        final RadioButton but1 = (RadioButton) findViewById(R.id.radioButton);
        final RadioButton but2 = (RadioButton) findViewById(R.id.radioButton2);
        final RadioButton but3 = (RadioButton) findViewById(R.id.radioButton3);

        int i = radgrp.getCheckedRadioButtonId();
        if(i == but1.getId()) {
            beginEasyPractice();
        } else if(i == but2.getId()) {
            beginMedPractice();
        } else if(i == but3.getId()) {
            beginHardPractice();
        } else {}
    }

    void beginEasyPractice() {

    }

    void beginMedPractice() {

    }

    void beginHardPractice() {

    }
}
