package comjosuerojasrojas.httpsgithub.simon;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Mor-Men on 7/13/2016.
 */
public class computerAI {
    static ArrayList<Integer> computerValues = new ArrayList<>();
    static int current = 0;
    //keep track of the size
    static int end = 0;


    public static void randomN(){
        for(int i = 0; i < 10; i ++){
            addValues();
        }
    }
    public static void addValues(){
        Random random = new Random();
        int value = random.nextInt(4);
        Log.d("inside","add valie" + value);
        computerValues.add(value);
        end++;
    }

    public static void reset(){
        computerValues.clear();
        current = 0;
    }

    public static int getNext(){
        Log.d("inside",current+ " curr and size = " + end);
        if(current == end){
            Log.d("inside",current+ " curr and size = " + end + "return 0");
            return current=0;
        }
        Log.d("inside",(current+1) +  " return");
        return current++;
    }

    /*
    //get the id for current button
    public static int getID(){
        if
        return Constants.ID[computerAI.computerValues.get(computerAI.current)])
    }
    */

}
