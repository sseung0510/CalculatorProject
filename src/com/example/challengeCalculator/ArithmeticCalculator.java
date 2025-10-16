package com.example.challengeCalculator;

import java.util.ArrayList;

public class ArithmeticCalculator {
    // 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성
    private ArrayList<Integer> result = new ArrayList<>();

    OperatorType sum = OperatorType.SUM;
    OperatorType sub = OperatorType.SUB;
    OperatorType mul = OperatorType.MUL;
    OperatorType div = OperatorType.DIV;

    // 기능
    public ArrayList<Integer> calculate(int num1, int num2, char operator) {
        int calcResult = 0;

        // num1, num2와 operator로 연산 진행
        switch(operator){
            case '+': calcResult = sum.apply(num1, num2);
                break;
            case '-': calcResult = sub.apply(num1, num2);
                break;
            case '*': calcResult = mul.apply(num1, num2);
                break;
            case '/':
                try { // 0으로 나누면 ArithmeticException발생 예외처리
                    calcResult = div.apply(num1, num2);
                } catch (ArithmeticException e) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                }
                break;
        }

        result.add(calcResult);
        return result;
    }

    // Getter 메서드 구현
    public ArrayList<Integer> getResult() {
        return result;
    }

    // Setter 메서드 구현
    public void setResult(ArrayList<Integer> result) {
        this.result = result;
    }

    /**
     * 저장된 데이터를 삭제하는 기능
     */
    public void removeResult() {
        result.remove(0); // result에 담겨있던 값 제거
    }

}
