package com.example.calculator.retry.step2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private final List<Double> resultList = new ArrayList<>();

    public double calculate(int num1, int num2, char operator) {
        double result;


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
                    throw new IllegalArgumentException("나눗셈에서 두번째 숫자는 0이 될 수 없습니다.");
                }
                result = (double) num1 / num2;
                break;


            default:
                throw new IllegalArgumentException("지원하지 않는 연산자입니다.");

        }

        resultList.add(result);
        return result;
    }

    public List<Double> getResultList() {
        return new ArrayList<>(resultList);
    }

    public void setResultList(List<Double> newResultList) {
        resultList.clear();
        resultList.addAll(newResultList);
    }

    public void removeFirstResult() {
        if (resultList.isEmpty()) {
            System.out.println("삭제할 결과가 없습니다.");
            return;
        }

        Double removedResult = resultList.remove(0);
        System.out.println("삭제된 결과 : " + removedResult);

    }
}
