package com.example.desktop.crossoverapplication;

import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Integer activePlayer = 0;
    String[] crossOver = new String[9];

    public void dropIn(View view){

        ImageView counter = (ImageView) view;

        System.out.println(counter.getTag().toString());

        counter.setTranslationY(-1000f);

        if(activePlayer.equals(0)){
            counter.setImageResource(R.drawable.red);
            crossOver[Integer.parseInt(counter.getTag().toString())] = "red";
            activePlayer = 1;
        }
        else{
            counter.setImageResource(R.drawable.yellow);
            crossOver[Integer.parseInt(counter.getTag().toString())] = "yellow";
            activePlayer = 0;
        }

        counter.animate().translationYBy(1000f).rotation(360).setDuration(300);

        for(Integer i = 0; i < 9; i++){
            if (
                       crossOver[0] == crossOver[1]
                    && crossOver[1] == crossOver[2]
                    && crossOver[0] == crossOver[2]
                    && crossOver[0] != null
                    && crossOver[1] != null
                    && crossOver[2] != null
            ){
                winner(crossOver[0]);
            }

            if (
                       crossOver[3] == crossOver[4]
                    && crossOver[4] == crossOver[5]
                    && crossOver[3] == crossOver[5]
                    && crossOver[3] != null
                    && crossOver[4] != null
                    && crossOver[5] != null
            )
            {
                winner(crossOver[3]);
            }

            if (
                       crossOver[6] == crossOver[7]
                    && crossOver[7] == crossOver[8]
                    && crossOver[6] == crossOver[8]
                    && crossOver[6] != null
                    && crossOver[7] != null
                    && crossOver[8] != null
            )
            {
                winner(crossOver[6]);
            }

            if (
                    crossOver[0] == crossOver[3]
                            && crossOver[3] == crossOver[6]
                            && crossOver[0] == crossOver[6]
                            && crossOver[0] != null
                            && crossOver[3] != null
                            && crossOver[6] != null
                    )
            {
                winner(crossOver[0]);
            }

            if (
                    crossOver[1] == crossOver[4]
                            && crossOver[4] == crossOver[7]
                            && crossOver[1] == crossOver[7]
                            && crossOver[1] != null
                            && crossOver[4] != null
                            && crossOver[7] != null
                    )
            {
                winner(crossOver[1]);
            }

            if (
                    crossOver[2] == crossOver[5]
                            && crossOver[5] == crossOver[8]
                            && crossOver[2] == crossOver[8]
                            && crossOver[2] != null
                            && crossOver[5] != null
                            && crossOver[8] != null
                    )
            {
                winner(crossOver[2]);
            }

            if (
                    crossOver[0] == crossOver[4]
                            && crossOver[4] == crossOver[8]
                            && crossOver[0] == crossOver[8]
                            && crossOver[0] != null
                            && crossOver[4] != null
                            && crossOver[8] != null
                    )
            {
                winner(crossOver[0]);
            }

            if (
                    crossOver[0] == crossOver[4]
                            && crossOver[4] == crossOver[8]
                            && crossOver[0] == crossOver[8]
                            && crossOver[0] != null
                            && crossOver[4] != null
                            && crossOver[8] != null
                    )
            {
                winner(crossOver[0]);
            }

            if (
                    crossOver[2] == crossOver[4]
                            && crossOver[4] == crossOver[6]
                            && crossOver[2] == crossOver[6]
                            && crossOver[2] != null
                            && crossOver[4] != null
                            && crossOver[6] != null
                    )
            {
                winner(crossOver[2]);
            }
        }
    }

    protected void winner(String winner){
        LinearLayout linearLayoutPlayAgain = findViewById(R.id.linearLayoutPlayAgain);
        TextView textView = (TextView) linearLayoutPlayAgain.getChildAt(0);
        textView.setText(winner + ", has won!");
        if (winner == "red"){
            linearLayoutPlayAgain.setBackgroundColor(Color.RED);
        }
        else {
            linearLayoutPlayAgain.setBackgroundColor(Color.YELLOW);
        }
        linearLayoutPlayAgain.setVisibility(View.VISIBLE);
    }

    public void btnPlayAgainOnClick(View view){
        LinearLayout linearLayoutPlayAgain = findViewById(R.id.linearLayoutPlayAgain);
        linearLayoutPlayAgain.setVisibility(View.INVISIBLE);

        activePlayer = 0;
        android.support.v7.widget.GridLayout grid = (android.support.v7.widget.GridLayout)findViewById(R.id.gridLayoutCrossOver);

        for (Integer i = 0; i < crossOver.length; i++){
            crossOver[i] = null;
            ImageView imageView = (ImageView) grid.getChildAt(i);
            imageView.setImageResource(0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
