package com.example.user.eventhandling;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1, button2, button3;
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        button1.setOnClickListener(new MyButtonHandler(getApplicationContext()));  // 기본 생성시 전달 불가능 -> 생성자 만들어야함
        button2.setOnClickListener(new MySSButtonHandler());
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Third button", Toast.LENGTH_SHORT).show();
            }
        });

        final EditText editText = (EditText) findViewById(R.id.search);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    Toast.makeText(getApplicationContext(), editText.getText(), Toast.LENGTH_SHORT).show();
                    editText.setText("");
                    handled = true;
                 }
                return false;
            }
        });

        CheckBox cb1, cb2;
        cb1 = (CheckBox) findViewById(R.id.checkBox_meat);
        cb1.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    Toast.makeText(getApplicationContext(), "meat click", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "meat unclick", Toast.LENGTH_SHORT).show();
            }
        });

        cb2 = (CheckBox) findViewById(R.id.checkBox_cheese);
        cb2.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    Toast.makeText(getApplicationContext(), "cheese click", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "cheese unclick", Toast.LENGTH_SHORT).show();
            }
        });

        CompoundButton.OnCheckedChangeListener ccl = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    Toast.makeText(getApplicationContext(), buttonView.getText() + " is checked." , Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), buttonView.getText() + " is unchecked." , Toast.LENGTH_SHORT).show();

            }
        };

        RadioButton rb = (RadioButton) findViewById(R.id.radio_red);
        rb.setOnCheckedChangeListener(ccl);

        rb = (RadioButton) findViewById(R.id.radio_blue);
        rb.setOnCheckedChangeListener(ccl);
    }

    public void onCheckboxClicked(View v) {
        boolean checked = ((CheckBox) v).isChecked();
        switch(v.getId()) {
            case R.id.checkBox_meat :
                if(checked)
                    Toast.makeText(getApplicationContext(), "meat click", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "meat unclick", Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkBox_cheese :
                if(checked)
                    Toast.makeText(getApplicationContext(), "cheese click", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "cheese unclick", Toast.LENGTH_SHORT).show();
                break;
        }
    }
//    public void run_me(View view){
//        Toast.makeText(getApplicationContext(), "First Button Clicked", Toast.LENGTH_SHORT).show();
//    }

    public class MySSButtonHandler implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "Second Button Clicked", Toast.LENGTH_SHORT).show();
         }
    }

    public void onRadioButtonClicked(View v) {

        RadioButton rb = (RadioButton) v;
        boolean checked = rb.isChecked();

        // 위의 것이 코드의 가독성 높음
        switch (v.getId()) {
            case R.id.radio_red:
                Toast.makeText(getApplicationContext(), rb.getText() + " is checked." , Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_blue:
                Toast.makeText(getApplicationContext(), ((RadioButton) v).getText() + " is checked." , Toast.LENGTH_SHORT).show();
                break;
        }
    }

}






