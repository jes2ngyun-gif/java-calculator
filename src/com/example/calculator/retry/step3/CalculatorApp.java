package com.example.calculator.retry.step3;

import java.util.List;
import java.util.Scanner;
              // 프로그램의 실행을 담당하는 클래스
              // 사용자 입력, 결과 출력, 반복 실행, 예외 메세지 출력을 담당
public class CalculatorApp {

              // static: 객체 생성 없이 클래스에서 바로 사용 가능
              // final: 값 변경 불가
    private static final String EXIT = "exit";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);                                // 사용자가 입력을 받기 위한 객체

        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>();
               // ArithmeticCalculator 객체를 생성함
               // <Double>: 실수 입력도 받기 위해

        while (true) {                                                       // 사용자가 exit을 입력하기 전까지 무한 반복
            try {                                                            // 잘못된 연산자 입력, 0으로 나누기 같은 예외 상황을 처리하기 위해 try-catch 사용
                System.out.print("첫번째 숫자를 입력하세요 : ");
                double num1 = sc.nextDouble();

                System.out.print("두번째 숫자를 입력하세요 : ");
                double num2 = sc.nextDouble();                                // 실수도 입력받을 수 있어야 하므로 nextDouble()을 사용함

                System.out.print("연산자를 입력하세요 (+, -, *, /) : ");
                char symbol = sc.next().charAt(0);

                OperatorType operator = OperatorType.fromSymbol(symbol);      // 사용자가 입력한 문자 연산자를 Enum 타입으로 변환한다.
                                                                              // 예: '+' → OperatorType.ADD

                double result = calculator.calculate(num1, num2, operator);   //CalculatorApp은 계산 로직을 직접 알 필요 없이 메서드를 호출하고 결과만 받음

                System.out.println("결과 : " + result);                        // 계산 결과 출력

                System.out.println("저장된 결과 목록 : " + calculator.getResultList());         // 현재까지 저장된 모든 계산 결과 목록을 출력

                System.out.print("기준 값을 입력하세요 : ");                       // 저장된 결과 중 사용자가 입력한 기준값보다 큰 결과를 출력해야 함.(조건)
                double target = sc.nextDouble();

                List<Double> greaterResults = calculator.getGreaterResults(target);           // 스트림과 람다로 필터링한 결과를 가져온다.

                System.out.println(target + "보다 큰 결과들 : " + greaterResults);               // 기준값보다 큰 결과 목록을 출력함
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) : ");

            String answer = sc.next();

            if (answer.equals(EXIT)) {
                System.out.println("계산기를 종료합니다.");

                break;
            }
        }
        sc.close();

    }
}
