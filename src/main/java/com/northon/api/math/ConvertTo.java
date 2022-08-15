package com.northon.api.math;

import com.northon.api.exceptions.ResourceNotFoundException;

import static com.northon.api.math.Validation.isNumeric;

public class ConvertTo {
    public static Double convertToDouble(String strNumber) throws Exception {
        if (strNumber == null) {
            throw new ResourceNotFoundException("Please set a numerical character");
        }
        String number = strNumber.replaceAll(",", ".");

        if (isNumeric(number)) return Double.parseDouble(number);
        return 1D;
    }

}
