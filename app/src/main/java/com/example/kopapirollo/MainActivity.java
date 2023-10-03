package com.example.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewYourChoice;
    private ImageView imageViewCpChoice;
    private TextView textViewYourChoice;
    private TextView textViewCpChoice;
    private TextView textViewResult;
    private Button buttonRock;
    private Button buttonPaper;
    private Button buttonScissors;
    private Random random;
    private int cpChoice;
    private int yourChoice;
    private int winCounter;
    private int loseCounter;
    private AlertDialog.Builder alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        buttonRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageViewYourChoice.setImageResource(R.drawable.rock);
                yourChoice = 0;
                Szabaly();
                if (winCounter == 3)
                {
                    alertDialog.setTitle("Győzelem").create().show();
                }
                else if (loseCounter == 3)
                {
                    alertDialog.setTitle("Veszteség").create().show();
                }
            }
        });

        buttonPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageViewYourChoice.setImageResource(R.drawable.paper);
                yourChoice = 1;
                Szabaly();
                if (winCounter == 3)
                {
                    alertDialog.setTitle("Győzelem").create().show();
                }
                else if (loseCounter == 3)
                {
                    alertDialog.setTitle("Veszteség").create().show();
                }
            }
        });

        buttonScissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageViewYourChoice.setImageResource(R.drawable.scissors);
                yourChoice = 2;
                Szabaly();
                if (winCounter == 3)
                {
                    alertDialog.setTitle("Győzelem").create().show();
                }
                else if (loseCounter == 3)
                {
                    alertDialog.setTitle("Vereség").create().show();
                }
            }
        });
    }

    public void init()
    {
        imageViewYourChoice = findViewById(R.id.imageViewYourChoice);
        imageViewCpChoice = findViewById(R.id.imageViewCpChoice);
        textViewYourChoice = findViewById(R.id.textViewYourChoice);
        textViewCpChoice = findViewById(R.id.textViewCpChoice);
        textViewResult = findViewById(R.id.textViewResult);
        buttonRock = findViewById(R.id.buttonRock);
        buttonPaper = findViewById(R.id.buttonPaper);
        buttonScissors = findViewById(R.id.buttonScissors);
        winCounter = 0;
        loseCounter = 0;
        cpChoice = 0;
        alertDialog = new AlertDialog.Builder(MainActivity.this)
                .setTitle("Győzelem")
                .setMessage("Szeretne új játékot játszani?")
                .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        newGame();
                    }
                })
                .setCancelable(false);
    }

    public void Szabaly()
    {
        random = new Random();
        cpChoice = random.nextInt(3);
        switch (cpChoice)
        {
            case 0:
                imageViewCpChoice.setImageResource(R.drawable.rock);
                break;
            case 1:
                imageViewCpChoice.setImageResource(R.drawable.paper);
                break;
            case 2:
                imageViewCpChoice.setImageResource(R.drawable.scissors);
                break;
        }
        if ((yourChoice == 0 && cpChoice == 2) || (yourChoice == 1 && cpChoice == 0) || (yourChoice == 2 && cpChoice == 1))
        {
            Toast.makeText(this, "Győztél", Toast.LENGTH_SHORT).show();
            winCounter++;
        }
        else if (yourChoice == cpChoice)
        {
            Toast.makeText(this, "Döntetlen", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Vesztettél", Toast.LENGTH_SHORT).show();
            loseCounter++;
        }
        textViewResult.setText("Eredmény: Ember: " + winCounter + " Computer: " + loseCounter);
    }

    public void newGame()
    {
        yourChoice = 0;
        cpChoice = 0;
        imageViewYourChoice.setImageResource(R.drawable.rock);
        imageViewCpChoice.setImageResource(R.drawable.rock);
        winCounter = 0;
        loseCounter = 0;
        textViewResult.setText("Eredmény: Ember: 0 Computer : 0");
    }
}