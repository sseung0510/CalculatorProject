package com.example.challengeCalculator;

public enum OperatorType {
    SUM { // 덧셈 연산
        public double apply(double num1, double num2) { return num1 + num2; }
    },
    SUB { // 뺄셈 연산
        public double apply(double num1, double num2) { return num1 - num2; }
    },
    MUL { // 곱셈 연산
        public double apply(double num1, double num2) { return num1 * num2; }
    },
    DIV { // 나눗셈 연산
        public double apply(double num1, double num2) { return num1 / num2; }
    };

    public abstract double apply(double num1, double num2);
}
