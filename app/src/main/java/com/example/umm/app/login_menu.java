package com.example.umm.app;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by towhi_000 on 4/11/14.
 */
public class login_menu extends Activity {

    Button login_button;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        try {
            FileOutputStream os = openFileOutput("UserInfo.csv", Context.MODE_PRIVATE);

            os.close();
            for(String s: this.fileList()){
                Log.i("login_menu",s);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        addListenerOnButtons();
    }



    public void addListenerOnButtons(){

        final Context context = this;
        login_button = (Button) findViewById(R.id.login_button);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, user_credentials.class);
                startActivity(intent);
            }
        });


        Button create_acc = (Button) findViewById(R.id.create_acc_button);
        create_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, createAccount.class);
                startActivity(intent);
            }
        });
    }
}
