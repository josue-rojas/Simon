package comjosuerojasrojas.httpsgithub.simon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //constants
    private static int numButtons = 4;
    private static int[] buttonID = new int[numButtons];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get all button id number
        //might throw error if button doesn't exist
        for (int i = 0; i < numButtons; i++) {
            buttonID[i] = (getResources().getIdentifier("button_" + i, "id", getPackageName()));
            ((Button) findViewById(buttonID[i])).setOnTouchListener(listener);
        }
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
                enableButtons(v.getId());
                //return true;
            }
            return false;
        }
    };

    //should be updated for more numbers
    //not used for now
    public void onClickColor(View view) {
        int viewID = view.getId();
       // disableButtons(viewID);
    }

    //function to diasble
    public void disableButtons(int id) {
        for (int i = 0; i < buttonID.length; i++) {
            if (buttonID[i] != id)
                ((Button) findViewById(buttonID[i])).setEnabled(false);
        }
    }

    public void enableButtons(int id) {
        for (int i = 0; i < buttonID.length; i++) {
            ((Button) findViewById(buttonID[i])).setEnabled(true);
        }
    }

}

