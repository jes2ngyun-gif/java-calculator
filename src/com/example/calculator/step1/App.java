package com.example.calculator.step1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

        System.out.print("첫번째 숫자 : ");
        int num1 = scanner.nextInt();

        System.out.print("두번째 숫자 : ");
        int num2 = scanner.nextInt();

        System.out.print("연산자를 입력하세요 (+, -, *, /) : ");
            char operator = scanner.next().charAt(0);

            switch (operator) {

                case '+':
                    System.out.println("결과 : " + (num1 + num2));
                    break;

                case '-':
                    System.out.println("결과 : " + (num1 - num2));
                    break;

                case '*':
                    System.out.println("결과 : " + (num1 * num2));
                    break;

                case '/':
                    if (num2 == 0) {
                        System.out.println("분모는 0이 될 수 없습니다.");
                    } else {
                        System.out.println("결과 : " + ((double) num1 / num2));
                    }
                    break;

                default:
                    System.out.println("잘못된 연산자입니다.");
                    break;

            }
            System.out.print("더 계산을 하시겠습니까? (exit 입력 시 종료) : ");
            String answer = scanner.next();

            if (answer.equals("exit")) {
                break;
            }


        }
        scanner.close();
    }
}