//public class MainActivity extends AppCompatActivity {
//
//    TextView text, text2, text3, text4;
//    int number1, number2, result;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.calculator);
//
//        text = (TextView) findViewById(R.id.textView);
//        text2 = (TextView) findViewById(R.id.textView2);
//        text3 = (TextView) findViewById(R.id.textop);
//        text4 = (TextView) findViewById(R.id.textop2);
//        result = 0;
//        number1 = 0; number2 =0;
//    }
//
//
//    // 원래는 2 + 22 => 24 표기 후 button2를 누르면 24 값이 지워지고 2를 띄우고 싶었는데 방법을 몰라 한자릿수로 작성했습니다.
//     public void buttoncheck(View v) {
//
//        if(text.getText().equals("Nemeric Type")) {
//            text.setText("");
//            text2.setText("");
//        }
//
//        switch(v.getId()) {
//            case R.id.button0:
//
//                // 이런식의 로직은 한자릿수 밖에 표시 할 수 없음
//                if (text3.getText().equals("+")) {
//                    number1 = Integer.parseInt(text.getText().toString());
//                    result = number1+0;
//                    text.setText(Integer.toString(result));
//                    text2.setText(text2.getText().toString() + "0");
//                }
//
//                else if (text3.getText().equals("-")) {
//                    number1 = Integer.parseInt(text.getText().toString());
//                    result = number1-0;
//                    text.setText(Integer.toString(result));
//                    text2.setText(text2.getText().toString() + "0");
//                }
//
//                else if (text3.getText().equals("*")) {
//                    number1 = Integer.parseInt(text.getText().toString());
//                    result = number1*0;
//                    text.setText(Integer.toString(result));
//                    text2.setText(text2.getText().toString() + "0");
//                }
//
//                else if (text3.getText().equals("/")) {
//                    text.setText("0으로 나눌 수 없습니다.");
//                }
//
//                else if (text3.getText().toString().isEmpty()) {
//                    text.setText(text.getText().toString() + "0");
//                    text2.setText(text2.getText().toString() + "0");
//                }
//                break;
//
//            case R.id.button1:
//                if (text3.getText().equals("+")) {
//                    number1 = Integer.parseInt(text.getText().toString());
//                    result = number1+1;
//                    text.setText(Integer.toString(result));
//                    text2.setText(text2.getText().toString() + "1");
//                }
//
//                else if (text3.getText().equals("-")) {
//                    number1 = Integer.parseInt(text.getText().toString());
//                    result = number1-1;
//                    text.setText(Integer.toString(result));
//                    text2.setText(text2.getText().toString() + "1");
//                }
//
//                else if (text3.getText().equals("*")) {
//                    number1 = Integer.parseInt(text.getText().toString());
//                    result = number1*1;
//                    text.setText(Integer.toString(result));
//                    text2.setText(text2.getText().toString() + "1");
//                }
//
//                else if (text3.getText().equals("/")) {
//                    number1 = Integer.parseInt(text.getText().toString());
//                    result = number1/1;
//                    text.setText(Integer.toString(result));
//                    text2.setText(text2.getText().toString() + "1");
//                }
//
//                else if (text3.getText().toString().isEmpty()) {
//                    text.setText(text.getText().toString() + "1");
//                    text2.setText(text2.getText().toString() + "1");
//                }
//                break;
//
//            case R.id.button2:
//
//                if (text3.getText().equals("+")) {
//                    number1 = Integer.parseInt(text.getText().toString());
//                    result = number1+2;
//                    text.setText(Integer.toString(result));
//                    text2.setText(text2.getText().toString() + "2");
//                }
//
//                else if (text3.getText().equals("-")) {
//                    number1 = Integer.parseInt(text.getText().toString());
//                    result = number1-2;
//                    text.setText(Integer.toString(result));
//                    text2.setText(text2.getText().toString() + "2");
//                }
//
//                else if (text3.getText().equals("*")) {
//                    number1 = Integer.parseInt(text.getText().toString());
//                    result = number1*2;
//                    text.setText(Integer.toString(result));
//                    text2.setText(text2.getText().toString() + "2");
//                }
//
//                else if (text3.getText().equals("/")) {
//                    number1 = Integer.parseInt(text.getText().toString());
//                    result = number1/2;
//                    text.setText(Integer.toString(result));
//                    text2.setText(text2.getText().toString() + "2");
//                }
//
//                else if (text3.getText().toString().isEmpty()) {
//                    text.setText(text.getText().toString() + "2");
//                    text2.setText(text2.getText().toString() + "2");
//                }
//                break;
//
//            case R.id.button3:
//                if (text3.getText().equals("+")) {
//                    number1 = Integer.parseInt(text.getText().toString());
//                    result = number1+3;
//                    text.setText(Integer.toString(result));
//                    text2.setText(text2.getText().toString() + "3");
//                }
//
//                else if (text3.getText().equals("-")) {
//                    number1 = Integer.parseInt(text.getText().toString());
//                    result = number1-3;
//                    text.setText(Integer.toString(result));
//                    text2.setText(text2.getText().toString() + "3");
//                }
//
//                else if (text3.getText().equals("*")) {
//                    number1 = Integer.parseInt(text.getText().toString());
//                    result = number1*3;
//                    text.setText(Integer.toString(result));
//                    text2.setText(text2.getText().toString() + "3");
//                }
//
//                else if (text3.getText().equals("/")) {
//                    number1 = Integer.parseInt(text.getText().toString());
//                    result = number1/3;
//                    text.setText(Integer.toString(result));
//                    text2.setText(text2.getText().toString() + "3");
//                }
//
//                else if (text3.getText().toString().isEmpty()) {
//                    text.setText(text.getText().toString() + "3");
//                    text2.setText(text2.getText().toString() + "3");
//                }
//                break;
//
//            case R.id.button4:
//                if (text3.getText().equals("+")) {
//                    number1 = Integer.parseInt(text.getText().toString());
//                    result = number1+4;
//                    text.setText(Integer.toString(result));
//                    text2.setText(text2.getText().toString() + "4");
//                }
//
//                else if (text3.getText().equals("-")) {
//                    number1 = Integer.parseInt(text.getText().toString());
//                    result = number1-4;
//                    text.setText(Integer.toString(result));
//                    text2.setText(text2.getText().toString() + "4");
//                }
//
//                else if (text3.getText().equals("*")) {
//                    number1 = Integer.parseInt(text.getText().toString());
//                    result = number1*4;
//                    text.setText(Integer.toString(result));
//                    text2.setText(text2.getText().toString() + "4");
//                }
//
//                else if (text3.getText().equals("/")) {
//                    number1 = Integer.parseInt(text.getText().toString());
//                    result = number1/4;
//                    text.setText(Integer.toString(result));
//                    text2.setText(text2.getText().toString() + "4");
//                }
//
//                else if (text3.getText().toString().isEmpty()) {
//                    text.setText(text.getText().toString() + "4");
//                    text2.setText(text2.getText().toString() + "4");
//                }
//
//                break;
//
//            case R.id.button5:
//                if (text3.getText().equals("+")) {
//                    number1 = Integer.parseInt(text.getText().toString());
//                    result = number1+5;
//                    text.setText(Integer.toString(result));
//                    text2.setText(text2.getText().toString() + "5");
//                }
//
//                else if (text3.getText().equals("-")) {
//                    number1 = Integer.parseInt(text.getText().toString());
//                    result = number1-5;
//                    text.setText(Integer.toString(result));
//                    text2.setText(text2.getText().toString() + "5");
//                }
//
//                else if (text3.getText().equals("*")) {
//                    number1 = Integer.parseInt(text.getText().toString());
//                    result = number1*5;
//                    text.setText(Integer.toString(result));
//                    text2.setText(text2.getText().toString() + "5");
//                }
//
//                else if (text3.getText().equals("/")) {
//                    number1 = Integer.parseInt(text.getText().toString());
//                    result = number1/5;
//                    text.setText(Integer.toString(result));
//                    text2.setText(text2.getText().toString() + "5");
//                }
//
//                else if (text3.getText().toString().isEmpty()) {
//                    text.setText(text.getText().toString() + "5");
//                    text2.setText(text2.getText().toString() + "5");
//                }
//                break;
//
//            case R.id.button6:
//                if (text3.getText().equals("+")) {
//                    number1 = Integer.parseInt(text.getText().toString());
//                    result = number1+6;
//                    text.setText(Integer.toString(result));
//                    text2.setText(text2.getText().toString() + "6");
//                }
//
//                else if (text3.getText().equals("-")) {
//                    number1 = Integer.parseInt(text.getText().toString());
//                    result = number1-6;
//                    text.setText(Integer.toString(result));
//                    text2.setText(text2.getText().toString() + "6");
//                }
//
//                else if (text3.getText().equals("*")) {
//                    number1 = Integer.parseInt(text.getText().toString());
//                    result = number1*6;
//                    text.setText(Integer.toString(result));
//                    text2.setText(text2.getText().toString() + "6");
//                }
//
//                else if (text3.getText().equals("/")) {
//                    number1 = Integer.parseInt(text.getText().toString());
//                    result = number1/6;
//                    text.setText(Integer.toString(result));
//                    text2.setText(text2.getText().toString() + "6");
//                }
//
//                else if (text3.getText().toString().isEmpty()) {
//                    text.setText(text.getText().toString() + "6");
//                    text2.setText(text2.getText().toString() + "6");
//                }
//                break;
//
//            case R.id.button7:
//                if (text3.getText().equals("+")) {
//                    number1 = Integer.parseInt(text.getText().toString());
//                    result = number1+7;
//                    text.setText(Integer.toString(result));
//                    text2.setText(text2.getText().toString() + "7");
//                }
//
//                else if (text3.getText().equals("-")) {
//                    number1 = Integer.parseInt(text.getText().toString());
//                    result = number1-7;
//                    text.setText(Integer.toString(result));
//                    text2.setText(text2.getText().toString() + "7");
//                }
//
//                else if (text3.getText().equals("*")) {
//                    number1 = Integer.parseInt(text.getText().toString());
//                    result = number1*7;
//                    text.setText(Integer.toString(result));
//                    text2.setText(text2.getText().toString() + "7");
//                }
//
//                else if (text3.getText().equals("/")) {
//                    number1 = Integer.parseInt(text.getText().toString());
//                    result = number1/7;
//                    text.setText(Integer.toString(result));
//                    text2.setText(text2.getText().toString() + "7");
//                }
//
//                else if (text3.getText().toString().isEmpty()) {
//                    text.setText(text.getText().toString() + "7");
//                    text2.setText(text2.getText().toString() + "7");
//                }
//                break;
//
//            case R.id.button8:
//                if (text3.getText().equals("+")) {
//                    number1 = Integer.parseInt(text.getText().toString());
//                    result = number1+8;
//                    text.setText(Integer.toString(result));
//                    text2.setText(text2.getText().toString() + "8");
//                }
//
//                else if (text3.getText().equals("-")) {
//                    number1 = Integer.parseInt(text.getText().toString());
//                    result = number1-8;
//                    text.setText(Integer.toString(result));
//                    text2.setText(text2.getText().toString() + "8");
//                }
//
//                else if (text3.getText().equals("*")) {
//                    number1 = Integer.parseInt(text.getText().toString());
//                    result = number1*8;
//                    text.setText(Integer.toString(result));
//                    text2.setText(text2.getText().toString() + "8");
//                }
//
//                else if (text3.getText().equals("/")) {
//                    number1 = Integer.parseInt(text.getText().toString());
//                    result = number1/8;
//                    text.setText(Integer.toString(result));
//                    text2.setText(text2.getText().toString() + "8");
//                }
//
//                else if (text3.getText().toString().isEmpty()) {
//                    text.setText(text.getText().toString() + "8");
//                    text2.setText(text2.getText().toString() + "8");
//                }
//                break;
//
//            case R.id.button9:
//                if (text3.getText().equals("+")) {
//                    number1 = Integer.parseInt(text.getText().toString());
//                    result = number1+9;
//                    text.setText(Integer.toString(result));
//                    text2.setText(text2.getText().toString() + "9");
//                }
//
//                else if (text3.getText().equals("-")) {
//                    number1 = Integer.parseInt(text.getText().toString());
//                    result = number1-9;
//                    text.setText(Integer.toString(result));
//                    text2.setText(text2.getText().toString() + "9");
//                }
//
//                else if (text3.getText().equals("*")) {
//                    number1 = Integer.parseInt(text.getText().toString());
//                    result = number1*9;
//                    text.setText(Integer.toString(result));
//                    text2.setText(text2.getText().toString() + "9");
//                }
//
//                else if (text3.getText().equals("/")) {
//                    number1 = Integer.parseInt(text.getText().toString());
//                    result = number1/9;
//                    text.setText(Integer.toString(result));
//                    text2.setText(text2.getText().toString() + "9");
//                }
//
//                else if (text3.getText().toString().isEmpty()) {
//                    text.setText(text.getText().toString() + "9");
//                    text2.setText(text2.getText().toString() + "9");
//                }
//                break;
//
//            // dot 경우 String 5.0을 Double 5.0 으로 변환해야 하는데 방법을 모르겠습니다.
//            case R.id.buttondot:
//                text.append(".");
//                text2.setText(text2.getText().toString() + ".");
//                break;
//
//            case R.id.buttonplus:
//                text2.append("+");
//                text3.setText("+");
////                text4.append("+");       // 이전 작업 취소를 위해 코딩해둔 것
////
////                number1 = Integer.parseInt(text.getText().toString());
////
////                text.setText(Integer.toString(result));
//
//                break;
//
//            case R.id.buttonminus:
//                text2.append("-");
//                text3.setText("-");
//                break;
//
//            case R.id.buttonmulti:
//                text2.append("*");
//                text3.setText("*");
//                break;
//
//            case R.id.buttondivide:
//                text2.append("/");
//                text3.setText("/");
//                break;
//
//            // text 에서 한 자리를 지우는게 아니라 이전 작업으로 돌아가는 방법
//            case R.id.buttonback:
//                CharSequence back = text.getText();
//                CharSequence back2 = text2.getText();
//                CharSequence back4 = text4.getText();
//
//                if (text.getText().toString().equals(""))
//                    text.setText("");
//                else
//                text.setText(TextUtils.substring(back, 0, back.length()-1));        // 하나씩 빼는 것만 만들었습니다.
////                text.setText(Integer.toString(result-(result-number1)));        // 이전 연산 취소 만들고 싶으나 구현 못했습니다
////                  이 연산을 사용하기 위해서는 배열같이 number1 값을 지속적으로 변경해주는게 필요한데... 모르겠습니다.
//                if (back2.toString().contains("+") || back2.toString().contains("-") || back2.toString().contains("*") || back2.toString().contains("/")) {
//                    text2.setText(TextUtils.substring(back2, 0, back2.toString().length() - 2));
////                    text3.setText(TextUtils.substring(back4, back4.toString().length()-2, back4.toString().length()-1));          // 이전 연산 취소 만드는 도중 실패했습니다
////                    text4.setText(TextUtils.substring(back4, 0, back4.toString().length()-1));
//                }
//                else {
//                    text2.setText(TextUtils.substring(back2, 0, back2.length() - 1));
//                }
//
//                break;
//
//            case R.id.buttonclear:
//                text.setText("");
//                text2.setText("");
//                text3.setText("");
//                number1 = 0;
//                number2 = 0;
//                result = 0;
//                break;
//
//            case R.id.buttonok:
//                text.setText(Integer.toString(result));
//                break;
//
//        }
//
//    }
//}


