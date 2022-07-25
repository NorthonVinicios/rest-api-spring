package com.northon.api.math;


public class SimpleMath {
    public Double sum(Double numberOne, Double numberTwo) {
        return numberOne + numberTwo;
    }
    public Double sub(Double numberOne, Double numberTwo) {
        return numberOne - numberTwo;
    }
    public Double multi(Double numberOne, Double numberTwo) {
        return numberOne * numberTwo;
    }
    public Double div(Double numberOne, Double numberTwo) {
        return numberOne / numberTwo;
    }
    public Double average(Double numberOne, Double numberTwo) {
        return (numberOne + numberTwo)/2;
    }
    public Double square(Double numberOne) {
        return Math.sqrt(numberOne);
    }
}
