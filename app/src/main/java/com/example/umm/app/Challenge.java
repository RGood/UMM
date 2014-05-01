package com.example.umm.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Challenge extends Activity {
    String currentUserName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);
        addListenerOnButtons();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            currentUserName = extras.getString("currentUserName");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.challenge, menu);
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
        Button but1;
        Button but2;
        Button but3;
        Button but4;
        Button but5;
        Button but6;
        Button but7;
        Button but8;

        but1 = (Button) findViewById(R.id.diff1);
        but2 = (Button) findViewById(R.id.diff2);
        but3 = (Button) findViewById(R.id.diff3);
        but4 = (Button) findViewById(R.id.diff4);
        but5 = (Button) findViewById(R.id.diff5);
        but6 = (Button) findViewById(R.id.diff6);
        but7 = (Button) findViewById(R.id.diff7);
        but8 = (Button) findViewById(R.id.diff8);

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, game.class);
                intent.putExtra("currentUserName", currentUserName);
                startActivity(intent);
            }
        });
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, game.class);
                intent.putExtra("currentUserName", currentUserName);
                startActivity(intent);
            }
        });
        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, game.class);
                intent.putExtra("currentUserName", currentUserName);
                startActivity(intent);
            }
        });
        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, game.class);
                intent.putExtra("currentUserName", currentUserName);
                startActivity(intent);
            }
        });
        but5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, game.class);
                intent.putExtra("currentUserName", currentUserName);
                startActivity(intent);
            }
        });
        but6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, game.class);
                intent.putExtra("currentUserName", currentUserName);
                startActivity(intent);
            }
        });
        but7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, game.class);
                intent.putExtra("currentUserName", currentUserName);
                startActivity(intent);
            }
        });
        but8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, game.class);
                intent.putExtra("currentUserName", currentUserName);
                startActivity(intent);
            }
        });
    }

    public void backPage(View v) {
        this.finishActivity(0);
    }
}
