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




    public static void addValues(){
        Random random = new Random();
        int value = random.nextInt(4);
        computerValues.add(value);
        end++;

    }

    public static void reset(){
        computerValues.clear();
        current = 0;
        end = 0;
    }

    public static int getNext(){
        if(current == end){
            return current=0;
        }
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
