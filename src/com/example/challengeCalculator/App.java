package com.example.challengeCalculator;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("계산기 과제 - 도전!!");

        // Calcultor 인스턴스 생성
        ArithmeticCalculator calc = new ArithmeticCalculator();

        Scanner sc = new Scanner(System.in);

        while (true) {
            // 양의 정수(0)를 입력받기
            System.out.print("첫 번째 값를 입력하세요: ");
            int num1 = sc.nextInt();
            while (num1 < 0) {
                System.out.print("0 이상의 값만 입력해주세요.\n첫 번째 값을 입력하세요: ");
                num1 = sc.nextInt();
            }

            System.out.print("두 번째 값를 입력하세요: ");
            int num2 = sc.nextInt();
            while (num2 < 0) {
                System.out.print("0 이상의 값만 입력해주세요.\n두 번째 값을 입력하세요: ");
                num2 = sc.nextInt();
            }

            // 사칙연산 기호 입력받기
            System.out.print("사칙연산 기호를 입력하세요(+, -, *, /): ");
            char operator = sc.next().charAt(0);

            while ((operator != '+') && (operator != '-') && (operator != '*') && (operator != '/')) {
                System.out.println("사칙연산 기호가 아닙니다.\n다시 입력해주세요: ");
                operator = sc.next().charAt(0);
            }

            calc.calculate(num1, num2, operator);
            ArrayList<Integer> result = calc.getResult();
            calc.setResult(result);

            System.out.println("결과: " + num1 + " " + operator + " " + num2 + " = " + result);

            System.out.println("더 계산하시겠습니까? 계속 하시려면 아무거나 입력해주세요. (exit 입력 시 종료)");

            calc.removeResult();

            String exit = sc.next();
            if (exit.equals("exit")) {
                break;
            }
        }
    }
}

