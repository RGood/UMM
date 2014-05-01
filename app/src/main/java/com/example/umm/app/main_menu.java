package com.example.umm.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class main_menu extends Activity {

    String currentUserName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            currentUserName = extras.getString("currentUserName");
        }
        setContentView(R.layout.activity_main);
        addListenerOnButtons();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
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

    public void addListenerOnButtons(){
        Button challenge_button;
        Button practice_button;
        Button leaderboard_button;
        Button settings_button;
        Button logout_button;

        final Context context = this;
        challenge_button = (Button) findViewById(R.id.challenge_button);

        challenge_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Challenge.class);
                intent.putExtra("currentUserName", currentUserName);
                startActivity(intent);
            }
        });

        practice_button = (Button) findViewById(R.id.practice_button);
        practice_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, practice.class);
                intent.putExtra("currentUserName", currentUserName);
                startActivity(intent);
            }
        });

        settings_button = (Button) findViewById(R.id.settings_button);
        settings_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, settings.class);
                intent.putExtra("currentUserName", currentUserName);
                Log.i("Main Menu", currentUserName);
                startActivity(intent);
            }
        });

        logout_button = (Button) findViewById(R.id.logout_button);
        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, login_menu.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        leaderboard_button = (Button) findViewById(R.id.leaderboard_button);
        leaderboard_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, LeaderboardMenu.class);
                intent.putExtra("currentUserName", currentUserName);
                startActivity(intent);
            }
        });
    }



}
