# 기능 구현 목록

## 1. 프로그램 진행 기능
- [ ] 기능 선택을 입력받는다.
### 페어 매칭인 경우
- [ ] 과정, 레벨, 미션을 입력받는다.
- [ ] 1 - 기존 페어매칭이 없으면 페어 매칭을 진행한다.
  - [ ] 매칭에 성공하면 결과를 출력한다.
  - [ ] 매칭에 실패하면 에러메시지를 출력하고 메인화면으로 돌아온다.
  - ✅ 같은 레벨에서 이미 페어로 만난적이 있는 크루끼리 다시 페어로 매칭 된다면 크루 목록의 순서를 다시 랜덤으로 섞어서 매칭을 시도한다.
  - ✅ 3회 시도까지 매칭이 되지 않거나 매칭을 할 수 있는 경우의 수가 없으면 에러 메시지를 출력한다.
  - ✅ 출력되는 페어의 순서는 camp.nextstep.edu.missionutils.Randoms의 shuffle 메서드의 결과 순서로 정렬한다.

- [ ] 2 - 기존 페어매칭이 있으면 재매칭 여부를 입력받는다.
  - [ ] 재매칭이면, 1을 진행한다.
  - [ ] 재매칭이 아니면, 메인화면으로 돌아온다.

### 페어 조회인 경우
- [ ] 과정, 레벨, 미션을 입력받는다.
- [ ] 매칭결과가 있으면, 결과를 출력한다.
- [ ] 매칭결과가 없으면 에러 메시지를 출력하고 메인화면으로 돌아온다.

### 페어 초기화인 경우
- [ ] 모든 페어 매칭 결과를 초기화한다.
 
---


## 2. 입력 기능

- 기능 선택 입력받는 기능
- ⚠️예외 검증: 기능 선택 입력 형식
  - [ ] 공백이 아닌지

- ⚠️예외 검증: 옵션 선택 객체
  - [ ] 1,2,3,Q 중에 하나의 문자인지

- 과정, 레벨, 미션 입력받는 기능
- ⚠️예외 검증: 과정, 레벨, 미션 입력 형식
- [ ] split 후 공백 제거하기!
  - [ ] 공백이 아닌지
  - [ ] `,`가 2번이상 연속으로 들어가지 않는지
  - [ ] 맨 앞, 뒤에 `,`가 있지 않은지
  - [ ] `,`로 구분된 요소가 3개인지

- ⚠️예외 검증:  과정, 레벨, 미션 객체
  - 과정 객체
    - [ ] 백엔드, 프론트엔드 중에 하나인지
  - 과정 객체
    - [ ] 레벨1,2,3,4,5 중에 하나인지
    - [ ] 레벨3, 5이면 미션이 없다는 예외 던지기
  - 과정 객체
    - [ ] 각 레벨에 해당하는 과정인지

- 재매칭 여부 입력받는 기능
- ⚠️예외 검증: 재매칭 여부 입력 형식
  - [ ] 공백이 아닌지

- ⚠️예외 검증: 재매칭 여부 객체
  - [ ] 네, 아니오 중에 하나인지
---

## 3. 출력 기능

- [ ] 페어 매칭 결과 출력하는 기능

---


## 4. ✅ 체크할 점
### 페어 매칭
- [ ] 같은 레벨에서 이미 페어를 맺은 크루와는 다시 페어로 매칭될 수 없다.
- [ ] 페어 매칭 대상이 홀수인 경우 한 페어는 3인으로 구성한다.
- [ ] 크루들의 이름 목록을 List<String> 형태로 준비한다.
  - [ ] 크루 목록의 순서를 랜덤으로 섞는다. 이 때 `camp.nextstep.edu.missionutils.Randoms`의 shuffle 메서드를 활용해야 한다.
    - ```List<String> crewNames; // 파일에서 로드한 크루 이름 목록
      List<String> shuffledCrew = Randoms.shuffle(crewNames); // 섞인 크루 이름 목록```
  - [ ] 랜덤으로 섞인 페어 목록에서 페어 매칭을 할 때 앞에서부터 순서대로 두명씩 페어를 맺는다.
  - [ ] 홀수인 경우 마지막 남은 크루는 마지막 페어에 포함시킨다.
  - [ ] 같은 레벨에서 이미 페어로 만난적이 있는 크루끼리 다시 페어로 매칭 된다면 크루 목록의 순서를 다시 랜덤으로 섞어서 매칭을 시도한다.
  - [ ] 3회 시도까지 매칭이 되지 않거나 매칭을 할 수 있는 경우의 수가 없으면 에러 메시지를 출력한다.
    - [ ] 그리고 나서는? 예외 던지고? 다시 선택하게 해야하나?
- [ ] 매칭 정보가 있습니다. 다시 매칭하시겠습니까?: 아니오를 선택할 경우 코스, 레벨, 미션을 다시 선택한다.
- [ ] 출력되는 페어의 순서는 camp.nextstep.edu.missionutils.Randoms의 shuffle 메서드의 결과 순서로 정렬한다.
### 페어 조회 기능
- [ ] 매칭 이력이 없으면 : [ERROR] 매칭 이력이 없습니다.
### 사전 제공 정보
- [ ] 크루 정보는 src/resources 하위에 md 파일로 제공되며 변경이 가능하다.
  - 수정 시 크루들의 이름은 중복될 수 없다.
  - 파일 입출력 방법은 자바 파일 읽기나 자바 파일 입출력과 같은 키워드로 구글링
- [ ] 과정, 레벨, 미션 정보는 아래에 제공하는 그대로 사용해야 한다.
### 프로그래밍 요구사항
- [ ] Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 shuffle()를 활용한다.
- [ ] 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

---


## 5. 리팩토링 목록
### 요구사항
- [ ] indent (2)
- [ ] 메서드 길이 (15)
- [ ] 단위 테스트 확인 
### 그 외
- [ ] 컨트롤러 메소드 네이밍 정리 및 분리 개선
- [ ] 숫자 리터럴 상수화 (outputFormatter, inputView, inputValidator도)
---
- [ ] 부생성자가 있는 경우 생성자의 접근제어자가 private인지
- [ ] 이해를 위한 코드 전반의 공백 추가
- [ ] 각 클래스 메소드 순서 점검하기
- [ ] 테스트 코드 리팩토링
- [ ] getter 리스트 레퍼런스에 unmodifaible 추가
---- 