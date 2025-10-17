package com.example.challengeCalculator;

import com.example.calculator.Calculator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("계산기 과제 - 도전!!");

        // ArithmeticCalculator 인스턴스 생성
        ArithmeticCalculator<Double> calc = new ArithmeticCalculator<>();

        // 스캐너 객체 생성
        Scanner sc = new Scanner(System.in);

        while (true) { // exit 입력받기 전까지 무한 반복
            System.out.println("============================================================================");
            // 양의 정수(0)를 입력받기
            System.out.print("첫 번째 값를 입력하세요: ");
            Double num1 = sc.nextDouble(); // 받은 값을 num1에 담기
            while (num1 < 0) { // 음의 값이 들어오면 다시 입력받기
                System.out.print("0 이상의 값만 입력해주세요.\n첫 번째 값을 입력하세요: ");
                num1 = sc.nextDouble(); // 받은 값을 num1에 담기
            }

            System.out.print("두 번째 값를 입력하세요: ");
            Double num2 = sc.nextDouble(); // 받은 값을 num2에 담기
            while (num2 < 0) { // 음의 값이 들어오면 다시 입력받기
                System.out.print("0 이상의 값만 입력해주세요.\n두 번째 값을 입력하세요: ");
                num2 = sc.nextDouble(); // 받은 값을 num2에 담기
            }

            // 사칙연산 기호 입력받기
            System.out.print("사칙연산 기호를 입력하세요(+, -, *, /): ");
            char operator = sc.next().charAt(0); // .charAt(0): 0번째 인덱스 => +- 으로 입력할 경우 첫번째 인덱스인 +를 사용

            while ((operator != '+') && (operator != '-') && (operator != '*') && (operator != '/')) { // 사칙연산이 아닌 값이 들어오면 반복
                System.out.println("사칙연산 기호가 아닙니다.\n다시 입력해주세요: ");
                operator = sc.next().charAt(0);
            }

            calc.calculate(num1, num2, operator); // ArithmeticCalculator 클래스에서 calculate 메서드 호출
            ArrayList<Double> result = calc.getResult(); // 반환된 값을 result에 담기
            calc.setResult(result); // 결과 셋팅

            System.out.println("============================================================================");
            // ArrayList의 마지막 값을 가져와서 출력하는 코드 => result.get(result.size() - 1)
            System.out.println("결과: " + num1 + " " + operator + " " + num2 + " = " + result.get(result.size() - 1));

            System.out.println("더 계산하시겠습니까? 계속 하시려면 아무거나 입력해주세요. (exit 입력 시 종료)");
            String exit = sc.next();

            if (exit.equals("exit")) { // exit를 입력받으면 while문 탈출
                break;
            }
        }

        System.out.println("============================================================================");
        System.out.println("하나의 값을 입력해주세요. 연산된 결과들 중 그보다 큰 값이 조회됩니다.");
        System.out.print("값를 입력하세요: ");
        Double findNum = sc.nextDouble();

        ArrayList<Double> findResult = calc.findAllResult(findNum); // findAllResult를 호출 후 받아온 값 저장
        System.out.println(findNum + "보다 큰 결과: " + findResult);
    }
}