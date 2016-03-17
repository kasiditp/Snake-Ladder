package com.ske.snakebaddesign.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ske.snakebaddesign.R;
import com.ske.snakebaddesign.guis.BoardView;
import com.ske.snakebaddesign.models.Game;
import com.ske.snakebaddesign.models.DataDisplayDialog;

import java.util.Observable;
import java.util.Observer;

public class GameActivity  extends AppCompatActivity implements Observer {

    private Game game = Game.getInstance();

    private BoardView boardView;
    private Button buttonTakeTurn;
    private Button buttonRestart;
    private TextView textPlayerTurn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initComponents();
    }

    @Override
    protected void onStart() {
        super.onStart();
        game.resetGame();
    }

    private void initComponents() {
        game.addObserver(this);
        boardView = (BoardView) findViewById(R.id.board_view);
        buttonTakeTurn = (Button) findViewById(R.id.button_take_turn);
        buttonTakeTurn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.takeTurn();
            }
        });
        buttonRestart = (Button) findViewById(R.id.button_restart);
        buttonRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.resetGame();
            }
        });
        textPlayerTurn = (TextView) findViewById(R.id.text_player_turn);
    }


    /*
        Edited value to get value from die
     */


    /*
        Add game reset
     */


    private void displayDialog(String title, String message, DialogInterface.OnClickListener listener) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setCancelable(false);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", listener);
        alertDialog.show();
    }

    @Override
    public void update(Observable observable, Object data) {
        boardView.setP1Position(game.getPlayer1().getPosition());
        boardView.setP2Position(game.getPlayer2().getPosition());
        DataDisplayDialog d = (DataDisplayDialog) data;
        if(data == null){
            boardView.setBoardSize(game.getBoard().getSize());
            textPlayerTurn.setText("Player 1's Turn");

        }
        else if(d.getValue() != 0){
            if(game.getTurn() % 2 == 0 ){
                boardView.setP1Position(game.getPlayer1().movePiece(d.getValue()));
                textPlayerTurn.setText("Player 1's Turn");
            }
            else{
                boardView.setP2Position(game.getPlayer2().movePiece(d.getValue()));
                textPlayerTurn.setText("Player 2's Turn");
            }
        }

        else {
            if(d.getTitle()!=null)
                displayDialog(d.getTitle(), d.getMessage(), d.getListener());
        }
    }
}
