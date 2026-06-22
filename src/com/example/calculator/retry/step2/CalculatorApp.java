package com.example.calculator.retry.step2;

import java.util.Scanner;

public class CalculatorApp {

    private static final String EXIT = "exit";
    private static final String YES = "yes";


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();


        while (true) {
            try {
                System.out.println("첫번째 숫자를 입력하세요 : ");
                int num1 = sc.nextInt();

                System.out.println("두번째 숫자를 입력하세요 : ");
                int num2 = sc.nextInt();

                System.out.println("사칙연산 기호를 입력하세요 (+, -, *, /) : ");
                char operator = sc.next().charAt(0);

                double result = calculator.calculate(num1, num2, operator);

                System.out.println("결과 : " + result);
                System.out.println("저장된 결과 목록 : " + calculator.getResultList());

                System.out.println("가장 먼저 저장된 결과를 삭제하시겠습니까? (yes 입력 시 삭제) : ");
                String removeAnswer = sc.next();

                if (removeAnswer.equals(YES)) {
                    calculator.removeFirstResult();
                    System.out.println("삭제 후 결과 목록 : " + calculator.getResultList());
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            System.out.print("더 계산하시겠습니까?? 종료하려면 exit을 입력하세요 : ");
            String answer = sc.next();

            if (answer.equals(EXIT)) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
        }
        sc.close();
    }
}
