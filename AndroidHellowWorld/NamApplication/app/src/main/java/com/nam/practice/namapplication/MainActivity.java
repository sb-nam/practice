package com.nam.practice.namapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.MyTextView);
        textView.setText("내가 직접 입력한 Text");

        Button button = findViewById(R.id.MyButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("버튼이 눌렸습니다.");
                Toast.makeText(MainActivity.this, "와 진짜 버튼눌림", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
