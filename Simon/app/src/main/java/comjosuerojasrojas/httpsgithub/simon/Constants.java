package comjosuerojasrojas.httpsgithub.simon;

import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * this class is just to hold constants
 * Created by josuerojas on 7/13/16.
 */
public class Constants {

    //colors
    static final int numButtons = 4;
    static String redPress = "#FF0032",
            redDefault = "#9C0422",
            bluePress = "#03E8FF",
            blueDefault = "#04529C",
            greenPress = "#00FF0F",
            greenDefault = "#016B18",
            yellowPress = "#EFFF00",
            yellowDefault = "#788002";

    static int blue = 0,
               red = 1,
               green = 2,
               yellow = 3;
    //array that hold the id of buttons
    static int[] ID = new int[4];
    //color arrays
    static String[] colorPressed = {bluePress,redPress,greenPress,yellowPress};
    static String[] colorDefault = {blueDefault,redDefault,greenDefault,yellowDefault};
    //hashmaps with id of buttons and their color
    static HashMap<Integer,String> idToColor = new HashMap<>();
    static HashMap<Integer,String> idToColorDef = new HashMap<>();
    //delay for the computer ai showing the color. should change this lower to make it harder
    static int delay = 2000;


}
