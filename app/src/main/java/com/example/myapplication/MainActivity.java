package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView scoreTeamLeft;
    TextView scoreTeamRight;
    TextView nameTeamLeft;
    TextView nameTeamRight;

    Button addTeam1;
    Button addTeam2;
    Button resetScore;
    Button changeLocale;

    boolean isRus = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreTeamLeft = findViewById(R.id.scoreTeamLeft);
        scoreTeamRight = findViewById(R.id.scoreTeamRight);
        nameTeamLeft = findViewById(R.id.nameTeam1);
        nameTeamRight = findViewById(R.id.nameTeam2);

        addTeam1 = findViewById(R.id.addTeam1);
        addTeam2 = findViewById(R.id.addTeam2);

        resetScore = findViewById(R.id.resetScore);
        addTeam1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//Получение текущего счёта команды
                int currentValue = Integer.parseInt(scoreTeamLeft.getText().toString());
                currentValue++;
                scoreTeamLeft.setText(currentValue + "");
            }
        });

        addTeam2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//Получение текущего счёта команды
                int currentValue = Integer.parseInt(scoreTeamRight.getText().toString());
                currentValue++;
                scoreTeamRight.setText(currentValue + "");
            }
        });

        resetScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreTeamLeft.setText("0");
                scoreTeamRight.setText("0");
            }
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("scoreLeft", scoreTeamLeft.getText().toString());
        outState.putString("scoreRight", scoreTeamRight.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String restore = savedInstanceState.getString("scoreLeft");
        scoreTeamLeft.setText(restore);
        restore = savedInstanceState.getString("scoreRight");
        scoreTeamRight.setText(restore);
    }
}