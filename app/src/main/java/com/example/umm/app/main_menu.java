package com.example.umm.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class main_menu extends Activity {

    Button challenge_button;
    Button practice_button;
    Button leaderboard_button;
    Button settings_button;
    Button logout_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        final Context context = this;
        challenge_button = (Button) findViewById(R.id.challenge_button);

        challenge_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(context, user_credentials.class);
                //startActivity(intent);
            }
        });

        practice_button = (Button) findViewById(R.id.create_acc_button);
        practice_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, practice.class);
                startActivity(intent);
            }
        });

        settings_button = (Button) findViewById(R.id.create_acc_button);
        settings_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(context, user_credentials.class);
                //startActivity(intent);
            }
        });

        logout_button = (Button) findViewById(R.id.create_acc_button);
        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, login_menu.class);
                startActivity(intent);
            }
        });

        leaderboard_button = (Button) findViewById(R.id.create_acc_button);
        leaderboard_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, LeaderboardMenu.class);
                startActivity(intent);
            }
        });
    }

}
