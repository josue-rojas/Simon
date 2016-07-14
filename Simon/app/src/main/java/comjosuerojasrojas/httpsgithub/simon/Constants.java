package comjosuerojasrojas.httpsgithub.simon;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by josuerojas on 7/13/16.
 */
public class Constants {

    //colors
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
    static int[] ID = new int[4];
    static String[] colorPressed = {bluePress,redPress,greenPress,yellowPress};
    static String[] colorDefault = {blueDefault,redDefault,greenDefault,yellowDefault};
    static HashMap<Integer,String> idToColor = new HashMap<>();
    static HashMap<Integer,String> idToColorDef = new HashMap<>();

}
