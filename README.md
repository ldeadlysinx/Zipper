# Zipper AI 기반 개인 맞춤형 학습 지원 플랫폼

## 서비스 플로우 구조
![image](https://github.com/user-attachments/assets/ee4cb836-d8c4-403f-9607-f8790a612775)


## 사용기술

프론트엔드: React(JavaScript)
백엔드: SpringBoot(JAVA), MySQL, Flask(AI), AWS EC2,Nginx

## 역할

- DB 설계 및 관리
- SpringBoot 와 MySQL을 이용하여 유저,게시판,댓글,알림 테이블 생성 및 관리
- User 생성,로그인,로그아웃 구현

## 주요 기능
### 유저 회원가입: 유저이름,아이디,이메일 입력받기
- 이메일 인증: 메일 시스템을 이용해 이메일로 인증번호 전송 Redis로 전송된 인증번호 저장 이후 이메일이 일치하는지 확인
- 비밀번호: 스프링 시큐리티를 통해 입력받은 비밀번호를 암호화
- 로그인 : 일반 로그인 및 소셜서비스(Google,Naver,Kakao) 로그인 OAuth 구현 로그인 한 계정에게 JWT 토큰 발급
- 로그아웃: 로그아웃시 Redis에 JWT 만료시간까지 토큰 보관 기능 구현
- 운영자 계정: 운영자 role을 가지는 유저는 모든 게시글의 권한을 가짐

### React 와 스프링부트 사이 통신 구현

- CorsConfig를 통해 프런트에서만 백엔드로 통신 가능하게 구현
- Axios를 통해 백엔드와 스프링부트와 통신 및 useEffect와 Redux 기능을 통해 프런트 전역에 적용
- 게시글 및 댓글 CRUD 구현

### 게시판 CRUD 기능(게시글 작성,조회,수정,삭제)
- 게시글 좋아요 기능
- 게시판 댓글 CRUD 기능 구현
- 좋아요 기능 구현
- 페이징 기능 구현
- 게시판 종류별로 분류

### 쿼리 작성
- JPQL 쿼리 작성: JPQL을 활용해 복잡한 쿼리 작성, 예를 들어 카테고리별로 게시글을 좋아요 수에 따라 내림차순으로 정렬하고 페이징 처리, 특정 조건에 맞는 게시글 조회 등의 기능을 구현

### 마이페이지 구현

- 내가 작성한 글 목록
- 내 정보수정(비밀번호, 학년)
- 내가 좋아요한 게시글
- 내가 남긴 댓글

### 알림기능 구현

- SSE 통신을 통해 기능 구현: 발급받은 JWT로 Sse Emitter를 통해 해당 유저의 게시글의 댓글이 달릴시 알림
