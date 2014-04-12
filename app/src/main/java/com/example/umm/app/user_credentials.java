package com.example.umm.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
/**
 * Created by towhi_000 on 4/11/14.
 */
public class user_credentials extends Activity{

    Button login;
    Button back;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_credentials);
        addListenerOnButtons();
    }

    public void addListenerOnButtons(){

        final Context context = this;
        login = (Button) findViewById(R.id.login_button2);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, main_menu.class);
                startActivity(intent);
            }
        });

        back = (Button) findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, login_menu.class);
                startActivity(intent);
            }
        });
    }
}
