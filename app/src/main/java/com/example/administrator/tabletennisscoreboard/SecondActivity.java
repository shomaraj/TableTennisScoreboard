package com.example.administrator.tabletennisscoreboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    EditText player1,player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        player1=(EditText)findViewById(R.id.editTextPlayer1);
        player2=(EditText)findViewById(R.id.editTextPlayer2);
        Intent i=getIntent();
        Bundle b= i.getExtras();
        String name1= b.getString("name1");
        String name2= b.getString("name2");

        player1.setText(name1);
        player2.setText(name2);
        setTitle("SCORE BOARD");
    }
}
