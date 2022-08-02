package com.example.anothertest;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView result;
    String oldNumber;
    String operator;
    Boolean isDot = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.calcResult);
    }

    public void numberIvent(View view) {
        String number = result.getText().toString();
        if(view.getId()==R.id.calcOne){
            number = number + "1";
        }
        else if(view.getId()==R.id.calcTwo){
            number = number + "2";
        }
        else if(view.getId()==R.id.calcThree){
            number = number + "3";
        }
        else if(view.getId()==R.id.calcFour){
            number = number + "4";
        }
        else if(view.getId()==R.id.calcFive){
            number = number + "5";
        }
        else if(view.getId()==R.id.calcSix){
            number = number + "6";
        }
        else if(view.getId()==R.id.calcSeven){
            number = number + "7";
        }
        else if(view.getId()==R.id.calcEight){
            number = number + "8";
        }
        else if(view.getId()==R.id.calcNine){
            number = number + "9";
        }
        else if(view.getId()==R.id.calcZero){
            number = number + "0";
        }
        else if(view.getId()==R.id.calcDot){
            if(!isDot){
                number = number + ".";
                isDot = true;
            }
        }
        else if(view.getId()==R.id.calcPlusMinus){
            if(Double.parseDouble(number)>=0){
                number = "-" + number;
            }
            else{
                number = number.substring(1);
            }
        }

        result.setText(number);
    }

    public void operatorIvent(View view) {
        oldNumber = result.getText().toString();
        isDot = false;
        if(view.getId()==R.id.calcMinus){
            operator = "-";
        }
        else if(view.getId()==R.id.calcPlus){
            operator = "+";
        }
        else if(view.getId()==R.id.calcMultiply){
            operator = "*";
        }
        else if(view.getId()==R.id.calcDivide){
            operator = "/";
        }
        else if(view.getId()==R.id.calcPercent){
            operator = "%";
        }
        result.setText("");
    }

    public void equals(View view) {
        String newNumber = result.getText().toString();
        double res = 0;
        isDot = true;
        if(operator=="+"){
            res = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
        }
        else if(operator=="-"){
            res = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
        }
        else if(operator=="/"){
            res = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
        }
        else if(operator=="*"){
            res = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
        }
        else if(operator=="%"){
            res = (Double.parseDouble(oldNumber) / 100) * Double.parseDouble(newNumber);
        }
        result.setText(res + "");
    }
}