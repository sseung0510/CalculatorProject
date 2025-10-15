package com.example.challengeCalculator;

public enum OperatorType {
    SUM {
        public int apply(int num1, int num2) {return num1 + num2;}
    },
    SUB{
        public int apply(int num1, int num2) {return num1 - num2;}
    },
    MUL {
        public int apply(int num1, int num2) {return num1 * num2;}
    },
    DIV{
        public int apply(int num1, int num2) {return num1 / num2;}
    };

    public abstract int apply(int num1, int num2);
}
