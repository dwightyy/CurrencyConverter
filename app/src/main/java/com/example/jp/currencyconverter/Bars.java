package com.example.jp.currencyconverter;

import android.util.Log;

import org.honorato.multistatetogglebutton.MultiStateToggleButton;
import org.honorato.multistatetogglebutton.ToggleButton;

public class Bars {

    protected static short[] getState(MultiStateToggleButton fromBar, MultiStateToggleButton toBar){
        boolean[] fromStates = fromBar.getStates();
        boolean[] toStates = toBar.getStates();
        short currentFrom = 0;
        short currentTo = 0;

        for(short i = 0; i < fromStates.length; i++){
            if(fromStates[i] == true){
                currentFrom = i;
            }
        }
        for(short i = 0; i < toStates.length; i++){
            if(toStates[i] == true){
                currentTo = i;
            }
        }

        short[] state = new short[]{currentFrom, currentTo};

        return state;

    }

    protected static double doConversion(short[] state, double amount){
        //TODO change "state[n]" to variable to have better
        //TODO refactor so dont have as many ifs.
        //TODO handle from when go is pressed without "to" value selected
        //CHECK IF TO IS EQUAL FROM ONLY ONE TIME
        double fromBarState = state[0];
        double toBarState = state[1];


        if(toBarState == fromBarState){
            return 0;
        }

        if (fromBarState == 0){
            return Conversions.convertDolar(toBarState, amount);
        }
        else if(fromBarState == 1) {
            return Conversions.convertEuro(toBarState, amount);
        }
        else if(fromBarState == 2){
            return Conversions.convertReal(toBarState, amount);
        }

        return 0;
    }

}
