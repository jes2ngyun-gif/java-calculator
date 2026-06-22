package com.example.calculator.retry.step3;

public class ArithmeticCalculator<T extends Number> {


    public double calculate(T num1, T num2, OperatorType operator) {

        double first = num1.doubleValue();
        double second = num2.doubleValue();

        double result;

        switch (operator) {

            case ADD:
                result = first + second;
                break;

            case SUBTRACT:
                result = first - second;
                break;

            case MULTIPLY:
                result = first * second;

            case DIVIDE:
                if (second == 0) {
                    throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
                }
                result = first / second;
                break;

            default:
                throw new IllegalArgumentException("잘못된 연산입니다.");
        }

    }

}
