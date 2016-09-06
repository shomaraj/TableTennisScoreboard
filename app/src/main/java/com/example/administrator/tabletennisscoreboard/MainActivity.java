package com.example.administrator.tabletennisscoreboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button btnStart;
    EditText playername1;
    EditText playername2;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playername1 = (EditText) findViewById(R.id.edit_TextPlayer1);
        playername2 = (EditText) findViewById(R.id.edit_TextPlayer2);
        btnStart = (Button) findViewById(R.id.buttonStart);
        // image=(ImageView)findViewById(R.id.imageView);
        setTitle("LETS PLAY TABLE TENNIS");
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playername1.getText().toString().isEmpty() || playername2.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter both Player's Names!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent(MainActivity.this, ScoreActivity.class);
                    i.putExtra("name1", playername1.getText().toString());
                    i.putExtra("name2", playername2.getText().toString());
                    playername1.setText("");
                    playername2.setText("");
                    startActivity(i);
                }

            }
        });

    }
}