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
        double euroXreal = 4.20;
        double dolarXreal = 3.41;
        //TODO change "state[n]" to variable to have better
        //TODO refactor so dont have as many ifs.
        if(state[0] == 2){
            if (state[1] == 0){
                return amount * dolarXreal ;
            }
            else if(state[1] == 1){
                return amount * euroXreal;
            }
            else if(state[1] == 2){
                return 0;
            }
        }
        return 0;
    }

}
