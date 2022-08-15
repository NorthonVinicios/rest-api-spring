package com.northon.api.controllers;

import com.northon.api.exceptions.ResourceNotFoundException;
import com.northon.api.math.SimpleMath;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

import static com.northon.api.math.ConvertTo.convertToDouble;
import static com.northon.api.math.Validation.isNumeric;

@RestController
public class MathController {
    private final AtomicLong counter = new AtomicLong();

    SimpleMath math = new SimpleMath();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("Please set a numerical character");
        }
        return math.sum(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("Please set a numerical character");
        }
        return math.sub(convertToDouble(numberOne),convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/multi/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multi(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("Please set a numerical character");
        }
        return math.multi(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double div(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("Please set a numerical character");
        }
        if (convertToDouble(numberTwo).equals(0D)) {
            throw new ResourceNotFoundException("0 is not supported in divisions");
        }

        return math.div(convertToDouble(numberOne),convertToDouble(numberTwo));
    }
    @RequestMapping(value = "/average/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double average(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("Please set a numerical character");
        }

        return math.average(convertToDouble(numberOne) , convertToDouble(numberTwo));
    }
    @RequestMapping(value = "/square/{numberOne}", method = RequestMethod.GET)
    public Double square(
            @PathVariable(value = "numberOne") String numberOne
    ) throws Exception {
        if (!isNumeric(numberOne)) {
            throw new ResourceNotFoundException("Please set a numerical character");
        }

        return math.square(convertToDouble(numberOne));
    }

}
