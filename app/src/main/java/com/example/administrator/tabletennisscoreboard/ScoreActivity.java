package com.example.administrator.tabletennisscoreboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class ScoreActivity extends AppCompatActivity {
    TextView player1,player2;
    EditText score1,score2;
    TextView dispWinStatus1,dispWinStatus2,dispServe;
    Button playAgain;
    Button scorePlayer1, scorePlayer2;
    static int serve = 0;
    int i;
    static int count1 = 0;
    static int count2 = 0;
    static String server, tempstring;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        player1=(TextView) findViewById(R.id.textviewName1);
        player2=(TextView) findViewById(R.id.textviewName2);
        dispServe =(TextView) findViewById(R.id.textviewServe);
        dispWinStatus1=(TextView) findViewById(R.id.textviewWin1);
        dispWinStatus2=(TextView)findViewById(R.id.textviewWin2);
        scorePlayer1=(Button) findViewById(R.id.buttonScore1);
        scorePlayer2=(Button) findViewById(R.id.buttonScore2);
        playAgain=(Button) findViewById(R.id.buttonPlayAgain);
        score1=(EditText) findViewById(R.id.editTextScore1);
        score2=(EditText) findViewById(R.id.editTextScore2);

        Intent i=getIntent();
        Bundle b= i.getExtras();
        final String name1= b.getString("name1");
        final String name2= b.getString("name2");

        player1.setText(name1);
        player2.setText(name2);
        setTitle("                   SCORE BOARD");
        Random rand = new Random();

        // Get a random value, 0 or 1.
        int value = rand.nextInt(2);
        count1=0;
        count2=0;
        score1.setText(""+count1);
        score2.setText(""+count2);
        dispWinStatus1.setText("");
        dispWinStatus2.setText("");
        if (value == 1) {
            //score1.setBackground(color.GREEN);
            String server=name1;
            dispServe.setText("serving by "+name1);

        }
        else{
            server=name2;
            dispServe.setText("serving by  "+name2);

        }
        scorePlayer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (count1==11||count2==11)
                {
                    dispWinStatus1.setText("  Game over!!!");
                    dispServe.setText("");
                }
                else {
                    count1++;
                    score1.setText(""+count1);
                    serve++;
                    if (serve == 2) {
                        if (server == name1) {
                            //tempstring = server;
                            server = name2;
                            dispServe.setText(" serving by " + server);

                        } else {
                            //tempstring = server;
                            server = name1;
                            dispServe.setText(" serving by " + server);
                        }
                        serve = 0;
                    }


                    if (count1 == 10) {
                        dispWinStatus1.setText("*Game point for "+name1+"!!");
                    }
                    if (count1 == 11) {
                        dispWinStatus1.setText("*****"+name1 +"  wins!!*****");
                        dispServe.setText("");
                    }
                }
            }
        });


        scorePlayer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count1==11||count2==11)
                {
                    dispWinStatus2.setText("  Game over!!!");
                    dispServe.setText("");
                }
                else {
                    count2++;
                    score2.setText(""+count2);
                    serve++;
                    if (serve == 2) {
                        if (server == name2) {
                            server = name1;
                            dispServe.setText(" serving by " + server);

                        } else {
                            //tempstring = server;
                            server = name2;
                            dispServe.setText(" serving by " + server);
                        }
                        serve = 0;
                    }


                    if (count2== 10) {
                        dispWinStatus1.setText("*Game point for "+name2+"!!");
                    }
                    if (count2 == 11) {
                        dispWinStatus1.setText("*****"+name2 +"  wins!!*****");
                    }
                }

            }
        });
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ScoreActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
