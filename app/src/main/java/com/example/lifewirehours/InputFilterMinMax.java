package com.example.lifewirehours;

import android.text.InputFilter;
import android.text.Spanned;

public class InputFilterMinMax implements InputFilter{

    private float min, max;

    // Constructor
    public InputFilterMinMax(int min, int max){
        this.min = min;
        this.max = max;
    }

    // parse string to Int/or float
    public InputFilterMinMax(String min, String max){
        this.min = Integer.parseInt(min);
        this.max = Integer.parseInt(max);
    }


    @Override
    public CharSequence filter(CharSequence charSequence, int i, int i1, Spanned spanned, int i2, int i3) {
        try {
            // Remove the string out of destination that is to be replaced
            String newVal= spanned.toString().substring(0, i2) + charSequence.toString().substring(i, i1) + spanned.toString().substring(i3);
            // Add the new string in
            newVal = newVal.substring(0, i2) + charSequence.toString() + newVal.substring(i2);
            //****Add this line (below) to allow Negative values***//
            if(newVal.equalsIgnoreCase("-") && min < 0)return null;
            int input = Integer.parseInt(newVal);
            if (isInRange(min, max, input))
                return null;
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
        return " ";
    }

    private boolean isInRange(float a, float b, float c) {
        return b > a ? c >= a && c <= b : c >= b && c <= a;
    }
}
