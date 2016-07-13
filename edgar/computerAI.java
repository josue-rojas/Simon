package com.morales.edgar.simonsays;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Mor-Men on 7/13/2016.
 */
public class computerAI {
    static ArrayList computerValues;
    int pointer = -1;

    public void addValues(){
        Random random = new Random();
        int value = random.nextInt(4);
        if(computerValues.size() == 0 || computerValues == null){
            computerValues = new ArrayList();
            computerValues.add(value);
            pointer = 0;
        }
        else{
            computerValues.add(value);
            pointer++;
        }
    }

    public void reset(){
        computerValues.clear();
        pointer = -1;
    }

    /*public int loopThroughArray(){

    }*/
}
