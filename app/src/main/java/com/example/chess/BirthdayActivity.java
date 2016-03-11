package com.example.chess;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class BirthdayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView result = (TextView) findViewById(R.id.tv);
        Intent intent = getIntent();
        if(Integer.parseInt(intent.getStringExtra("moves"))==0){
            result.setText(R.string.impossible);
        }
        else if(Integer.parseInt(intent.getStringExtra("moves"))==100){
            result.setText(R.string.celebrate);
        }
        else{
            result.setText(getString(R.string.meeting1) + intent.getStringExtra("moves") + getString(R.string.meeting2));}

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
