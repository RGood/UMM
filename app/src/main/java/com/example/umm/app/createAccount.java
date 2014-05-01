package com.example.umm.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.content.Context;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.content.DialogInterface;
import android.view.View;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;


public class createAccount extends Activity {

    String currentUserName;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        for(String s: this.fileList()){
            Log.i("Create account", s);
        }
        currentUserName = "";


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.create_account, menu);
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

    public boolean checkForExistingAccount(String userName){
        List<String[]> list = new ArrayList<String[]>();
        CSVReader reader;
        try{
            Context context = this;

            FileInputStream is = context.openFileInput("UserInfo.csv");

            reader = new CSVReader(new InputStreamReader(is));
            list = reader.readAll();
            reader.close();

            for(String[] info : list){
                if(info[0].equals(userName)){
                    return true;
                }
            }


        }

        catch(FileNotFoundException e){

        } catch (IOException e) {

        }

        return false;
    }

    public void addAccount(String username, String password){
        String[] account = new String[2];
        account[0] = username;
        account[1] = password;
        CSVWriter writer;
        CSVReader reader;
        try{


            FileOutputStream os = openFileOutput("UserInfo.csv", Context.MODE_PRIVATE);


            writer = new CSVWriter(new OutputStreamWriter(os));
            writer.writeNext(account);
            writer.close();
            currentUserName = account[0];

            FileInputStream is = openFileInput("UserInfo.csv");
            reader = new CSVReader(new InputStreamReader(is));
            String[] info = new String[2];
            info = reader.readNext();
            reader.close();

            for(String s : info){
               Log.i("createAccount",s);
            }

        }

        catch(FileNotFoundException e){

        }

        catch(IOException e){

        }
    }

    public void createAccount(View view){



        final Context context = this;

        button = (Button) findViewById(R.id.create_acc_button);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                EditText userNameField = (EditText) findViewById(R.id.createUsernameField);
                EditText passwordField = (EditText) findViewById(R.id.createAccountPassField);
                EditText passwordField2 = (EditText) findViewById(R.id.createAccountPassField2);
                String userName = userNameField.getText().toString();
                String password = passwordField.getText().toString();
                String password2 = passwordField2.getText().toString();
                String alertTitle;
                String alertMessage;
                final boolean close;
                if(checkForExistingAccount(userName)){
                    alertTitle = "Failed to create account";
                    alertMessage = "The username you chose has already been taken.";
                    close = false;
                }

                else if(!password.equals(password2)){
                    alertTitle = "Failed to create account";
                    alertMessage = "Password fields do not match. Please try again.";
                    close = false;
                }

                else{
                    addAccount(userName,password);
                    alertTitle = "Success";
                    alertMessage = "Your account has been successfully created.";
                    close = true;
                }

                final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setTitle(alertTitle);
                alertDialogBuilder.setCancelable(false);
                alertDialogBuilder.setMessage(alertMessage);
                alertDialogBuilder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        if(close == true){
                            Intent intent = new Intent(createAccount.this, main_menu.class);
                            intent.putExtra("currentUserName", currentUserName);
                            startActivity(intent);
                        }
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });



    }
}
