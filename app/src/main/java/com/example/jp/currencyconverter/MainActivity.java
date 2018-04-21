package com.example.jp.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.Currency;
import java.util.Set;

import org.honorato.multistatetogglebutton.MultiStateToggleButton;

public class MainActivity extends AppCompatActivity {

    private EditText amount_field;
    private EditText converted_field;
    private Button goButton;

    MultiStateToggleButton fromBar;
    MultiStateToggleButton toBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        amount_field = findViewById(R.id.field_1);
        converted_field = findViewById(R.id.field_2);
        goButton = findViewById(R.id.goButton);
        fromBar = findViewById(R.id.fromBar);
        toBar = findViewById(R.id.toBar);

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                short[] state = Bars.getState(fromBar, toBar);
                double amount = Double.parseDouble(amount_field.getText().toString().trim());
                double result = Bars.doConversion(state, amount);
                converted_field.setText(String.valueOf(result));

            }
        });
    }



}
