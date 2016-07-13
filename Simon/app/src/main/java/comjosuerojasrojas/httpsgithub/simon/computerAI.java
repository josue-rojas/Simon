package comjosuerojasrojas.httpsgithub.simon;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Mor-Men on 7/13/2016.
 */
public class computerAI {
    static ArrayList<Integer> computerValues;
    int current = 0;

    public void addValues(){
        Random random = new Random();
        int value = random.nextInt(4);
        if(computerValues.size() == 0 || computerValues == null){
            computerValues = new ArrayList();
            computerValues.add(value);
        }
        else{
            computerValues.add(value);
        }
    }

    public void reset(){
        computerValues.clear();
        current = 0;
    }

    public int getNext(){
        if(current > computerValues.size())
            return computerValues.get(current++);
        //end
        return -1;
    }

}
