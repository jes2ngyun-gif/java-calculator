package com.example.calculator.step2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {


    private List<Double> resultList = new ArrayList<>();


    public double calculate(int num1, int num2, char operator) {


        double result = 0;

        if (operator == '+') {
            result = num1 + num2;

        } else if (operator == '-') {
            result = num1 - num2;

        } else if (operator == '*') {
            result = num1 * num2;

        } else if (operator == '/') {

            if (num2 == 0) {
                System.out.println("분모는 0이 될 수 없습니다.");
                return 0;
            }
            result = (double) num1 / num2;

        }

        resultList.add(result);

        return result;

    }

    public List<Double> getResultList() {

        return resultList;

    }
    public void setResultList(List<Double> resultList) {

        this.resultList = resultList;

    }
    public void removeResult() {

        if (!resultList.isEmpty()) {
            resultList.remove(0);
        }
    }
}
