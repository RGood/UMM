package com.example.umm.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by towhi_000 on 4/12/14.
 */
public class game extends Activity{

    Button submit_button;
    Button button_next;
    TextView question;
    Button button_prompt;
    EditText user_answer;
    int x1;
    int x2;
    int result = 0;
    int count = 0;
    String mult;
    String currentUserName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.game);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            currentUserName = extras.getString("currentUserName");
        }
        addListenerOnButtons();
    }

    /*
       Here the number is generated. This is hardcoded for the prototype.
       Furthermore, for the prototype the number is not within the given
       range.
        */
    private String newQuestion(){
        Random rand = new Random();
        x1 = rand.nextInt(17);
        x2 = rand.nextInt(17);
        mult = ""+x1+"*"+x2;
        return mult;
    }
    public void addListenerOnButtons(){

        final Context context = this;


        String mult = newQuestion();

        submit_button = (Button) findViewById(R.id.submit_button);
        question = (TextView) findViewById(R.id.textView_question);
        button_prompt = (Button) findViewById(R.id.button_prompt);
        button_prompt.setVisibility(0);
        user_answer = (EditText) findViewById(R.id.Text_answer);
        question.setText(mult);

        button_prompt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                user_answer.setBackgroundColor(Color.WHITE);
                if (count == 10) {
                    question.setText("You got " + result + " out of" + count + " right!");
                    submit_button.setVisibility(View.INVISIBLE);
                    button_prompt.setText("Main Menu");
                    count++;

                }
                else if(count==11){
                    Intent intent = new Intent(game.this, main_menu.class);
                    startActivity(intent);
                }
                else {

                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    String newmult = newQuestion();
                    question.setText(newmult);
                    user_answer.setText("");
                }
            }
        });

        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user_answer.getText().toString().matches("")){
                    return;
                }
                int num1 = Integer.parseInt(user_answer.getText().toString());
                int num2 = x1 * x2;
                String response = "";
                if (num1 == num2) {
                    user_answer.setBackgroundColor(Color.GREEN);
                    user_answer.setText("RIGHT!");
                    result++;
                } else {
                    user_answer.setBackgroundColor(Color.RED);
                    user_answer.setText("WRONG");
                }

                count++;
                TextView counter = (TextView) findViewById(R.id.textView2);
                counter.setText(""+count);
            }
        });
    }
}
