package com.example.caculator;


import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.app.calculator.R;

 
import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.Expression;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button zeroBtn, oneBtn, twoBtn, threeBtn, fourBtn, fiveBtn, sixBtn, sevenBtn, eightBtn, nineBtn;
    Button equalsBtn, dotBtn, clearBtn, backspaceBtn, addBtn, subBtn, multiplyBtn, oppositeBtn, divideBtn, percentageBtn;
    private TextView resultTxtView;
    private TextView expTxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTxtView = findViewById(R.id.out);
        expTxtView = findViewById(R.id.exp);

        zeroBtn = findViewById(R.id.zero);
        oneBtn = findViewById(R.id.one);
        twoBtn = findViewById(R.id.two);
        threeBtn = findViewById(R.id.three);
        fourBtn = findViewById(R.id.four);
        fiveBtn = findViewById(R.id.five);
        sixBtn = findViewById(R.id.six);
        sevenBtn = findViewById(R.id.seven);
        eightBtn = findViewById(R.id.eight);
        nineBtn = findViewById(R.id.nine);

        equalsBtn = findViewById(R.id.equals);
        dotBtn = findViewById(R.id.dot);
        clearBtn = findViewById(R.id.clear);
        backspaceBtn = findViewById(R.id.backspace);
        addBtn = findViewById(R.id.plus);
        subBtn = findViewById(R.id.minus);
        multiplyBtn = findViewById(R.id.multiply);
        oppositeBtn = findViewById(R.id.opposite);
        divideBtn = findViewById(R.id.divide);
        percentageBtn = findViewById(R.id.percentage);

        zeroBtn.setOnClickListener(this);
        oneBtn.setOnClickListener(this);
        twoBtn.setOnClickListener(this);
        threeBtn.setOnClickListener(this);
        fourBtn.setOnClickListener(this);
        fiveBtn.setOnClickListener(this);
        sixBtn.setOnClickListener(this);
        sevenBtn.setOnClickListener(this);
        eightBtn.setOnClickListener(this);
        nineBtn.setOnClickListener(this);

        equalsBtn.setOnClickListener(this);
        dotBtn.setOnClickListener(this);
        clearBtn.setOnClickListener(this);
        backspaceBtn.setOnClickListener(this);
        addBtn.setOnClickListener(this);
        subBtn.setOnClickListener(this);
        multiplyBtn.setOnClickListener(this);
        oppositeBtn.setOnClickListener(this);
        divideBtn.setOnClickListener(this);
        percentageBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        String exp = expTxtView.getText().toString();
        String out = resultTxtView.getText().toString();

        if (R.id.equals == id) {
            calculate();
        } else if (R.id.zero == id) {
            generateExpression("0");
        } else if (R.id.one == id) {
            generateExpression("1");
        } else if (R.id.two == id) {
            generateExpression("2");
        } else if (R.id.three == id) {
            generateExpression("3");
        } else if (R.id.four == id) {
            generateExpression("4");
        } else if (R.id.five == id) {
            generateExpression("5");
        } else if (R.id.six == id) {
            generateExpression("6");
        } else if (R.id.seven == id) {
            generateExpression("7");
        } else if (R.id.eight == id) {
            generateExpression("8");
        } else if (R.id.nine == id) {
            generateExpression("9");
        } else if (R.id.plus == id) {
            generateExpression("+");
        } else if (R.id.minus == id) {
            generateExpression("-");
        } else if (R.id.multiply == id) {
            generateExpression("*");
        } else if (R.id.opposite == id) {

            if ((!out.equals(""))&&(!out.equals("0.0"))){
                float i = (Float.parseFloat(out))*(-1);
                String result = String.valueOf(i);
                resultTxtView.setText(result);
                expTxtView.setText(result);

            }
        } else if (R.id.divide == id) {
            generateExpression("/");
        } else if (R.id.clear == id) {
            expTxtView.setText("");
            resultTxtView.setText("");
        } else if (R.id.backspace == id) {
            int expLength = exp.length();
            if (!(expLength < 1)) {
                if (expLength == 1) {
                    expTxtView.setText("");
                } else {
                    expTxtView.setText(exp.substring(0, expLength - 1));
                }
            }
        } else if (R.id.percentage == id) {
            if (exp.equals("") || isSpecialChar("" + exp.charAt(exp.length() - 1))) {
                return;
            }
            Expression expression = new Expression(exp + "/100");
            String result = String.valueOf(expression.calculate());
            expTxtView.setText(result);
            resultTxtView.setText(result);
        } else if (R.id.dot == id) {
            if (!Double.isNaN(new Expression(exp + ".0").calculate())) generateExpression(".");
        }

    }



    private void calculate() {
        String exp = expTxtView.getText().toString();
        String result;
        if (exp.equals("") || exp.equals(".") || isSpecialChar("" + exp.charAt(exp.length() - 1))) {
            return;
        }
        Expression expression = new Expression(exp);
        result = String.valueOf(expression.calculate());
        resultTxtView.setText(result);
    }

    public void generateExpression(String val) {
        String exp = expTxtView.getText().toString();
        if (isSpecialChar(val)) {
            if (exp.equals("") || isSpecialChar("" + exp.charAt(exp.length() - 1))) {
                return;
            }
        }
        expTxtView.setText(String.format("%s%s", expTxtView.getText().toString(), val));
    }

    public boolean isSpecialChar(String str) {
        return Pattern.compile("[$&+,:;=\\\\?@#|/'<>.^*()%!-]").matcher(str).find();
    }
}