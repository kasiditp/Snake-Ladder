package com.ske.snakebaddesign.models;

/**
 * Created by Warata on 3/16/16 AD.
 */
public class NormalSquare extends Square {

    public NormalSquare(){
        super("Normal Square");
    }

    public String getName(){
        return super.getName();
    }

    @Override
    public int sizeJump() {
        return 0;
    }
}
