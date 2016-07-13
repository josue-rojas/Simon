package com.hwapp.juniorperalta.simon_game;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

public class Simon_game extends AppCompatActivity {

    public Button red;
    public Button green;
    public Button blue;
    public Button yellow;

    private LinkedList<Integer> rc = new LinkedList<>() ;
    private int counter = 0;
    private int current = 0;
    private int score = 0;
    private boolean reset = false;
    private TextView tv;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simon_game);

        red = (Button) findViewById(R.id.button1);
        green = (Button) findViewById(R.id.button3);
        blue = (Button) findViewById(R.id.button2);
        yellow = (Button) findViewById(R.id.button4);

        red.setEnabled(true);
        red.setClickable(true);

        blue.setEnabled(true);
        blue.setClickable(true);

        green.setEnabled(true);
        green.setClickable(true);

        yellow.setEnabled(true);
        yellow.setClickable(true);

        final Handler handler = new Handler();

        tv = (TextView) findViewById(R.id.textView);

          // button_adder(rc);//Used to be here

        while (!reset) {

            button_adder(rc);//Now Here

            for (int i = 0; i < rc.size(); i++) {

                current = rc.get(i);

                if (rc.get(i) == 1) {

                    tv.setText("Press Red Button");

                    handler.postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            Simon_game.this.red.setBackgroundColor(Color.rgb(255, 51, 51));

                        }

                    }, 1000);

                    handler.postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            Simon_game.this.red.setBackgroundColor(Color.rgb(255, 0, 0));
                        }

                    }, 2000);


                    red.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            // Perform action on click

                            handler.postDelayed(new Runnable() {

                                @Override
                                public void run() {
                                    Simon_game.this.red.setBackgroundColor(Color.rgb(255, 0, 0));

                                }

                            }, 1000);

                            handler.postDelayed(new Runnable() {

                                @Override
                                public void run() {
                                    Simon_game.this.red.setBackgroundColor(Color.rgb(153, 0, 0));
                                }

                            }, 2000);

                            if (current == 1) {//

                                counter++;

                                if (counter == rc.size()) {

                                    score++;

                                    tv.setText("Score: " + score);
                                }
                            }


                            //tv.setText("Red Button Pressed");
                        }
                    });
                }

                if (rc.get(i) == 2) {

                    tv.setText("Press Blue Button");

                    handler.postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            Simon_game.this.blue.setBackgroundColor(Color.rgb(102, 178, 255));

                        }

                    }, 1000);

                    handler.postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            Simon_game.this.blue.setBackgroundColor(Color.rgb(0, 0, 204));
                        }

                    }, 2000);

                    blue.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            // Perform action on click

                            handler.postDelayed(new Runnable() {

                                @Override
                                public void run() {
                                    Simon_game.this.blue.setBackgroundColor(Color.rgb(102, 178, 255));

                                }

                            }, 1000);

                            handler.postDelayed(new Runnable() {

                                @Override
                                public void run() {
                                    Simon_game.this.blue.setBackgroundColor(Color.rgb(0, 0, 204));
                                }

                            }, 2000);

                            if (current == 2) {//

                                counter++;

                                if (counter == rc.size()) {

                                    score++;

                                    tv.setText("Score: " + score);
                                }
                            }

                            // tv.setText("Blue Button Pressed");
                        }
                    });

                }

                //

                if (rc.get(i) == 3) {

                    tv.setText("Press Green Button");

                    handler.postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            Simon_game.this.green.setBackgroundColor(Color.rgb(0, 255, 0));

                        }

                    }, 1000);

                    handler.postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            Simon_game.this.green.setBackgroundColor(Color.rgb(0, 102, 0));
                        }

                    }, 2000);

                    green.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            // Perform action on click

                            handler.postDelayed(new Runnable() {

                                @Override
                                public void run() {
                                    Simon_game.this.green.setBackgroundColor(Color.rgb(0, 255, 0));

                                }

                            }, 1000);

                            handler.postDelayed(new Runnable() {

                                @Override
                                public void run() {
                                    Simon_game.this.green.setBackgroundColor(Color.rgb(0, 102, 0));
                                }

                            }, 2000);

                            if (current == 3) {//

                                counter++;

                                if (counter == rc.size()) {

                                    score++;

                                    tv.setText("Score: " + score);
                                }
                            }


                            //tv.setText("Green Button Pressed");
                        }
                    });

                }

                //

                if (rc.get(i) == 4) {

                    tv.setText("Press Yellow Button");

                    handler.postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            Simon_game.this.yellow.setBackgroundColor(Color.rgb(255, 255, 0));

                        }

                    }, 1000);

                    handler.postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            Simon_game.this.yellow.setBackgroundColor(Color.rgb(204, 204, 0));
                        }

                    }, 2000);

                    yellow.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            // Perform action on click

                            handler.postDelayed(new Runnable() {

                                @Override
                                public void run() {
                                    Simon_game.this.yellow.setBackgroundColor(Color.rgb(255, 0, 0));

                                }

                            }, 1000);

                            handler.postDelayed(new Runnable() {

                                @Override
                                public void run() {
                                    Simon_game.this.yellow.setBackgroundColor(Color.rgb(204, 204, 0));
                                }

                            }, 2000);

                            if (current == 4) {//

                                counter++;

                                if (counter == rc.size()) {

                                    score++;

                                    tv.setText("Score: " + score);
                                }
                            }


                            //tv.setText("Yellow Button Pressed");
                        }
                    });

                }

            }

            if( counter < rc.size() ) {//reset

                reset = true;
                tv.setText("Wrong sequence");
                //score = 0;


            }
        }
    }

//    public int score(int i, int g){
//
//        if(i == g){
//
//            score++;
//        }
//
//        return score;
//    }

    public LinkedList<Integer> button_adder(LinkedList<Integer> random_choices){

        Random rn = new Random();

        random_choices.add(rn.nextInt(5));

        return rc;
    }

//    public Deque<Integer> button_adder2 (Deque<Integer> random_choices){
//
//    Random rn = new Random();
//
//    random_choices.add(rn.nextInt(5));
//
//    return rc;
//}
}