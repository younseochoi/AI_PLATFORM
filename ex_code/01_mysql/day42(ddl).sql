select * from member;
desc member;

-- create table /alter /drop

-- create table 테이블구조 (테이블명, 컬럼명 타입(길이) , )
-- drop table 테이블명;
-- alter table 테이블명 - 컬럼 1개 추가, 수정, 컬럼 1개 삭제 

-- sql  + 데이터양식 제한 = 제약조건 정의
create table member 
(
id varchar(30) ,
password int(4) ,
name varchar(30),
phone char(13),
email varchar(30),
regdate datetime
);

insert into member values('id1', 1111, '홍길동', '010-1234-5678', 'hong@multi.com','2022-07-15 15:16:16');
insert into member values('id2', 2222, '박길동', '010-5678-1234', 'park@tech.net',now());-- 시분초까지
insert into member values('id4', 4444, '김한국', '010-5678-1235', 'park@tech.net',curdate()); -- date

select * from member;

-- 폰번호 국번 1234 인 회원 id, phone, password 조회. 단 암호 "-"
select id, phone, insert(password, 1, length(password), repeat('-', length(password)))
from member
where phone like '____1234%';


create table c_member(
id varchar(30) primary key , 
password integer(4) not null,
name varchar(30),
phone char(13) unique,
email varchar(30) check (email like '%@%'), 
regdate datetime
); -- 제약조건 설정 

-- 제약조건 효력 발생
insert into c_member values('id1', 1111, '홍길동', '010-1234-5678', 'hong@multi.com','2022-07-15 15:16:16');
insert into c_member values('id2', 2222, '박길동', '010-5678-1234', 'park/tech.net',now());-- 시분초까지
insert into member values('id4', 4444, '김한국', '010-5678-1235', 'park@tech.net',curdate()); -- date

-- 메모테이블 정의 (번호(자동 1, 2, 3,   PK, 제목, 내용, 글쓴시각, 작성자)
CREATE TABLE C_MEMO
(MEMO_ID INT PRIMARY KEY AUTO_INCREMENT, 
TITLE VARCHAR(50) NOT NULL,
CONTENTS VARCHAR(4000),
TIME DATETIME DEFAULT NOW(),
WRITER VARCHAR(30) 
);

-- 제약 조건 추가 / 삭제 / 수정 가능 (제한적) -- 이미 테이블 데이터 저장중
-- create table backup (select * from c_memo);
-- delete from c_memo ;-- 삭제

-- create table 이미 생성 후 제약조건 추가
alter table c_memo add constraint foreign key(writer) references c_member(id);

insert into c_memo values(1, '1번글제목','1번글내용',DEFAULT, 'ID2');
insert into c_memo(title, contents, time, writer) values('2번글제목','2번글내용',DEFAULT, 'ID1');
-- error
-- insert into c_memo(title, contents, time, writer) values('2번글제목','2번글내용',DEFAULT, 'ID3');

insert into c_member values('id3', 3333,'이자바','010-9999-0000','lee@java.com', now());
insert into c_memo(title, contents, time, writer) values('2번글제목','2번글내용',DEFAULT, 'ID3');
insert into c_memo(title, contents, time, writer) values('ID3제목',NULL,DEFAULT, 'ID3');
insert into c_memo(title, contents, time, writer) values('ID1제목','ID1글내용',DEFAULT, 'ID1');

SELECT * FROM C_MEMBER;
SELECT * FROM C_MEMO;

INSERT INTO C_MEMBER VALUES('ID2', 2222, '박대한', '010-1111-2222', 'ID2@MUL.COM', now());
insert into c_memo values(1, '1번글제목','1번글내용',DEFAULT, 'ID2');
insert into c_memo(title, contents, time, writer) values('2번글제목','2번글내용',DEFAULT, 'ID1');


-- 이름이 이자바 회원의 글쓴 제목, 내용 조회 - JOIN
-- 회원명 글제목 글내용
SELECT M1.NAME , M2.TITLE, M2.CONTENTS
FROM C_MEMBER M1 JOIN C_MEMO M2 ON M1.ID = M2.WRITER
WHERE M1.NAME ='이자바';

-- 제약조건- 데이터 안전 보관 좋은 점 / 실습  

-- FOREIGN KEY - 다른 테이블 다른 컬럼 참조
-- C_MEMO.WRITER(자식) <----- C_MEMBER.ID(부모)
-- 부모 존재하지 않는 데이터는 자식도 사용 불가
-- 부모데이터 삭제시 자식데이터 처리설정하지 않으면 불가능
DELETE FROM C_MEMBER WHERE NAME='이자바';

--  부모데이터 삭제시 자식데이터 같이 삭제 설정 추가

-- FOREIGN KEY 기존키 삭제
ALTER TABLE C_MEMO DROP FOREIGN KEY c_memo_ibfk_3;


show keys from c_memo;

-- 새로운 FOREIGN KEY +부모데이터 삭제시 자식데이터 같이 삭제 설정 추가
alter table c_memo add constraint foreign key(writer) references c_member(id)
on delete CASCADE on UPDATE CASCADE;

DELETE FROM C_MEMBER WHERE NAME='이자바';-- 

SELECT * FROM C_MEMBER;
SELECT * FROM C_MEMO;

-- 새로운 FOREIGN KEY +부모데이터 삭제시 자식데이터 연결 끊고 아무 액션 X 설정 추가
alter table c_memo add constraint foreign key(writer) references c_member(id)
on delete NO ACTION on UPDATE CASCADE;

/*
CREATE TABLE (? ? ? ?..
ALTER TABLE 
DROP TABLE C_MEMO;
*/
-- SELECT INSEWRT UPDATE DELETE 






alter table c_memo add constraint foreign key(writer) references c_member(id);
DELETE FROM C_MEMBER WHERE NAME='홍길동';-- 오류

-- SHOW KEYS FROM C_MEMO; -- KEY 이름 WRITER 확인후
alter table c_memo DROP foreign key C_MEMO_IBFK_2 ; -- 기존키 삭제(숫자 1 , 2, ..)
alter table c_memo add constraint foreign key(writer) references c_member(id)
ON DELETE CASCADE ON UPDATE CASCADE; -- 새롭게 추가하면서 CASCADE 추가

DELETE FROM C_MEMBER WHERE NAME='홍길동';

insert into c_member values('id1', 1111, '홍길동', '010-1234-5678', 'hong@multi.com','2022-07-15 15:16:16');





