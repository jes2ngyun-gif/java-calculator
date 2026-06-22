package com.example.calculator.retry.step3;

import java.util.List;
import java.util.Scanner;

public class CalculatorApp {
private static final String EXIT = "exit";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>();

        while (true) {
            try {
                System.out.print("첫번째 숫자를 입력하세요 : ");
                double num1 = sc.nextDouble();

                System.out.print("두번째 숫자를 입력하세요 : ");
                double num2 = sc.nextDouble();

                System.out.print("연산자를 입력하세요 (+, -, *, /) : ");
                char symbol = sc.next().charAt(0);

                OperatorType operator = OperatorType.fromSymbol(symbol);

                double result = calculator.calculate(num1, num2, operator);

                System.out.println("결과 : " + result);

                System.out.println("저장된 결과 목록 : " + calculator.getResultList());

                System.out.print("기준 값을 입력하세요 : ");

                double target = sc.nextDouble();

                List<Double> greaterResults = calculator.getGreaterResults(target);

                System.out.println(target + "보다 큰 결과들 : " + greaterResults);
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
