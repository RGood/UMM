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

import java.util.ArrayList;
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
    int result = 0;
    int count = 0;
    String mult;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.game);
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
        answer = (TextView) findViewById(R.id.textView_answer);
        answer.setVisibility(1);
        user_answer = (EditText) findViewById(R.id.Text_answer);

        question.setText(mult);

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
                    //response = "Right!";
                    result++;
                } else {
                    //response = "Wrong!";
                }

                count++;

                if (count == 10) {
                    question.setText("You got " + result + " out of" + count + " right!");
                    count = 0;
                    result = 0;
                } else {

                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    String newmult = newQuestion();
                    question.setText(newmult);
                    user_answer.setText("");
                    answer.setText("");
                }
            }
        });
    }
}
