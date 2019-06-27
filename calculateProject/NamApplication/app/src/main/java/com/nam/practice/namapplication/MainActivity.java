package com.nam.practice.namapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // inputTextView 객체 생성
    private TextView inputTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // findViewById R class 로 부터 id 정보를 받아옴
        inputTextView = findViewById(R.id.inputTextView);

        //Button 0~9 까지 입력시 화면에 출력
        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connectNewTextAfterExistingText("1");


            }
        });
        Button btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connectNewTextAfterExistingText("2");
            }
        });
        Button btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connectNewTextAfterExistingText("3");

            }
        });
        Button btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connectNewTextAfterExistingText("4");

            }
        });
        Button btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connectNewTextAfterExistingText("5");

            }
        });
        Button btn6 = findViewById(R.id.btn6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connectNewTextAfterExistingText("6");

            }
        });
        Button btn7 = findViewById(R.id.btn7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connectNewTextAfterExistingText("7");

            }
        });
        Button btn8 = findViewById(R.id.btn8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connectNewTextAfterExistingText("8");

            }
        });
        Button btn9 = findViewById(R.id.btn9);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connectNewTextAfterExistingText("9");

            }
        });
        Button btn0 = findViewById(R.id.btn0);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connectNewTextAfterExistingText("0");

            }
        });
        Button btnPlus = findViewById(R.id.btnPlus);
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connectNewTextAfterExistingText("+");

            }
        });
        Button btnMinus = findViewById(R.id.btnMinus);
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connectNewTextAfterExistingText("-");

            }
        });
        Button btnMul = findViewById(R.id.btnMul);
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connectNewTextAfterExistingText("*");

            }
        });
        Button btnDivi = findViewById(R.id.btnDivi);
        btnDivi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connectNewTextAfterExistingText("/");

            }
        });

        Button btnResult = findViewById(R.id.btnResult);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // inputtedText 변수로  inputTextView 객체안에 담긴 문자열을 String 으로 받아온다
                String inputtedText = inputTextView.getText().toString();
                // inputtedText String 을 toCharArray 함수로 받아옴(문장을 한글자 단위로 쪼갬)
                char[] charArray = inputtedText.toCharArray();
                char target = '*';
                int targetPreviousIndex = 0;
                int targetNextIndex = 0;
// 배열 0번째 부터 마지막 공간보다 작을때 까지 i 를 1씩 더해서 반복해겠다 nowChar 와 target 이 같을때까지
                for(int i=0; i<charArray.length; i++){
                    char nowChar = charArray[i];
                    if(nowChar == target) {
// target '*' 의 앞 뒤 배열의 정보를 찾기 위해 i -1; , i + 1; 로 접근함
                        targetPreviousIndex = i-1;
                        targetNextIndex = i+1;
                        break;
                    }
                }
// 기호 '*' 앞쪽 targetPreviousIndex 까지의 숫자를 charArray 로 부터 가져온다.
                int targetBeforeNumber = getNumberFromCharArray(charArray, 0 , targetPreviousIndex);
// 기호 '*' 뒷쪽부터 charArray 끝까지의 숫자를 charArray 로 부터 가져온다.
                int targetAfterNumber = getNumberFromCharArray(charArray, targetNextIndex, charArray.length-1);
// '*' 앞쪽 까지의 숫자와 '*' 뒷쪽부터 끝까지의 숫자를 곱하고 출력하겠다.
                int multiplication= targetBeforeNumber * targetAfterNumber;
                inputTextView.setText(multiplication + "");


            }
        });
    }

// charArray 에서 가져오는 정보를 getNumberFromCharArray 함수로 만듬
    private int getNumberFromCharArray(char[] charArray, int startIndex, int endIndex) {
        String targetText = "";
// i = startIndex 부터 i <= endIndex 까지 반복 하겟다
        for(int i=startIndex; i<=endIndex; i++) {
// 반복된 배열의 문자열을 순서대로 나열
            targetText = targetText + charArray[i];
        }
// 문자열이 숫자일 경우 String 문자열을 int 형 으로 변환 하겠다
        int targetNumber = Integer.parseInt(targetText);
// int 형 숫자가 나오면 반환 하겠다
        return targetNumber;

    }
// connectNewTextAfterExistingText 함수 를 String 매개변수 newText 로 설정
    private void connectNewTextAfterExistingText(String newText) {
        String existingText = inputTextView.getText().toString();
        String connectedText = existingText + newText;
// inputTextView 에 connectedText 를 집어넣어서 화면에 출력 되도록 하겠다
        inputTextView.setText(connectedText);
    }

}

