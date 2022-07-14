package com.northon.api.restapispring;

import com.northon.api.exceptions.UnsupporterdMathOperationException;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupporterdMathOperationException("Please set a numerical character");
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/minus/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double minus(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupporterdMathOperationException("Please set a numerical character");
        }
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/multi/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multi(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupporterdMathOperationException("Please set a numerical character");
        }
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double div(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupporterdMathOperationException("Please set a numerical character");
        }
        if (convertToDouble(numberTwo).equals(0D)) {
            throw new UnsupporterdMathOperationException("0 is not supported in divisions");
        }

        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    private Double convertToDouble(String strNumber) throws Exception {
        if (strNumber == null) {
            throw new UnsupporterdMathOperationException("Please set a numerical character");
        }
        String number = strNumber.replaceAll(",", ".");

        if (isNumeric(number)) return Double.parseDouble(number);
        return 1D;
    }

    private boolean isNumeric(String strNumber) throws Exception {
        System.out.println(strNumber);
        if (strNumber == null) {
            throw new UnsupporterdMathOperationException("Please set a numerical character");
        }
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");

    }

}
