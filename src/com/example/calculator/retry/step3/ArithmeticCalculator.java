package com.example.calculator.retry.step3;

import java.util.ArrayList;
import java.util.List;

               // 실제 계산 기능을 담당하는 클래스
               // <T extends Number>는 제네릭 문법
               // T는 숫자 타입만 받을 수 있도록 Number를 상속받은 타입으로 제한함.
public class ArithmeticCalculator<T extends Number> {

               // 계산 결과들을 저장하는 리스트
               // 계산 결과가 여러 개 누적될 수 있으므로 배열보다 ArrayList가 적합함
               //나눗셈 결과가 소수점으로 나올 수 있기 때문에 <Double> 사용
    private final List<Double> resultList = new ArrayList<>();
    public double calculate(T num1, T num2, OperatorType operator) {                // 사칙연산을 수행하는 '메서드'
                                                                                    // T 타입의 숫자 2개와 Enum 타입의 연산자를 전달받는다.

        double first = num1.doubleValue();                       // T를 double 타입으로 변환한다.
        double second = num2.doubleValue();

        double result;

        switch (operator) {                                      // operator는 OperatorType Enum이다.

            case ADD:
                result = first + second;
                break;

            case SUBTRACT:
                result = first - second;
                break;

            case MULTIPLY:
                result = first * second;

            case DIVIDE:
                if (second == 0) {                                // 잘못된 계산 결과를 저장하지 않기 위해 예외를 발생시킨다.
                    throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
                }
                result = first / second;
                break;

            default:
                throw new IllegalArgumentException("잘못된 연산입니다.");
        }
        resultList.add(result);
                  // 예외가 발생하면 여기까지 않으므로 잘못된 값은 저장되지 않음.

        return result;
                  // 계산 결과를 App으로 반환함.
    }

    public List<Double> getResultList() {                            // 저장된 결과 목록을 조회하는 '메서드'
        return new ArrayList<>(resultList);                          // 외부에서 resultList를 직접 수정하지 못하도록 복사본을 반환함.
    }

    public List<Double> getGreaterResults(double target) {           // 저장된 결과 값 중 사용자가 입력한 기준값보다 큰 결과만 조회하는 '메서드'

        return resultList.stream()
                         .filter(result -> result > target)
                          .toList();
                                                // 저장된 결과 목록을 Stream으로 변환하고
                                                // resultList 안의 값들을 하나씩 꺼내서 target보다 큰 값만 남김.
    }                                           // 조건을 통과한 값들을 다시 List로 모은다.

}
