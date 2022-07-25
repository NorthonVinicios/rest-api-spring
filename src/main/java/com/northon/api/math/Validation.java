package com.northon.api.math;

import com.northon.api.exceptions.UnsupporterdMathOperationException;

public class Validation {
    public static boolean isNumeric(String strNumber) throws Exception {
        System.out.println(strNumber);
        if (strNumber == null) {
            throw new UnsupporterdMathOperationException("Please set a numerical character");
        }
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");

    }
}
