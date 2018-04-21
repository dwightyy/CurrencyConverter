package com.example.jp.currencyconverter;

public class Conversions {






    public static double convertDolar(double toBarState, double amount){
        double dollarToEuro = 0.81;
        double dolarToReal = 3.42;

        double euro = 1;
        double real = 2;

        if(toBarState == euro){
            return amount * dollarToEuro;
        }
        else if(toBarState == real){
            return amount * dolarToReal;
        }

        return 0;

    }

    public static double convertEuro(double toBarState, double amount){
        double euroToDollar = 1.23;
        double euroToReal = 4.21;

        double dolar = 0;
        double real = 2;

        if(toBarState == dolar){
            return amount * euroToDollar;
        }
        if(toBarState == real){
            return amount * euroToReal;
        }

        return 0;
    }

    public static double convertReal(double toBarState, double amount){
        double realToDollar = 0.29;
        double realToEuro = 0.24;

        double dollar = 0;
        double euro = 1;

        if(toBarState == dollar){
            return amount * realToDollar;
        }
        if(toBarState == euro){
            return amount * realToEuro;
        }

        return 0;
    }
}
