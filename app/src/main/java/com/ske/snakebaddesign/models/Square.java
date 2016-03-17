package com.ske.snakebaddesign.models;

/**
 * Created by Warata on 3/15/16 AD.
 */
public abstract class Square {
    private String name;
    public Square(String name){
        this.name = name;
    }
    public abstract int sizeJump();

    public String getName() {
        return name;
    }
}
