package com.example.calculator.step2;

import java.util.Scanner;

public class CalculatorApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true) {

            System.out.print("첫번째 숫자 : ");
            int num1 = scanner.nextInt();

            System.out.print("두번째 숫자 : " );
            int num2 = scanner.nextInt();

            System.out.print("연산자를 입력하세요 (+, -, *, /) : ");
            char operator = scanner.next().charAt(0);

            double result = calculator.calculate(num1, num2, operator);

            System.out.println("결과 : " + result);
            System.out.println("저장된 결과 목록 : " + calculator.getResultList());

            System.out.print("가장 먼저 저장된 결과를 삭제하시겠습니다? (yes 입력 시 삭제) : ");
            String removeAnswer = scanner.next();


            if(removeAnswer.equals("yes")) {

                calculator.removeResult();
                System.out.println("삭제 후 결과 목록 : " + calculator.getResultList());

            }
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) : ");
            String answer = scanner.next();

            if (answer.equals("exit")) {
                break;
            }

        }
        scanner.close();
    }
}
