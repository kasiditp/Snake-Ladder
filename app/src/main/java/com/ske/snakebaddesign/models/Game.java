package com.ske.snakebaddesign.models;

import android.content.DialogInterface;

import java.util.Observable;

/**
 * Created by Warata on 3/15/16 AD.
 */
public class Game extends Observable{
    private static Game instance;
    private Player player1;
    private Player player2;
    private Board board;
    private int turn;

    public Game() {
        board = new Board();
        player1 = new Player();
        player2 = new Player();
    }

    public static Game getInstance(){
        if(instance == null){
            instance = new Game();
        }
        return instance;
    }

    public void takeTurn() {
        final int value = playerRollDie();
        String title = "You rolled a die";
        String msg = "You got " + value;
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                moveCurrentPiece(value);
                dialog.dismiss();
                checkSquare();
            }
        };
        System.out.println("HKJHKHHIHIUHIUHUBKVL");
        DataDisplayDialog data = new DataDisplayDialog(title, msg, listener);

        setChanged();
        notifyObservers(data);
//        displayDialog(title, msg, listener);

        turn++;

    }

    private void moveCurrentPiece(int value) {
            setChanged();
            notifyObservers(new DataDisplayDialog(value));
        checkWin();
    }

    public void resetGame() {
        turn = 0;
        player1.setPosition(0);
        player2.setPosition(0);
        board.setSize(6);
        setChanged();
        notifyObservers(null);
    }

    public Player getPlayer1(){
        return player1;
    }

    public Player getPlayer2(){
        return player2;
    }

    public int playerRollDie() {
        if (turn % 2 == 0) {
            return player1.rollDie();
        } else {
            return player2.rollDie();
        }
    }

    public int getTurn() {
        return turn;
    }

    public int adjustPosition(int current, int distance) {
        current = current + distance;
        int maxSquare = board.getSize() * board.getSize() - 1;
        if(current > maxSquare) {
            current = maxSquare - (current - maxSquare);
        }
        return current;
    }

    public Board getBoard(){
        return board;
    }

    public void checkSquare(){
        String title = "You fall into JumpSquare";
        String msg = "You got 1 extra move";
        int movesize = 0;
        if(turn % 2 == 0) {
            movesize = board.squareAction(player1.getPosition());
        } else {
            movesize = board.squareAction(player2.getPosition());
        }


        if(movesize == 0){
            return;
        }
        else {
            DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    moveCurrentPiece( board.squareAction(player1.getPosition()));
                    moveCurrentPiece( board.squareAction(player2.getPosition()));
                    dialog.dismiss();
                }
            };
            DataDisplayDialog d = new DataDisplayDialog(title, msg, listener);
            setChanged();
            notifyObservers(d);
        }

    }

    private void checkWin() {
        String title = "Game Over";
        String msg = "";
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                resetGame();
                dialog.dismiss();
            }
        };
        if (player1.getPosition() == board.getSize() * board.getSize() - 1) {
            msg = "Player 1 won!";
        } else if (player2.getPosition() == board.getSize() * board.getSize() - 1) {
            msg = "Player 2 won!";
        } else {
            return ;
        }
        setChanged();
        notifyObservers(new DataDisplayDialog(title, msg, listener));
    }

}
