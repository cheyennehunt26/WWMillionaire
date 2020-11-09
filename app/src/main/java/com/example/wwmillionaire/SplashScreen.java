package com.example.wwmillionaire;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;


public class SplashScreen extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        button = (Button) findViewById(R.id.button);
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               openQuizActivity();

           }
       });


    }
    public void openQuizActivity(){
        Intent intent = new Intent(SplashScreen.this, Quiz.class);
        startActivity(intent);


    }
}
