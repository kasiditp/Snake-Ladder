package com.ske.snakebaddesign.models;

/**
 * Created by Warata on 3/15/16 AD.
 */
public class Player {
    private int position;
    private Die die;

    public Player(){
        position = 0;
        die = new Die();
    }

    public int rollDie(){
        return die.roll();
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int movePiece(int distance){
        position = Game.getInstance().adjustPosition(position, distance);
        return position;
    }

    public Die getDie(){
        return die;
    }
}
