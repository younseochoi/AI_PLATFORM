-- join query
select first_name, employees.department_id, department_name
from employees inner join departments 
on employees.department_id = departments.department_id;

-- 4 데이터베이스 모델링 이론 개념  - 현실 세계 데이터 
-- 1개 테이블 데이터 정의 하지 말라

-- 테이블 alias 선언 사용 권고
select e.first_name, e.department_id, d.department_name
from employees e inner join departments d
on e.department_id = d.department_id;

-- 부서이름별 급여 총합
select d.department_id 부서코드, d.department_name 부서이름, sum(e.salary) 부서명별급여총합
from employees e inner join departments d
on e.department_id = d.department_id
group by d.department_name
having sum(e.salary) >= 100000 
order by 부서이름;


-- 부서코드별 급여 총합
select e.department_id 부서코드, sum(e.salary) 부서코드별급여총합
from employees e 
group by e.department_id
having sum(e.salary) >= 100000 
order by 부서코드;


-- 세개의 테이블 join
-- EMPLOYEES - 사원 정보 DEPARTMENTS - 부서 정보 LOCATIONS - 도시 정보 COUNTRIES - 국가정보 
-- REGIONS - 대륙정보 

-- 사원명, 근무 도시명, 국가명 조회
DESCRIBE EMPLOYEES;
DESC DEPARTMENTS;
DESC LOCATIONS;
DESC COUNTRIES;

SELECT E.FIRST_NAME, L.CITY, C.COUNTRY_NAME
FROM EMPLOYEES E 
INNER JOIN DEPARTMENTS D ON E.DEPARTMENT_ID=D.DEPARTMENT_ID
INNER JOIN LOCATIONS L ON D.LOCATION_ID=L.LOCATION_ID
INNER JOIN COUNTRIES C ON L.COUNTRY_ID=C.COUNTRY_ID;

-- 사원명, 부서명, 도시명, 국가명 조회
-- 50, 80, 100 부서만 AND  급여 5000 이상 사원만 조회

SELECT D.DEPARTMENT_ID, E.SALARY, E.FIRST_NAME, D.DEPARTMENT_NAME, L.CITY, C.COUNTRY_NAME
FROM EMPLOYEES E 
INNER JOIN DEPARTMENTS D ON E.DEPARTMENT_ID=D.DEPARTMENT_ID
INNER JOIN LOCATIONS L ON D.LOCATION_ID=L.LOCATION_ID
INNER JOIN COUNTRIES C ON L.COUNTRY_ID=C.COUNTRY_ID
WHERE D.DEPARTMENT_ID IN (100, 80, 50) AND E.SALARY>=5000;

-- join 1> inner join 2> outer join 3>cross join(x)  4>self join
select first_name, employees.department_id, department_name
from employees cross join departments ; -- 106*27

select first_name, employees.department_id, department_name
from employees inner join departments 
on employees.department_id = departments.department_id; -- 106개


select count(*) from employees;
select count(department_id) from employees; -- 컬럼 not null 갯수

select first_name, department_id
from employees
where department_id is null;

-- inner join - join 2개 테이블 모두 존재하고 조건 일치하는 데이터만 합침
-- outer  join - join 2개 테이블 모두 존재하고 조건 일치하지 않아도 데이터만 합침
-- left outer join / right outer join
/*
employees left outer join departments
on employees.department_id = departments.department_id;

departments right outer join employees 
on employees.department_id = departments.department_id;
*/

-- 사원들에 부서명 조회하되 부서 소속되지 않는 사원은 부서코드 '-' , 부서명 '소속부서없음' 출력

select first_name, ifnull(e.department_id, '-') 부서코드, ifnull(department_name,'소속부서없음') 부서명
-- from employees e left outer join departments d
 from  departments d right outer join employees e
on e.department_id = d.department_id -- 107개
order by first_name;



-- 각 부서명, 근무 부서원명 조회하되 근무부서원 없는 부서명 조회
select distinct ifnull(first_name, '부서원없음'), d.department_id, department_name
from employees e right outer join departments d
on e.department_id = d.department_id -- 
order by d.department_id;

