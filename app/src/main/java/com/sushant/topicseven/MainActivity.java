package com.sushant.topicseven;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class MainActivity extends AppCompatActivity {

    private EditText word, meaning;
    private Button addw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        word = findViewById(R.id.etword);
        meaning = findViewById(R.id.etmeaning);
        addw = findViewById(R.id.btnadd);

        addw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               save();


            }
        });
    }
    public void save(){

        if (TextUtils.isEmpty(word.getText().toString())){
            word.setError("type word"); return;
        }

        try {
            PrintStream printStream = new PrintStream(openFileOutput("words.txt", MODE_PRIVATE | MODE_APPEND));
            printStream.println(word.getText().toString() + "->" + meaning.getText().toString());
            Toast.makeText(MainActivity.this, "word saved to " + getFilesDir(), Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this,DisplayActivity.class);
            startActivity(intent);
        } catch (FileNotFoundException e) {
            Log.d("Dictionary app", "Error" + e.toString());
            e.printStackTrace();
        }

    }}
