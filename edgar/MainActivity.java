package com.morales.edgar.simonsays;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;
import android.widget.TextView;

import java.util.Stack;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public Stack inputStack = new Stack();
    Button populate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populate = (Button) findViewById(R.id.fillwithrandomnumbers);
        inputStack.removeAllElements();
        populate.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        randomStack();
                        /*for(int i = 0; i < inputStack.size(); i++){
                            Log.d("simonSays", "element in stack: " + inputStack.elementAt(i));
                            TextView stack = (TextView) findViewById(R.id.textView);
                            stack.setText(inputStack.elementAt(i)+",");
                        }*/
                    }
                }
        );
    }

    public void randomStack(){
        Random random = new Random();
        int randomNumber = random.nextInt(4);
        inputStack.push(randomNumber);
    }
}
