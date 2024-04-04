# GiveHub 

## 프로젝트 소개
개발자를 지망하는 사람들끼리 서로 정보나 기술을 공유할 수 있는 공간을 만들고 싶어 시작한 SNS입니다.

## [와이어 프레임](https://www.figma.com/file/nxf6DFbuY640mcBQaKXQvu/4%EC%A1%B0?type=design&node-id=0-1&mode=design&t=2sPlm6j2TYyjvAPR-0)

![와이어 프레임](https://github.com/JYeyun/NBC_GiveHub/blob/develop/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202024-04-04%20150542.png)

## 팀 개발 일정
2024.04.1 ~ 2024.04.05

+ 월 : 만들 어플의 컨셉과 UI 정하기
+ 화 : 큰 틀의 기능 구현
+ 수 : 피드백 후 UI 수정과 구체적인 기능 수행
+ 목 : 피드백 후 추가적인 기능 수행
+ 금 : 세부적인 디테일 마무리


## 개발 세부 기능 나누기 및 역할

### 팀장

마이 페이지 - 예윤님(발표)

### 팀원

로그인  - 진혁님

회원 가입 - 규식님

디테일 페이지 - 영진님

메인 페이지 - 지연님



## 주요 기능

### 로그인 
registerForActivityResult을 사용하여 회원가입할 때 입력한 아이디가 그대로 로그인 창에 띄워질 수 있게 함.
intent.putExtra를 이용하여 id와 비밀번호를 받아넘겨줌
비밀번호에 마스킹 처리를 하였음
아이디나 비밀번호 중 하나 이상이 일치하지 않으면 Toast로 "아이디 혹은 비밀번호가 틀렸습니다."라는 메시지를 출력

### 회원가입
아이디와 이름, 비밀번호를 입력 후 아이디가 이메일 형식에 맞는지, 비밀번호가 8자이상, 20자 이상인지 검사 후 회원가입 진행

### 마이페이지
intent.getStringExtra을 이용해 id를 받아와 출력

### 디테일 페이지
ConstrainLayout을 활용하였음.
intent.getStringExtra 및 intent.getIntExtra를 활용하여 userName, userImage, postImage, postTitle, postSummary를 넘겨 받음.
findViewById() 함수를 사용하여 화면에 데이터를 출력함.


### 메인 페이지
listview를 이용해 위 아래로 스크롤 할 수 있게하고, Adapter를 사용하여 AdapterView에 데이터를 표시


### 그 외
Activity 전환시 overridePendingTransition() 메서드를 사용하여 animation이 구현될 수 있도록 함. 
res/values/strings 디렉토리에서 string.xml-en을 만들어 en버전이 지원되도록 함.
동그란 ImageView를 만들어 사용함.
res/values/themes 디렉토리에서 night을 추가해 다크모드 구현함.





