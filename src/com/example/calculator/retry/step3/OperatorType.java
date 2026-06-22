package com.example.calculator.retry.step3;

public enum OperatorType {

    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    private final char symbol;

    OperatorType(char symbol) {
        this.symbol = symbol;
    }
    public char getSymbol() {
        return symbol;
    }

    public static OperatorType fromSymbol(char symbol) {

        for (OperatorType operator : values()) {

            if ( operator.symbol == symbol) {
                return operator;
            }
        }
        throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
    }
}
