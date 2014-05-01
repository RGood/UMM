package com.example.umm.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

/**
 * Created by towhi_000 on 4/11/14.
 */
public class user_credentials extends Activity{

    Button login;
    //Button back;
    String currentUserName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_credentials);


        addListenerOnButtons();
    }

    public boolean verifyLogin(){
        EditText userNameField = (EditText) findViewById(R.id.loginUserName);
        EditText passwordNameField = (EditText) findViewById(R.id.loginPassword);
        String userName = userNameField.getText().toString();
        String password = passwordNameField.getText().toString();


        List<String[]> list = new ArrayList<String[]>();
        CSVReader reader;

        try{
            Context context = this;

            FileInputStream is = context.openFileInput("UserInfo.csv");


            reader = new CSVReader(new InputStreamReader(is));

            list = reader.readAll();
            reader.close();
        }

        catch(FileNotFoundException e){

        } catch (IOException e) {

        }
        Log.i("UMM",String.valueOf(list.size()));
        for(String[] info : list){
            Log.i("UMM", info[0]);
            Log.i("UMM", info[1]);
            if(info[0].equals(userName) && info[1].equals(password)){
                currentUserName = userName;
                return true;
            }
        }

        return false;
    }

    public void addListenerOnButtons(){

        final Context context = this;
        login = (Button) findViewById(R.id.login_button2);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean success = verifyLogin();
                if(success == true){
                    Intent intent = new Intent(context, main_menu.class);
                    intent.putExtra("currentUserName", currentUserName);
                    startActivity(intent);
                    //finishActivity(0);
                }

                else{
                    final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                    alertDialogBuilder.setTitle("Login Failure");
                    alertDialogBuilder.setCancelable(false);
                    alertDialogBuilder.setMessage("Invalid login. Check your username and password");
                    alertDialogBuilder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();



                }

            }
        });

        //back = (Button) findViewById(R.id.back_button);
        /**back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishActivity(0);
            }
        });*/
    }
}
