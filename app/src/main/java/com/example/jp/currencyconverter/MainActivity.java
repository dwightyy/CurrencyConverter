package com.example.jp.currencyconverter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.honorato.multistatetogglebutton.MultiStateToggleButton;
import org.honorato.multistatetogglebutton.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private EditText amount_field;
    private EditText converted_field;
    private Button goButton;

    MultiStateToggleButton fromBar;
    MultiStateToggleButton toBar;

    int toCheck;
    int fromCheck;

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
                if(state[0] == state[1]){
                    Context context = getApplicationContext();
                    //TODO make so the user cant select the same currency in the first place.
                    //TODO make the toBar have only two values depending on the fromValue selected using the setElements.
                    Toast sameCurrency = Toast.makeText(context,"The currency can't be the same",Toast.LENGTH_SHORT );
                    sameCurrency.show();

                }
                double amount = Double.parseDouble(amount_field.getText().toString().trim());
                double result = Bars.doConversion(state, amount);
                if(result != 0){
                    converted_field.setText(String.valueOf(result));
                }
                if(result == 0){
                    converted_field.setText(" ");
                }


            }
        });
    }



}
