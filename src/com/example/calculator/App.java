package com.example.calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("계산기 과제 - 1Lv");

        Scanner sc = new Scanner(System.in);

        while(true) {
            int result = 0;

            // 양의 정수(0)를 입력받기
            System.out.print("첫 번째 값를 입력하세요: ");
            int num1 = sc.nextInt();
            while(num1 < 0){
                System.out.print("0 이상의 값만 입력해주세요.\n첫 번째 값을 입력하세요: ");
                num1 = sc.nextInt();
            }

            System.out.print("두 번째 값를 입력하세요: ");
            int num2 = sc.nextInt();
            while(num2 < 0){
                System.out.print("0 이상의 값만 입력해주세요.\n두 번째 값을 입력하세요: ");
                num2 = sc.nextInt();
            }

            // 사칙연산 기호 입력받기
            System.out.print("사칙연산 기호를 입력하세요(+, -, *, /): ");
            char operator = sc.next().charAt(0);

            while((operator != '+') && (operator != '-') && (operator != '*') && (operator != '/')){
                System.out.println("사칙연산 기호가 아닙니다.\n다시 입력해주세요: ");
                operator = sc.next().charAt(0);
            }

            // num1, num2와 operator로 연산 진행
            switch(operator){
                case '+': result = num1 + num2;
                    break;
                case '-': result = num1 - num2;
                    break;
                case '*': result = num1 * num2;
                    break;
                case '/':
                    try { // 0으로 나누면 ArithmeticException발생 예외처리
                        result = num1 / num2;
                    } catch (ArithmeticException e) {
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    }
                    break;
            }

            System.out.println("결과: " + num1 + " " + operator + " " + num2 + " = " + result);

            System.out.println("더 계산하시겠습니까? 계속 하시려면 아무거나 입력해주세요. (exit 입력 시 종료)");
            String exit = sc.next();
            if(exit.equals("exit")){
                break;
            }
        }
    }
}
