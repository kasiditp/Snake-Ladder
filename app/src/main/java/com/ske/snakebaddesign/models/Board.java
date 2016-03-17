package com.ske.snakebaddesign.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Warata on 3/15/16 AD.
 */
public class Board {

    private int size;
    private List<Square> squareList;

    public Board(){
        size = 6;
        squareList = new ArrayList<Square>();
        createSquare();
    }

    public void createSquare(){
        for(int i = 0 ; i < size*size ; i++){
            if(i == 4 || i == 12 || i == 21){
                squareList.add(new JumpSquare());
            }
            else{
                squareList.add(new NormalSquare());
            }
        }
    }

    public int squareAction(int position){
        return squareList.get(position).sizeJump();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
