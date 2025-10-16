package com.example.challengeCalculator;

public enum OperatorType {
    SUM {
        public double apply(double num1, double num2) {return num1 + num2;}
    },
    SUB{
        public double apply(double num1, double num2) {return num1 - num2;}
    },
    MUL {
        public double apply(double num1, double num2) {return num1 * num2;}
    },
    DIV{
        public double apply(double num1, double num2) {return num1 / num2;}
    };
    public abstract double apply(double num1, double num2);
}
