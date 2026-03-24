package com.example.mockexamcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvDisplay;
    private TextView tvHistory;
    private double operandA = 0;
    private String currentOperator = "";
    private boolean isNewInput = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.tvDisplay);
        tvHistory = findViewById(R.id.tvHistory);
    }

    public void onNumberClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();

        if (isNewInput) {
            tvDisplay.setText(buttonText);
            isNewInput = false;
        } else {
            if (buttonText.equals(".") && tvDisplay.getText().toString().contains(".")) {
                return;
            }
            tvDisplay.append(buttonText);
        }
    }

    public void onOperatorClick(View view) {
        Button button = (Button) view;
        currentOperator = button.getText().toString();

        operandA = Double.parseDouble(tvDisplay.getText().toString());
        isNewInput = true;
    }

    public void onEqualsClick(View view) {
        double operandB = Double.parseDouble(tvDisplay.getText().toString());
        double result = 0;

        switch (currentOperator) {
            case "+": result = operandA + operandB; break;
            case "−": result = operandA - operandB; break;
            case "×": result = operandA * operandB; break;
            case "÷":
                if (operandB == 0) {
                    tvDisplay.setText("Error");
                    isNewInput = true;
                    return;
                }
                result = operandA / operandB;
                break;
        }

        tvDisplay.setText(String.valueOf(result));
        isNewInput = true;

        String fullEquation = operandA + " " + currentOperator + " " + operandB + " = " + result + "\n";
        tvHistory.append(fullEquation);
    }

    public void onCustomOperatorClick(View view) {
        double currentVal = Double.parseDouble(tvDisplay.getText().toString());
        double result = currentVal * 2.22;
        tvDisplay.setText(String.valueOf(result));

        isNewInput = true;

        String fullEquation = currentVal + " × 2.22 = " + result + "\n";
        tvHistory.append(fullEquation);
    }

    public void onBackspaceClick(View view) {
        String currentText = tvDisplay.getText().toString();

        if (currentText.length() > 1) {
            tvDisplay.setText(currentText.substring(0, currentText.length() - 1));
        } else {
            tvDisplay.setText("0");
            isNewInput = true;
        }
    }

    public void onNegateClick(View view) {
        double currentVal = Double.parseDouble(tvDisplay.getText().toString());
        double result = currentVal * -1;
        tvDisplay.setText(String.valueOf(result));
    }

    public void onClearClick(View view) {
        tvDisplay.setText("0");
        operandA = 0;
        currentOperator = "";
        isNewInput = true;
        tvHistory.setText("");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("DISPLAY_TEXT", tvDisplay.getText().toString());
        outState.putDouble("OPERAND_A", operandA);
        outState.putString("OPERATOR", currentOperator);
        outState.putBoolean("NEW_INPUT", isNewInput);
        outState.putString("HISTORY_TEXT", tvHistory.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        tvDisplay.setText(savedInstanceState.getString("DISPLAY_TEXT"));
        operandA = savedInstanceState.getDouble("OPERAND_A");
        currentOperator = savedInstanceState.getString("OPERATOR");
        isNewInput = savedInstanceState.getBoolean("NEW_INPUT");
        tvHistory.setText(savedInstanceState.getString("HISTORY_TEXT"));
    }
}