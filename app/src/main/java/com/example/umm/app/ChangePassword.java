package com.example.umm.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ChangePassword extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

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

    public void submitPassData(View view){
        Button submit;
        final Context context = this;

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle("Success");
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setMessage("Your password has been successfully changed.");
        alertDialogBuilder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                Intent switchToSettings = new Intent(ChangePassword.this, settings.class);
                ChangePassword.this.startActivity(switchToSettings);
            }
        });



        submit = (Button) findViewById(R.id.submit_button);
        //submit.setOnClickListener((view) ->  {

           //AlertDialog alertDialog = alertDialogBuilder.create();
           //alertDialog.show();
        //});


                AlertDialog  alertDialog = alertDialogBuilder.create();
                alertDialog.show();
                //returnToSettings();


    }

    public void returnToSettings(){
        Intent switchToSettings = new Intent(ChangePassword.this, settings.class);
        ChangePassword.this.startActivity(switchToSettings);
    }

}
