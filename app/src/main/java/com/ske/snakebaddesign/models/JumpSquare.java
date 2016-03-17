package com.ske.snakebaddesign.models;

/**
 * Created by Warata on 3/16/16 AD.
 */
public class JumpSquare extends Square{

    public JumpSquare(){
        super("Jump Square");
    }

    @Override
    public int sizeJump() {
        return 1;
    }

}
