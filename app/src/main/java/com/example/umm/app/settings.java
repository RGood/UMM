package com.example.umm.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class settings extends Activity {

    private String currentUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            currentUserName = extras.getString("currentUserName");
        }
        setContentView(R.layout.activity_settings);
        addButtonListeners();
    }

    public String getCurrentUserName(){
        return currentUserName;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.settings, menu);
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


    public void addButtonListeners(){
        Button changePassword;
        Button sound;
        Button aboutUs;

        final Context context = this;

        changePassword = (Button) findViewById(R.id.change_password_button);
        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ChangePassword.class);
                intent.putExtra("currentUserName", currentUserName);
                Log.i("Settings", currentUserName);
                startActivity(intent);
            }
        });

        sound = (Button) findViewById(R.id.sound_button);
        sound.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent = new Intent(context, sound.class);
                startActivity(intent);
            }
        });

        aboutUs = (Button) findViewById(R.id.about_us_button);
        aboutUs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(context, aboutUs.class);
                startActivity(intent);
            }
        });


    }


}
