package comjosuerojasrojas.httpsgithub.simon;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    //constants
    private static int numButtons = 4;
    private static int[] buttonID = new int[numButtons];
    private final Handler handler = new Handler();
    private boolean firstTurn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get all button id number
        //might throw error if button doesn't exist
        for (int i = 0; i < numButtons; i++) {
            buttonID[i] = (getResources().getIdentifier("button_" + i, "id", getPackageName()));
            ((Button) findViewById(buttonID[i])).setOnTouchListener(listener);
            //populate constants
            Constants.ID[i] = ((Button) findViewById(buttonID[i])).getId();
            Constants.idToColor.put(((Button)findViewById(buttonID[i])).getId(),Constants.colorPressed[i]);
            Constants.idToColorDef.put(((Button)findViewById(buttonID[i])).getId(),Constants.colorDefault[i]);

        }
        //disableButtons(-1);
        //((ImageView) findViewById(R.id.imageView)).setOnTouchListener(listener);
        //computerAI.randomN();
        computerAI.addValues();
        computerTurn();

    }


    //onTouchListener is used to disable buttons when one is press 
    View.OnTouchListener listener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if(event.getAction() == MotionEvent.ACTION_DOWN) {
                disableButtons(v.getId());

                //return true;
            }
            if(event.getAction() == MotionEvent.ACTION_UP) {
                //check if right

                //add pattern after
                computerAI.addValues();
                computerTurn();

                //computerAI.current = 0;
                //return true;
            }

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
        //change to 'clicked' button
        button.setBackgroundColor(Color.parseColor(
                Constants.idToColor.get(new Integer(button.getId()))));
        Log.d("inside", computerAI.current + " curr");
        //disable buttons
        disableButtons(-1);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //computerAI.getNext();

                Log.d("inside", "handler run current = "  + computerAI.current);
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




    }





