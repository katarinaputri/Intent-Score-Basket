package com.example.intent_score_basket;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    TextView tvjudul, tvteam1;
    EditText etteam1, etteam2;
    Button btnkirim;

    ImageView ivlogo1, ivlogo2;
    Uri uriLogo1, uriLogo2;

    private static final String TAG = MainActivity.class.getCanonicalName();
    private static final int TEAM1_REQUEST_CODE = 1;
    private static final int TEAM2_REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvjudul = findViewById(R.id.judul);
        tvteam1 = findViewById(R.id.team1);
        etteam1 = findViewById(R.id.nama_team1);
        etteam2 = findViewById(R.id.nama_team2);
        btnkirim = findViewById(R.id.kirim);

        ivlogo1 = findViewById(R.id.logo_team1);
        ivlogo2 = findViewById(R.id.logo_team2);

        btnkirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(MainActivity.this, MatchActivity.class);
                pindah.putExtra("team1", etteam1.getText().toString());
                pindah.putExtra("team2", etteam2.getText().toString());

                pindah.putExtra("logo1", uriLogo1.toString());
                pindah.putExtra("Logo2", uriLogo2.toString());
                startActivity(pindah);
            }
        });

        ivlogo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(Intent.ACTION_PICK,
                                MediaStore.Images.Media.EXTERNAL_CONTENT_URI),
                        TEAM1_REQUEST_CODE);
            }
        });

        ivlogo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(Intent.ACTION_PICK,
                                MediaStore.Images.Media.EXTERNAL_CONTENT_URI),
                        TEAM2_REQUEST_CODE);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED){
            Log.d(TAG, "Pilih Gambar Dicancel");
            return;
        }
        else if (requestCode == TEAM1_REQUEST_CODE){
            if (data != null){
                try {
                    Uri imageuri = data.getData();
                    uriLogo1 = imageuri;
                    Bitmap bitmap1 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uriLogo1);
                    ivlogo1.setImageBitmap(bitmap1);
                }
                catch (IOException error){
                    Toast.makeText(this, "Cant load image", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, error.getMessage());
                }
            }
        }
        else if (requestCode == TEAM2_REQUEST_CODE){
            if (data != null){
                try {
                    Uri imageuri = data.getData();
                    uriLogo2 = imageuri;
                    Bitmap bitmap2 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uriLogo2);
                    ivlogo2.setImageBitmap(bitmap2);
                }
                catch (IOException error){
                    Toast.makeText(this, "Cant load image", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, error.getMessage());
                }
            }
        }
    }
}