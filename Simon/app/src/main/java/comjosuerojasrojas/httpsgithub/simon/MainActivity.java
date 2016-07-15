package comjosuerojasrojas.httpsgithub.simon;

import android.graphics.Color;
import android.media.Image;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //constants
    private static int[] buttonID = new int[Constants.numButtons];
    private final Handler handler = new Handler();
    int current = 0; //keep track of current for user ([0000current0000])
    private Toast mToastToShow;
    private boolean loose = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get all button id number
        //might throw error if button doesn't exist
        for (int i = 0; i < Constants.numButtons; i++) {
            buttonID[i] = (getResources().getIdentifier("button_" + i, "id", getPackageName()));
            ((Button) findViewById(buttonID[i])).setOnTouchListener(listener);
            //populate constants
            Constants.ID[i] = ((Button) findViewById(buttonID[i])).getId();
            Constants.idToColor.put(((Button)findViewById(buttonID[i])).getId(),Constants.colorPressed[i]);
            Constants.idToColorDef.put(((Button)findViewById(buttonID[i])).getId(),Constants.colorDefault[i]);
            Constants.idToIndex.put(((Button) findViewById(buttonID[i])).getId(),new Integer(i));

        }
        //((Button)findViewById(R.id.reset)).setOnClickListener(resetGame(this));
        //computer turn (always first)
        ((Button)findViewById(R.id.reset)).setEnabled(false);
        ((Button)findViewById(R.id.multiplayer)).setEnabled(false);

        disableButtons(-1);
        //seekbar and it's function (messy for now)
        ((SeekBar)findViewById(R.id.seekBar)).setProgress(0);
        ((SeekBar)findViewById(R.id.seekBar)).setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Constants.delay = 1100 - progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }


    //onTouchListener is used to disable buttons when one is press 
    View.OnTouchListener listener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            Long time = System.currentTimeMillis();

            if(event.getAction() == MotionEvent.ACTION_DOWN) {
                Log.d("inside","disable buttons");
                disableButtons(v.getId());

                //return true;
            }
            if(event.getAction() == MotionEvent.ACTION_UP) {
                //check pattern


                int currIndex = Constants.idToIndex.get(v.getId());
                Log.d("inside","currID " +currIndex);
                Log.d("inside","computer " + computerAI.computerValues.get(current));
                int currPatternI = computerAI.computerValues.get(current);
                Log.d("inside","currPattern " + currPatternI);
                //check if the match
                //last one check

                if(currIndex != currPatternI){
                    //wrong
                    current = 0;
                    /*
                    computerAI.reset();
                    computerAI.addValues();
                    computerTurn();
                    Log.d("inside","wrong");
                    */
                    loose = true;
                    disableButtons(-1);
                    ((TextView)findViewById(R.id.status)).setText("You Loose Press Start to play again");
                    ((Button)findViewById(R.id.start)).setEnabled(true);
                    ((Button)findViewById(R.id.reset)).setEnabled(false);

                }

                else {
                    //right
                    Log.d("inside","right");
                    if(current != computerAI.end-1){
                        current++;
                        Log.d("inside","current = " + current);
                    }
                    else{
                        Log.d("inside","right computer turn");
                        current = 0;
                        computerAI.addValues();
                        computerTurn();
                    }
                }


                /*
                computerAI.addValues();
                //display the computer turn
                computerTurn();
                enableButtons();
                */
                /*
                //add to pattern
                int currentButtonIndex = Constants.idToIndex.get(v.getId());
                Log.d("inside","after create button currentButton" + currentButtonIndex + " endCP " + computerAI.computerValues.get(current));
                //reach the end last of pattern
                if(current == computerAI.end) {
                    Log.d("inside","affter check end");
                    if(currentButtonIndex == computerAI.computerValues.get(current)-1) {
                        Log.d("inside","after check id");
                        computerAI.addValues();
                        //display the computer turn
                        computerTurn();
                        current = 0;

                    }
                    else{
                        Log.d("inside","");
                        ((TextView)findViewById(R.id.delay)).setText("Lost");
                        current = 0;

                    }


                }
                else{
                    Log.d("inside","else");
                    //if press right button
                    if(currentButtonIndex == computerAI.computerValues.get(current)){
                        Log.d("inside","check buttons");
                        //update current to next button
                        current++;
                        enableButtons();
                    }
                    else{
                        Log.d("inside","else wrong button" +
                                "");

                        ((TextView)findViewById(R.id.delay)).setText("Lost");
                        current = 0;
                    }
                }
                Log.d("inside","after turn");
                */
            }
            if(!loose) enableButtons();

            return false;
        }
    };





    //function to diasble
    public void disableButtons(int id) {
        for (int i = 0; i < buttonID.length; i++) {
            if (buttonID[i] != id)
                ((Button) findViewById(buttonID[i])).setEnabled(false);
        }
    }

    public void enableButtons() {
        for (int i = 0; i < buttonID.length; i++) {
            ((Button) findViewById(buttonID[i])).setEnabled(true);
        }
    }


    //handle delay from computer turn and show the pattern
    public void computerTurn(){

        final Button button = (Button)findViewById(Constants.ID[computerAI.computerValues.get(computerAI.current)]);
        //change to 'clicked' button color
        button.setBackgroundColor(Color.parseColor(
                Constants.idToColor.get(new Integer(button.getId()))));
        //disable buttons
        disableButtons(-1);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //computerAI.getNext();

                //set default color (for computer)
                    button.setBackgroundColor(Color.parseColor(
                            Constants.idToColorDef.get(new Integer(button.getId()))));
                //run until current gets to last
                computerAI.getNext();
                if(computerAI.current != computerAI.end) {
                    computerTurn();
                }
                else{
                    enableButtons();
                    computerAI.getNext();
                }
            }},Constants.delay);


        }



    public void multiplayer(){};

    public void resetGame(View view){
        Log.d("inside","reset press");
        computerAI.reset();
        int toastDurationInMilliSeconds = 1000;
        mToastToShow = Toast.makeText(getApplicationContext(),"Game has been resetted",Toast.LENGTH_SHORT);

        CountDownTimer toastCountDown;
        toastCountDown = new CountDownTimer(toastDurationInMilliSeconds, 1000 /*Tick duration*/) {
            public void onTick(long millisUntilFinished) {
                mToastToShow.show();
            }
            public void onFinish() {
                mToastToShow.cancel();
            }
        };
        mToastToShow.setGravity(Gravity.TOP| Gravity.CENTER_HORIZONTAL,0,700);
        mToastToShow.show();
        toastCountDown.start();        view.setEnabled(false);
        ((Button)findViewById(R.id.start)).setEnabled(true);
        disableButtons(-1);
        current = 0;

    }


    public void resetLost(){
        computerAI.reset();
    }

    public void startGame(View view){
        ((TextView)findViewById(R.id.status)).setText("");
        view.setEnabled(false);
        ((Button)findViewById(R.id.reset)).setEnabled(true);
        computerAI.addValues();
        computerTurn();

    }

    }





