package com.example.android.simplememo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MemoActivity extends AppCompatActivity {

    EditText et_memo;

    Button b_clear, b_save;

    String memo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        et_memo = (EditText) findViewById(R.id.et_memo);

        b_clear = (Button) findViewById(R.id.b_clear);
        b_save = (Button) findViewById(R.id.b_save);

        SharedPreferences preferences = getSharedPreferences("PREFS", 0);
        memo = preferences.getString("memo", "");

        et_memo.setText(memo);

        b_clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                memo = "";
                et_memo.setText(memo);
            }
        });

        b_save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                memo = et_memo.getText().toString();

                SharedPreferences preferences = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("memo", memo);
                editor.commit();

                Toast.makeText(MemoActivity.this, "Memo saved!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
