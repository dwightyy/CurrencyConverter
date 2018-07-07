package com.example.jp.currencyconverter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import org.honorato.multistatetogglebutton.MultiStateToggleButton;
import org.honorato.multistatetogglebutton.ToggleButton;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText amount_field;
    private EditText converted_field;


    MultiStateToggleButton fromBar;
    MultiStateToggleButton toBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        amount_field = findViewById(R.id.field_1);
        converted_field = findViewById(R.id.field_2);
/*        goButton = findViewById(R.id.goButton);*/
        fromBar = findViewById(R.id.fromBar);
        toBar = findViewById(R.id.toBar);
                    //TODO make so the user cant select the same currency in the first place.
                    //TODO make the toBar have only two values depending on the fromValue selected using the setElements.


        amount_field.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                final short[] state = Bars.getState(fromBar, toBar);
                if(state[0] == state[1]){
                    Context context = getApplicationContext();
                    //TODO make so the user cant select the same currency in the first place.
                    //TODO make the toBar have only two values depending on the fromValue selected using the setElements.
                    //TODO make everhing with methods so duplicated code doesn't occur. \
                    //TODO make listener for toBar so converted amount refreshes as the currency is changed.
                    Toast sameCurrency = Toast.makeText(context,"The currency can't be the same",Toast.LENGTH_SHORT );
                    sameCurrency.show();
                    }
                fromBar.setOnValueChangedListener(new ToggleButton.OnValueChangedListener(){
                    @Override
                    public void onValueChanged(int value) {
                        short[] state = Bars.getState(fromBar, toBar);
                        double toBarState = state[1];
                        String result = "";
                        double amount = Double.parseDouble(0 +amount_field.getText().toString().trim());
                        double converted = Bars.doConversion(state, amount);

                        if (toBarState == 0){
                            result = formatUSD(converted);


                        }else if(toBarState == 1){
                            result = formatEUR(converted);

                        }else if(toBarState == 2){
                            result = formatBRL(converted);
                        }
                        setText(result);



                    }


                });

                String result = " ";

                double amount = Double.parseDouble(0 +amount_field.getText().toString().trim());
                double converted = Bars.doConversion(state, amount);

                double toBarState = state[1];

                if (toBarState == 0){
                    result = formatUSD(converted);


                }else if(toBarState == 1){
                    result = formatEUR(converted);

                }else if(toBarState == 2){
                    result = formatBRL(converted);
                }
                setText(result);

            }
            @Override
            public void afterTextChanged(Editable s) {

            }



            private void setText(String result){
                if(result != null){
                    converted_field.setText(String.valueOf(" "+result));
                }
                if(result == null){
                    converted_field.setText(" ");
                }
            }

            private String formatUSD(double converted){
                NumberFormat FORMAT_USD = NumberFormat.getCurrencyInstance(Locale.getDefault());
                FORMAT_USD.setCurrency(Currency.getInstance("USD"));

                return FORMAT_USD.format(converted);

            }
            private String formatEUR(double converted){
                NumberFormat FORMAT_EUR = NumberFormat.getCurrencyInstance(Locale.getDefault());
                FORMAT_EUR.setCurrency(Currency.getInstance("EUR"));
                return FORMAT_EUR.format(converted);
            }
            private String formatBRL(double converted){
                NumberFormat FORMAT_BRL = NumberFormat.getCurrencyInstance(Locale.getDefault());
                FORMAT_BRL.setCurrency(Currency.getInstance("BRL"));
                return FORMAT_BRL.format(converted);
            }


        });





        }

    }


