package com.sushant.topicseven;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MeaningActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meaning);
        tv=findViewById(R.id.tvmeaning);
        Bundle bundle = getIntent().getExtras();

        if (bundle!= null){
            String meaning = bundle.getString("means");
            tv.setText(meaning);
        }
    }
}
