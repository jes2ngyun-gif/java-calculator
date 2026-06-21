package com.example.calculator.retry.step1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();

            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /): ");
            char operator = sc.next().charAt(0);

            double result = 0;
            boolean isValid = true;



            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;

                case '-':
                    result = num1 - num2;
                    break;

                case '*':
                    result = num1 * num2;
                    break;

                case '/':
                    if (num2 == 0) {
                        System.out.println("나눗셈 연산에서 두 번째 숫자에 0을 입력할 수 없습니다.");
                        isValid = false;
                    } else {
                        result = (double) num1 / num2;
                    }
                    break;

                default:
                    System.out.println("잘못된 연산 기호입니다.");
                    isValid = false;
            }

            if (isValid) {
                System.out.println("결과: " + result);
            }

            System.out.print("더 계산하시겠습니까? 종료하려면 exit을 입력하세요: ");
            String answer = sc.next();

            if (answer.equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
        }

        sc.close();
    }
}
