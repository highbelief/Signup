# 회원가입 예제

## 프로젝트 개요
이 프로젝트는 대학교 실습 과제의 일환으로 개발된 **회원가입 예제**입니다. 웹 풀스택 훈련 내용을 담고 있으며, Java와 Spring Framework를 이용해 회원가입 기능을 구현한 웹 애플리케이션입니다. 데이터베이스는 MySQL을 사용하여 회원 정보를 저장하고 관리합니다.

## 기술 스택
- **언어**: Java
- **프레임워크**: Spring Boot
- **데이터베이스**: MySQL
- **IDE**: IntelliJ IDEA UL
- **JDK 버전**: 21
- **MySQL 버전**: 8.0 이상

## 설치 및 실행 방법

### 요구 사항
- **IntelliJ IDEA UL**: 프로젝트를 열기 위한 권장 IDE.
- **JDK 21**: Java Development Kit 21 버전 이상.
- **MySQL 8.0** 이상: 데이터베이스 설정 및 사용.

### 프로젝트 설치
1. GitHub 저장소에서 프로젝트를 클론합니다:
    ```bash
    git clone https://github.com/your-repository-url.git
    ```
2. IntelliJ IDEA에서 프로젝트를 엽니다.
3. MySQL 데이터베이스를 설정하고, `application.properties` 파일에 MySQL 연결 정보를 입력합니다.
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/your-database-name
    spring.datasource.username=your-username
    spring.datasource.password=your-password
    spring.jpa.hibernate.ddl-auto=update
    ```

### 실행 방법
1. MySQL 서버를 실행합니다.
2. IntelliJ IDEA에서 프로젝트를 실행합니다.
3. 애플리케이션이 실행되면, 웹 브라우저에서 `http://localhost:8080`에 접속하여 회원가입 페이지에 접근할 수 있습니다.

## 주요 기능
- **회원가입**: 사용자 정보를 입력하여 새로운 계정을 생성할 수 있습니다.
  - 사용자 이름, 비밀번호, 이메일 등의 정보 입력
  - 중복된 아이디 검사 기능 포함
  - 비밀번호 확인 기능 포함

## 라이선스
이 프로젝트는 별도의 라이선스가 지정되지 않았습니다.
