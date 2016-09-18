package com.example.rom.hocsqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView tvName,tvAge,tvSdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        tvName=(TextView)findViewById(R.id.tvName);
        tvAge=(TextView)findViewById(R.id.tvAge);
        tvSdt=(TextView)findViewById(R.id.tvSdt);

        Intent intent = getIntent();
        String ten=intent.getStringExtra("name");
        String tuoi=intent.getStringExtra("tuoi");
        String sdt=intent.getStringExtra("sdt");
        tvName.setText(ten);
        tvAge.setText(tuoi);
        tvSdt.setText(sdt);
        //cái trung quần què

    }

}