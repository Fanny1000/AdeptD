package com.example.adeptdiction;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class LogInProfesos extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginprofesor);
    }
    public void prueba(View v){
        Intent i= new Intent(LogInProfesos.this, SignIn.class);
        startActivity(i);
    }
}
