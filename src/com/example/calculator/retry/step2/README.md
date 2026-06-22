### 문제
STEP1에서는 모든 기능이 App 클래스 하나에 작성되었다.

사용자 입력, 계산, 결과 출력, 반복문까지 모두 main 메서드 안에 존재했다.

STEP2에서는 객체지향 개념을 적용하여
- 계산 기능을 담당하는 Calculator
- 사용자와 상호작용하는 CalculatorApp

으로 역할을 분리하고, 계산 결과를 컬렉션에 저장하고 삭제하는 기능까지 구현하는 것이 이 실습의 목표이다.

---
### 문제 설명
클래스를 분리하고, 객체를 생성하고, 데이터를 안전하게 관리하는 객체지향의 기초를 연습하는 문제.

---
### STEP1 → STEP2 

| STEP1            | STEP2              |
| ---------------- | ------------------ |
| App 하나가 모든 역할 담당 | 역할 분리              |
| 계산 기능이 main에 존재  | Calculator 클래스로 이동 |
| 계산 결과 저장 불가      | List에 결과 저장        |
| 캡슐화 없음           | private 필드 적용      |
| 객체 사용 X          | 객체 생성 후 사용         |
| 함수 중심            | 객체 중심              |

---
### 실행 흐름도
```
프로그램 시작
      ↓
      
Calculator 객체 생성
      
      ↓
while 반복 시작
      
      ↓
숫자 입력
      
      ↓
연산자 입력
      
      ↓
calculator.calculate()
      
      ↓
결과 반환
      
      ↓
결과 출력
      
      ↓
결과 목록 출력
      
      ↓
삭제 여부 확인
      
      ↓
removeFirstResult()
      
      ↓
종료 여부 확인
      ↓
      
exit ?
 ┌───────┴───────┐
예               아니오
↓                ↓
종료          다시 반복
```
---
### 클래스 구도 그림
```
┌────────────────────┐
│   CalculatorApp    │
├────────────────────┤
│ Scanner            │
│ while              │
│ 입력               │
│ 출력               │
└─────────┬──────────┘
          │
          ▼
┌────────────────────┐
│     Calculator     │
├────────────────────┤
│ calculate()        │
│ getResultList()    │
│ removeFirstResult()│
│ resultList         │
└────────────────────┘
```
### 핵심 원리
#### 1. 책임 분리
STEP1
```
App가 모든 일을 함
```
↓
STEP2
```
CalculatorApp
↓

입력, 출력

Calculator
↓

계산, 저장, 삭제
```
---
#### 2. 캡슐화
```
private final List<Double> resultList;
```
외부에서
```
calculator.resultList
```
처럼 직접 접근하지 못하게 보호한다.

---
#### 3. 컬렉션 활용
배열은 크기가 고정된다.

계산 결과는 계속 늘어난다.

따라서 `ArrayList`가 적합하다.

---
#### 4. 객체 생성
```
Calculator calculator = new Calculator();
```
객체를 생성하여 기능을 사용한다.

---
#### 5. 메서드 활용
```
calculate()

getResultList()

removeFirstResult()
```
기능을 작은 단위로 분리한다.

---
#### 6. private를 사용했다고 캡슐화가 끝난 것이 아니다.
getter가 원본 리스트를 그대로 반환하면
```
calculator.getResultList().clear();
```
가 가능해진다.

따라서
```
return new ArrayList<>(resultList);
```
처럼 방어적 복사가 필요하다.

---
#### 7. final List의 의미
```
private final List<Double> resultList;
```
final은
```
리스트 변경 금지
X

참조 변경 금지
O
```
이다.

따라서
```
resultList.add()
```
는 가능하다.

---
### 추가로 
#### 왜 switch를 사용했을까?
연산 기준이
```
+
-
*
/
```
하나의 변수(operator)에 의해 결정되기 때문이다.

이런 경우에는 `switch` 가 if-else보다 읽기 쉽다.

---
#### 왜 List<Double> 일까?
실수가 나올 수 있기 때문
