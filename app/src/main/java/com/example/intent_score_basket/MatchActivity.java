package com.example.intent_score_basket;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MatchActivity extends AppCompatActivity {
    TextView tvnama1, tvnama2;
    TextView tvscore1, tvscore2;

    int scoreTeam1, scoreTeam2 = 0;

    ImageView ivlogoo1, ivlogoo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        tvnama1 = findViewById(R.id.namateam1);
        tvnama2 = findViewById(R.id.namateam2);

        ivlogoo1 = findViewById(R.id.logo1);
        ivlogoo2 = findViewById(R.id.logo2);

        String nama_team1 = getIntent().getExtras().getString("team1");
        String nama_team2 = getIntent().getExtras().getString("team2");

        tvnama1.setText(nama_team1);
        tvnama2.setText(nama_team2);

        Uri team1logo = Uri.parse(getIntent().getExtras().getString("Logo1"));
        Uri team2logo = Uri.parse(getIntent().getExtras().getString("Logo2"));

        ivlogoo1.setImageURI(team1logo);
        ivlogoo2.setImageURI(team2logo);

    }

    public void displayTeam1 (int score){
        tvscore1 = findViewById(R.id.score_team1);
        tvscore1.setText(String.valueOf(score));
    }

    public void Tiga_Team1(View v){
        scoreTeam1 = scoreTeam1+3;
        displayTeam1(scoreTeam1);
    }

    public void Dua_Team1(View v){
        scoreTeam1 = scoreTeam1+2;
        displayTeam1(scoreTeam1);
    }

    public void Satu_Team1(View v){
        scoreTeam1 = scoreTeam1+1;
        displayTeam1(scoreTeam1);
    }

    public void displayTeam2 (int score){
        tvscore2 = findViewById(R.id.score_team2);
        tvscore2.setText(String.valueOf(score));
    }

    public void Tiga_Team2(View v){
        scoreTeam2 = scoreTeam2+3;
        displayTeam2(scoreTeam2);
    }

    public void Dua_Team2(View v){
        scoreTeam2 = scoreTeam2+2;
        displayTeam2(scoreTeam2);
    }

    public void Satu_Team2(View v){
        scoreTeam2 = scoreTeam2+1;
        displayTeam2(scoreTeam2);
    }

    public void resetScore(View v){
        scoreTeam1 = 0;
        scoreTeam2 = 0;
        displayTeam1(scoreTeam1);
        displayTeam2(scoreTeam2);
    }
}