-- 106 - employees+departments 조인 조건 
-- 107 - employees 존재 모든 데이터 ㅈ
-- 122 - departmnets 존재 모든 데이터 ( 122- 106 = ???? 

-- self join
-- 사원본인 사번-employee_id , 사원의사수 사번-manager_id
-- employees 테이블에 존재. manager_id 사번들은 모두 employee_id에 있다
desc employees;

select employee_id, first_name, manager_id
from employees
where first_name like 'KE%';

select EMPLOYEE_ID, first_name
from employees
where EMPLOYEE_ID = 122;

-- 사원명 상사명 (상사 없는 사원 제외)
SELECT ME.FIRST_NAME 사원명 ,  MAN.FIRST_NAME 상사명 
FROM EMPLOYEES ME JOIN EMPLOYEES MAN ON ME.MANAGER_ID = MAN.EMPLOYEE_ID; -- 106

-- 사원명 상사명 (상사 없는 사원 포함)
SELECT EMPLOYEE_ID, FIRST_NAME FROM EMPLOYEES WHERE MANAGER_iD IS NULL;

SELECT ME.FIRST_NAME 사원명 ,  MAN.FIRST_NAME 상사명 
FROM EMPLOYEES ME LEFT JOIN EMPLOYEES MAN ON ME.MANAGER_ID = MAN.EMPLOYEE_ID;
-- 사원명 상사명 (부하직원 없는 상사 포함)
SELECT IFNULL(ME.FIRST_NAME , '신입사원') 사원명 ,  MAN.FIRST_NAME 상사명 
FROM EMPLOYEES ME RIGHT JOIN EMPLOYEES MAN ON ME.MANAGER_ID = MAN.EMPLOYEE_ID;

-- UNION, UNION ALL, NOT IN, IN

-- EMP_DEPT_50 테이블로 정의,데이터복사 한번
CREATE TABLE EMP_DEPT_50 (SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID=50);

-- EMP_DEPT_50 테이블은 50번 부서원들의 11개컬럼들 저장 테이블
SELECT * FROM EMP_DEPT_50;


CREATE TABLE EMP_JOB_MAN (SELECT * FROM EMPLOYEES WHERE JOB_ID LIKE '%MAN%');
-- 직종 코드 MANAGER 직종만 11개 컬럼 저장 테이블
SELECT * FROM EMP_JOB_MAN;

-- 50번 부서이거나 MANAGER 직종 재난지원금 받을 대상 조회 (이름 사번 직종코드 부서코드 조회). 중복 허용안함 
-- UNION(합집합  - a, B 테이블중 한개 포함 조회, 양쪽 모두 포함 1개)
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, DEPARTMENT_ID
FROM EMP_DEPT_50
UNION
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, DEPARTMENT_ID
FROM EMP_JOB_MAN;

SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, DEPARTMENT_ID
FROM EMP_DEPT_50
UNION ALL
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, DEPARTMENT_ID
FROM EMP_JOB_MAN;


SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID IN(100, 200, 300, 400, 500);

-- JOIN QUERY - 2개 이상의 테이블에 나누어졌을 때 컬럼 합침
-- UNION - 2개 이상의 테이블에 나누어졌을 때 레코드 합침
-- SUBQUERY 

-- EMPLOYEES 테이블에서 이름이 KELLY 와 같은 부서 근무 사원의 이름 근무부서코드 조회
SELECT DEPARTMENT_iD FROM EMPLOYEES WHERE FIRST_NAME='KELLY';

 SELECT FIRST_NAME 이름, DEPARTMENT_ID 근무부서코드
 FROM EMPLOYEES
 WHERE DEPARTMENT_ID=(SELECT DEPARTMENT_iD FROM EMPLOYEES WHERE FIRST_NAME='KELLY');
 
 -- EMPLOYEES 테이블에서 이름이 KELLY 와 같은 부서이면서 같은 직종의 사원의 이름 근무부서코드 조회
  SELECT FIRST_NAME 이름, DEPARTMENT_ID 근무부서코드, JOB_ID 직종코드
 FROM EMPLOYEES
 WHERE (JOB_ID, DEPARTMENT_ID)=(SELECT JOB_ID, DEPARTMENT_iD FROM EMPLOYEES WHERE FIRST_NAME='KELLY')
 AND FIRST_NAME != 'KELLY';
 
 -- peter 같은 부서원 조회
  SELECT FIRST_NAME 이름, DEPARTMENT_ID 근무부서코드
 FROM EMPLOYEES
 WHERE DEPARTMENT_ID not in (SELECT DEPARTMENT_iD FROM EMPLOYEES WHERE FIRST_NAME='peter');-- 80 50 제외
 
 
 SELECT FIRST_NAME 이름, DEPARTMENT_ID 근무부서코드
 FROM EMPLOYEES
 WHERE salary = (SELECT truncate(avg(salary),-2)  FROM EMPLOYEES);
 
 SELECT truncate(avg(salary),-2)  FROM EMPLOYEES;

 -- SELECT JOB_ID, DEPARTMENT_iD FROM EMPLOYEES WHERE department_id = 50;
 -- SELECT JOB_ID, DEPARTMENT_iD FROM EMPLOYEES WHERE department_id in (50, 80);
  
  -- union / union all/  in / not in
  -- subquery 사용 whereh 절 조건  단일행 subquery  '=' / 다중행 subquery 'in'
-- JOIN - 각 2개 테이블에서 컬럼 함침


