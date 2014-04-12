package com.example.umm.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class settings extends Activity {

    Button changePassword;
    Button sound;
    Button aboutUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        addButtonListeners();
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

    public void changePassword(View view){
        Intent switchToPass = new Intent(settings.this, ChangePassword.class);
        settings.this.startActivity(switchToPass);

    }

    public void addButtonListeners(){
        final Context context = this;

        changePassword = (Button) findViewById(R.id.change_password_button);
        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ChangePassword.class);
                startActivity(intent);
            }
        });

        sound = (Button) findViewById(R.id.change_password_button);
        sound.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent = new Intent(context, sound.class);
                startActivity(intent);
            }
        });




    }
}
