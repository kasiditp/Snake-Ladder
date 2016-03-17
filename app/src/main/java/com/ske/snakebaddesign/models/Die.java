package com.ske.snakebaddesign.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Warata on 3/15/16 AD.
 */
public class Die {
    private int value;
    private List<Integer> valueList;

    public Die(){
        valueList = new ArrayList<Integer>();
    }

    public int roll(){
        value = 1 + new Random().nextInt(6);
        valueList.add(value);
        return value;
    }

}
