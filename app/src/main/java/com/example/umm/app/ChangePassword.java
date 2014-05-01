package com.example.umm.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

public class ChangePassword extends Activity {

    String currentUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            currentUserName = extras.getString("currentUserName");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.change_password, menu);
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

    public String[] getAccountInfo(){
        List<String[]> list = new ArrayList<String[]>();
        CSVReader reader;
        String[] userInfo = new String[2];
        try{

            FileInputStream is = openFileInput("UserInfo.csv");
            reader = new CSVReader(new InputStreamReader(is));
            list = reader.readAll();
            reader.close();
        }

        catch(FileNotFoundException e){

        } catch (IOException e) {

        }
        Log.i("ChangePass -> getAccountInfo",currentUserName);
        for(String[] info : list){
            if(info[0].equals(currentUserName)){

                Log.i("ChangePass -> getAccountInfo","File says" + info[0]);
                Log.i("ChangePass -> getAccountInfo","File says" + info[1]);
                System.arraycopy(info, 0, userInfo, 0, info.length);
            }
        }


        return userInfo;
    }


    public void updateAccountInfo(String newPass){
        List<String[]> list = new ArrayList<String[]>();
        CSVReader reader;
        CSVWriter writer;

        try{

            FileInputStream is = openFileInput("UserInfo.csv");
            reader = new CSVReader(new InputStreamReader(is));
            list = reader.readAll();
            reader.close();

            FileOutputStream os = openFileOutput("UserInfo.csv", Context.MODE_PRIVATE);
            writer = new CSVWriter(new OutputStreamWriter(os));
            for(String[] info : list){
                if(info[0].equals(currentUserName)){
                    info[1] = newPass;
                    break;
                }
            }

            writer.writeAll(list);
            writer.close();
        }

        catch(FileNotFoundException e){

        } catch (IOException e) {

        }


    }

    public void submitPassData(View view){
        final Context context = this;

        Button submit = (Button) findViewById(R.id.submit_button);
        submit.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                EditText oldPassField = (EditText) findViewById(R.id.changePassOld);
                EditText newPassField = (EditText) findViewById(R.id.changePassNew1);
                EditText newPassField2 = (EditText) findViewById(R.id.changePassNew2);
                String oldPass = oldPassField.getText().toString();
                String newPass = newPassField.getText().toString();
                String newPass2 = newPassField2.getText().toString();
                String alertTitle = "";
                String alertMessage = "";
                String[] accountInfo = getAccountInfo();
                final boolean close;

                if(!oldPass.equals(accountInfo[1])){
                    alertTitle = "Password change failed";
                    alertMessage = "Invalid password. Please try again.";
                    close = false;
                }

                else if(!newPass.equals(newPass2)){
                    alertTitle = "Password change failed";
                    alertMessage = "New password fields do not match. Please try again.";
                    close = false;
                }

                else {
                    alertTitle = "Success";
                    alertMessage = "Your password has been successfully changed";
                    close = true;
                    updateAccountInfo(newPass);
                }

                final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setTitle(alertTitle);
                alertDialogBuilder.setCancelable(false);
                alertDialogBuilder.setMessage(alertMessage);
                alertDialogBuilder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        if (close == true) {
                            Intent switchToSettings = new Intent(ChangePassword.this, settings.class);
                            switchToSettings.putExtra("currentUserName", currentUserName);
                            ChangePassword.this.startActivity(switchToSettings);
                        }

                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });


                //AlertDialog  alertDialog = alertDialogBuilder.create();
                //alertDialog.show();
                //returnToSettings();


    }

    /**public void onBackPressed(){
        Intent switchToSettings = new Intent(ChangePassword.this, settings.class);
        switchToSettings.putExtra("currentUserName", currentUserName);
        super.onBackPressed();
    }*/

}
