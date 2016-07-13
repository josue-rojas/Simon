package com.morales.edgar.simonsays;

import java.util.Queue;
import java.util.Stack;

/**
 * Created by Mor-Men on 7/13/2016.
 */
public abstract class computerAI {
    static Stack stack;
    static Queue queue;

    public abstract void putNextColor();

    public abstract int getNextColor();

    public abstract void reset();

}
