package com.example.logbook1_caculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    TextView inputText, outputText;
    private  String  input, output, newOutput;
    private Button buttonDivide,buttonMultiply,buttonPlus,buttonMinus,buttonEquals;
    private Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9;
    private Button buttonC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outputText = findViewById(R.id.output_tv);
        inputText = findViewById(R.id.input_tv);

        button0 = findViewById(R.id.button_0);
        button1 = findViewById(R.id.button_1);
        button2 = findViewById(R.id.button_2);
        button3 = findViewById(R.id.button_3);
        button4 = findViewById(R.id.button_4);
        button5 = findViewById(R.id.button_5);
        button6 = findViewById(R.id.button_6);
        button7 = findViewById(R.id.button_7);
        button8 = findViewById(R.id.button_8);
        button9 = findViewById(R.id.button_9);
        buttonC = findViewById(R.id.button_c);
        buttonDivide = findViewById(R.id.button_divide);
        buttonMinus = findViewById(R.id.button_minus);
        buttonPlus = findViewById(R.id.button_plus);
        buttonMultiply = findViewById(R.id.button_multiply);
        buttonEquals = findViewById(R.id.button_equals);
    }

    public void onButtonClicked(View view){
        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data){
            case "C":
                input = null;
                output = null;
                newOutput = null;
                outputText.setText("0");
                break;
            case "=":
                solve();
                break;
            default:
                if(input == null){
                    input = "";
                }
                if(data.equals("+") || data.equals("/") || data.equals("-") || data.equals("*")){
                    solve();
                }
                input += data;
        }
        inputText.setText(input);
    }

    private void solve(){
        if(input.split("\\+").length==2){
            String numbers [] = input.split("\\+");
            try{
                double d = Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
                input = d +"";
            }catch (Exception e){
                outputText.setError(e.getMessage().toString());
            }
        }

        if(input.split("\\*").length==2){
            String numbers [] = input.split("\\*");
            try{
                double d = Double.parseDouble(numbers[0]) * Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
                input = d +"";
            }catch (Exception e){
                outputText.setError(e.getMessage().toString());
            }
        }

        if(input.split("\\/").length==2){
            String numbers [] = input.split("\\/");
            try{
                double d = Double.parseDouble(numbers[0]) / Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
                input = d +"";
            }catch (Exception e){
                outputText.setError(e.getMessage().toString());
            }
        }

        if(input.split("\\-").length==2){
            String numbers [] = input.split("\\-");
            try{
                if (Double.parseDouble(numbers[0]) < Double.parseDouble(numbers[1])){
                    double d = Double.parseDouble(numbers[1]) - Double.parseDouble(numbers[0]);
                    output = Double.toString(d);
                    newOutput = cutDecimal(output);
                    outputText.setText("-" + newOutput);
                    input = "-" + d +"";
                } else {
                    double d = Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
                    output = Double.toString(d);
                    newOutput = cutDecimal(output);
                    outputText.setText(newOutput);
                    input = d +"";
                }
            }catch (Exception e){
                outputText.setError(e.getMessage().toString());
            }
        }
    }

    private String cutDecimal(String number){
        String n [] = number.split("\\.");
        if(n.length > 1){
            if(n[1].equals("0")){
                number = n[0];
            }
        }
        return number;
    }

//    @Override
//    public void onClick(View view) {
//        MaterialButton button =(MaterialButton) view;
//        String buttonText = button.getText().toString();
//        String dataToCalculate = solution.getText().toString();
//        double firstNum = Double.parseDouble(solution.getText().toString());
//        double secondNum = Double.parseDouble(solution.getText().toString());
//        double resultFinal;
//
//        if(buttonText.equals("=")){
//            solution.setText(result.getText());
//        } else if(buttonText.equals("C")){
//            dataToCalculate = dataToCalculate.substring(0,dataToCalculate.length()-1);
//        }else if (buttonText.equals("/")){
//            resultFinal = firstNum / secondNum;
//        }else if (buttonText.equals("*")) {
//            resultFinal = firstNum * secondNum;
//        }else if (buttonText.equals("-")) {
//            resultFinal = firstNum - secondNum;
//        }else if (buttonText.equals("+")) {
//            resultFinal = firstNum + secondNum;
//        }
//        solution.setText(String.valueOf(resultFinal));
//        firstNum = resultFinal;
//    }
}