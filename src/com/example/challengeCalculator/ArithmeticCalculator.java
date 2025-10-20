package com.example.challengeCalculator;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> { // 제네릭 사용, 숫자형 클래스만 허용

    // 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성
    private ArrayList<Double> result = new ArrayList<>();

    // enum에 있는 사친연산 불러오기
    OperatorType sum = OperatorType.SUM; // 덧셈
    OperatorType sub = OperatorType.SUB; // 뺄셈
    OperatorType mul = OperatorType.MUL; // 곱셈
    OperatorType div = OperatorType.DIV; // 나눗셈

    /**
     * 계산 기능 메서드
     */
    public ArrayList<Double> calculate(T num1, T num2, char operator) {
        double a = num1.doubleValue();
        double b = num2.doubleValue();
        double calcResult = 0; // 연산 결과 담는 변수

        // num1, num2와 operator로 연산 진행
        switch(operator){
            case '+':
                calcResult = sum.apply(a, b);
                break;
            case '-':
                calcResult = sub.apply(a, b);
                break;
            case '*':
                calcResult = mul.apply(a, b);
                break;
            case '/':
                try { // 0으로 나누면 ArithmeticException발생 예외처리
                    calcResult = div.apply(a, b);
                } catch (ArithmeticException e) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                }
                break;
        }
        result.add(calcResult); // result 컬렉션에 calcResult값 추가
        return result; // 결과 반환
    }

    // Getter 메서드 구현
    public ArrayList<Double> getResult() {
        return result;
    }

    // Setter 메서드 구현
    public void setResult(ArrayList<Double> result) {
        this.result = result;
    }

    /**
     * 저장된 데이터를 삭제하는 기능
     */
    public void removeResult() {
        result.remove(0); // result에 담겨있던 값 제거
    }

    /**
     * 저장된 연산 결과들 중 입력받은 값보다 큰 결과값 출력 기능
     */
    public ArrayList<Double> findAllResult(T findNum) {

        ArrayList<Double> allResult = (ArrayList<Double>) result.stream() // 1. 데이터 흐름 준비 단계
                .sorted()                                                 // 2. 데이터 정렬
                .filter(n -> n > findNum.doubleValue())            // 3. 필터링(findNum과 비교 후 큰 값만)
                .collect(Collectors.toList());                            // 4. 최종 연산 단계

        return allResult; // 결과 반환
    }
}