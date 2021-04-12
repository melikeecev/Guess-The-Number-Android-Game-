package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class GuessActivity extends AppCompatActivity {

    private TextView textViewKalanHak;
    private TextView textViewHelp;
    private EditText editTextInput;
    private Button buttonGuess;

    private int randomNumber;
    private int sayac=5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);

        textViewKalanHak = findViewById(R.id.textViewKalanHak);
        textViewHelp = findViewById(R.id.textViewHelp);
        editTextInput = findViewById(R.id.editTextInput);
        buttonGuess = findViewById(R.id.buttonGuess);

        Random r = new Random();
        randomNumber = r.nextInt(101);

        buttonGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sayac = sayac - 1;
                int guess = Integer.parseInt(editTextInput.getText().toString());
                if (guess == randomNumber){
                    Intent intent = new Intent(GuessActivity.this,ResultActivity.class);
                    intent.putExtra("result",true);
                    startActivity(intent);
                    finish();
                }else if (guess > randomNumber){
                    textViewHelp.setText("Azalt");
                    textViewKalanHak.setText("Kalan Hak: "+ sayac);
                }else{
                    textViewHelp.setText("Arttır");
                    textViewKalanHak.setText("Kalan Hak: "+ sayac);
                }

                if (sayac ==0) {
                    Intent intent = new Intent(GuessActivity.this,ResultActivity.class);
                    intent.putExtra("result",false);
                    startActivity(intent);
                    finish();
                }

                editTextInput.setText("");

            }
        });
    }
}