package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private ImageView imageViewFace;
    private TextView textViewResultMessage;
    private Button buttonPlayAgain;

    private boolean result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_ativity);

        imageViewFace = findViewById(R.id.imageViewFace);
        textViewResultMessage = findViewById(R.id.textViewResultMessage);
        buttonPlayAgain = findViewById(R.id.buttonPlayAgain);

        result = getIntent().getBooleanExtra("sonuc", false);
        if(result == true){
            textViewResultMessage.setText("KAZANDINIZ!");
            imageViewFace.setImageResource(R.drawable.mutlu_surat);
        }else{
            textViewResultMessage.setText("KAYBETTİNİZ!");
            imageViewFace.setImageResource(R.drawable.uzgun_surat);
        }
        buttonPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultActivity.this, GuessActivity.class));
                finish();
            }
        });
    }
}
