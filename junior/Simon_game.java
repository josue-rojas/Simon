package com.hwapp.juniorperalta.simon_game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.LinkedList;
import java.util.Random;

public class Simon_game extends AppCompatActivity {

    public Button red;
    public Button green;
    public Button blue;
    public Button yellow;

    private LinkedList<Integer> rc = new LinkedList<>() ;
    private int counter = 0;
    private TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simon_game);

        red = (Button) findViewById(R.id.button1);
        green = (Button) findViewById(R.id.button3);
        blue = (Button) findViewById(R.id.button2);
        yellow = (Button) findViewById(R.id.button4);

        //

        red.setEnabled(true);
        red.setClickable(true);

        //red.getBackground()

        blue.setEnabled(true);
        blue.setClickable(true);

        green.setEnabled(true);
        green.setClickable(true);

        yellow.setEnabled(true);
        yellow.setClickable(true);

        //

        tv = (TextView) findViewById(R.id.textView);

       while(1 < 2) {

           button_adder(rc);

           for (int i = 0; i < rc.size(); i++) {

               if(rc.get(i) == 1) {

                   tv.setText("Press Red Button");

                   red.setOnClickListener(new View.OnClickListener() {
                       public void onClick(View v) {
                           // Perform action on click
                           tv.setText("Red Button Pressed");
                       }
                   });

               }

               //

               if(rc.get(i) == 2) {

                   tv.setText("Press Blue Button");

                   blue.setOnClickListener(new View.OnClickListener() {
                       public void onClick(View v) {
                           // Perform action on click
                           tv.setText("Blue Button Pressed");
                       }
                   });

               }

               //

               if(rc.get(i) == 3) {

                   tv.setText("Press Green Button");

                   green.setOnClickListener(new View.OnClickListener() {
                       public void onClick(View v) {
                           // Perform action on click
                           tv.setText("Green Button Pressed");
                       }
                   });

               }

               //

               if(rc.get(i) == 4) {

                   tv.setText("Press Yellow Button");

                   yellow.setOnClickListener(new View.OnClickListener() {
                       public void onClick(View v) {
                           // Perform action on click
                           tv.setText("Yellow Button Pressed");
                       }
                   });

               }

           }

       }
    }

    public void button_adder(LinkedList<Integer> random_choices){

        Random rn = new Random();

        random_choices.add(rn.nextInt(5));
    }
}
