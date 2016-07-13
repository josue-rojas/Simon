package com.morales.edgar.simonsays;

import java.util.Random;
import java.util.Stack;

/**
 * Created by Mor-Men on 7/13/2016.
 */
public class stackClass extends computerAI {


    @Override
    public int getNextColor(){
        int color;
        if(stack.size() == 0 || stack == null){
            return -1;
        }
        else{
            color = (int)stack.pop();
        }
        return color;
    }

    @Override
    public void putNextColor(){
        Random random = new Random();
        int randomNumber = random.nextInt(4);
        if(stack.size() == 0 || stack == null){
            stack = new Stack();
            stack.push(randomNumber);
        }
        else{
            stack.push(randomNumber);
        }
    }

    public void reset(){
        stack.removeAllElements();
    }
}
