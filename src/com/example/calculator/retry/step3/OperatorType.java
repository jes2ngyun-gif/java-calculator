package com.example.calculator.retry.step3;
        // Enum은 서로 관련 있는 상수들을 하나의 타입으로 묶어서 관리할 때 사용한다.
        // 연산기호를 의미 있는 이름으로 관리하기 위해 사용함.
public enum OperatorType {

    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),                   // 각각의 Enum 상수는 하나의 연산 타입을 의미함.
    DIVIDE('/');                     // 괄호 안의 문자는 사용자가 입력하는 실제 연산 기호

    private final char symbol;              // 각 연산 타입이 어떤 연산 기호와 연결되는지 저장하는 `필드`
                                            // final : 한 번 정해진 연산 기호가 바뀌면 안 되기 때문


            // Enum `생성자`
            // 괄호 안의 문자가 symbol 필드에 저장된다.
    OperatorType(char symbol) {
        this.symbol = symbol;
    }
    public char getSymbol() {                // symbol 값을 외부에서 읽을 수 있도록 get 사용
        return symbol;                       // 필드가 private이므로 직접 접근을 막고, 필요한 값만 메서드를 통해 반환함.
    }


             // 사용자가 입력한 문자를 Enum 타입으로 바꿔주는 `메서드`
    public static OperatorType fromSymbol(char symbol) {


                                              // values()는 현재 Enum에 선언된 모든 상수를 배열로 반환함.
                                              // 여기서는 ADD, SUBTRACT, MULTIPLY, DIVIDE를 하나씩 꺼내서 비교한다.
        for (OperatorType operator : values()) {

            if ( operator.symbol == symbol) {                // 사용자가 입력한 symbol과 Enum이 갖고 있는 symbol이 같으면
                return operator;                             // 해당 Enum 상수를 반환함.
            }
        }
        throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
                                                // 반복문을 다 돌았는데 일치하는 연산자가 없으면 예외를 발생시킴.
    }
}
