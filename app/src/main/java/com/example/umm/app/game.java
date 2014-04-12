package com.example.umm.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by towhi_000 on 4/12/14.
 */
public class game extends Activity{

    Button submit_button;
    Button button_next;
    TextView question;
    TextView answer;
    EditText user_answer;
    int x1;
    int x2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.game);
        addListenerOnButtons();
    }

    public void addListenerOnButtons(){

        final Context context = this;
        /*
        Here the number is generated. This is hardcoded for the prototype.
        Furthermore, for the prototype the number is not within the given
        range.
         */
        Random rand = new Random();
        x1 = rand.nextInt(17);
        x2 = rand.nextInt(17);
        String mult = ""+x1+"*"+x2;
        char[] multFinal = mult.toCharArray();


        submit_button = (Button) findViewById(R.id.submit_button);
        question = (TextView) findViewById(R.id.textView_question);
        answer = (TextView) findViewById(R.id.textView_answer);
        user_answer = (EditText) findViewById(R.id.editText_answer);

        question.setText(multFinal,0,-1);

        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1 = Integer.parseInt(user_answer.getText().toString());
                int num2 = x1*x2;
                if( num1 == num2 ){
                    answer.setText("Correct".toCharArray(), 0, -1);
                }
                else{
                    answer.setText("Wrong".toCharArray(),0,-1);
                }

            }
        });

        button_next = (Button) findViewById(R.id.button_next);
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, user_credentials.class);
                finishActivity(0);
                startActivity(intent);
            }
        });

    }
}
