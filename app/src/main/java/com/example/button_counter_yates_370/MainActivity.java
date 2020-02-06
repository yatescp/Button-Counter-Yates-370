package com.example.button_counter_yates_370;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.button_counter_yates_370.R;

public class MainActivity extends AppCompatActivity {

    private Button incrementButton;
    private Button decrementButton;
    private Button incrementButton2;
    private Button decrementButton2;
    private Button resetButton;
    private TextView textView;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        incrementButton = findViewById(R.id.incrementButton);
        decrementButton = findViewById(R.id.decrementButton);
        incrementButton2 = findViewById(R.id.incrementButton2);
        decrementButton2 = findViewById(R.id.decrementButton2);
        resetButton = findViewById(R.id.resetButton);
        textView = findViewById(R.id.textView);

        textView.setText(String.valueOf(counter));

        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                refreshCounter();
            }
        });

        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter--;
                refreshCounter();
            }
        });

        incrementButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter += 10;
                refreshCounter();
            }
        });

        decrementButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter -= 10;
                refreshCounter();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = 0;
                refreshCounter();
            }
        });

        counter = 0;
    }

    protected void refreshCounter(){
        textView.setText(String.valueOf(counter));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("key", counter);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        counter = savedInstanceState.getInt("key");

        refreshCounter();
    }
}
