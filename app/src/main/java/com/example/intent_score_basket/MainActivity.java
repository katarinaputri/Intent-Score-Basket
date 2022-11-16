package com.example.intent_score_basket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvjudul, tvteam1;
    EditText etteam1, etteam2;
    Button btnkirim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvjudul = findViewById(R.id.judul);
        tvteam1 = findViewById(R.id.team1);
        etteam1 = findViewById(R.id.nama_team1);
        etteam2 = findViewById(R.id.nama_team2);
        btnkirim = findViewById(R.id.kirim);

        btnkirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(MainActivity.this, MatchActivity.class);
                pindah.putExtra("team1", etteam1.getText().toString());
                pindah.putExtra("team2", etteam2.getText().toString());
                startActivity(pindah);
            }
        });
    }
}