-- ★ <연습문제> PART1

--1. 이름, 직속상사
SELECT E1.ENAME "ENAME", E2.ENAME "MNAME"
    FROM EMP E1, EMP E2
    WHERE E1.MGR = E2.EMPNO;

--2. 이름, 급여, 업무, 직속상사
SELECT E1.ENAME "ENAME", E1.SAL, E1.JOB, E2.ENAME "MNAME"
    FROM EMP E1, EMP E2
    WHERE E1.MGR = E2.EMPNO;

--3. 이름, 급여, 업무, 직속상사. (상사가 없는 직원까지 전체 직원 다 출력.
    --상사가 없을 시 '없음'으로 출력)
SELECT E1.ENAME "ENAME", E1.SAL, E1.JOB, NVL(E2.ENAME, '없음') "MNAME"
    FROM EMP E1, EMP E2
    WHERE E1.MGR = E2.EMPNO(+);

--4. 이름, 급여, 부서명, 직속상사명
SELECT E1.ENAME "ENAME", E1.SAL, DNAME, E2.ENAME "MNAME"
    FROM EMP E1, EMP E2, DEPT
    WHERE E1.MGR = E2.EMPNO AND E1.DEPTNO = DEPT.DEPTNO;

--5. 이름, 급여, 부서코드, 부서명, 근무지, 직속상사명, (상사가 없는 직원까지 전체 직원 다 출력)
SELECT E1.ENAME "ENAME", E1.SAL, E1.DEPTNO, DNAME, LOC, E2.ENAME "MNAME"
    FROM EMP E1, EMP E2, DEPT
    WHERE E1.MGR = E2.EMPNO(+) AND E1.DEPTNO = DEPT.DEPTNO;
    
--6. 이름, 급여, 등급, 부서명, 직속상사명. 급여가 2000이상인 사람
SELECT E1.ENAME "ENAME", E1.SAL, GRADE, DNAME, E2.ENAME "MNAME"
    FROM EMP E1, EMP E2, DEPT, SALGRADE
    WHERE E1.MGR = E2.EMPNO AND E1.DEPTNO = DEPT.DEPTNO 
        AND E1.SAL BETWEEN LOSAL AND HISAL AND E1.SAL >= 2000;

--7. 이름, 급여, 등급, 부서명, 직속상사명, (직속상사가 없는 직원까지 전체직원 부서명 순 정렬)
SELECT E1.ENAME "ENAME", E1.SAL, GRADE, DNAME, E2.ENAME "MNAME"
    FROM EMP E1, EMP E2, DEPT, SALGRADE
    WHERE E1.MGR = E2.EMPNO(+) AND E1.DEPTNO = DEPT.DEPTNO
        AND E1.SAL BETWEEN LOSAL AND HISAL;

--8. 이름, 급여, 등급, 부서명, 연봉, 직속상사명. 연봉=(급여+comm)*12 단 comm이 null이면 0
SELECT E1.ENAME, E1.SAL, GRADE, DNAME, (E1.SAL+NVL(E1.COMM,0))*12 "ANNUAL_SAL",  E2.ENAME "MNAME"
    FROM EMP E1, EMP E2, DEPT, SALGRADE
    WHERE E1.MGR = E2.EMPNO AND E1.DEPTNO = DEPT.DEPTNO 
        AND E1.SAL BETWEEN LOSAL AND HISAL;

--9. 8번을 부서명 순 부서가 같으면 급여가 큰 순 정렬
SELECT E1.ENAME, E1.SAL, GRADE, DNAME, (E1.SAL+NVL(E1.COMM,0))*12 "ANNUAL_SAL",  E2.ENAME "MNAME"
    FROM EMP E1, EMP E2, DEPT, SALGRADE
    WHERE E1.MGR = E2.EMPNO AND E1.DEPTNO = DEPT.DEPTNO 
        AND E1.SAL BETWEEN LOSAL AND HISAL
    ORDER BY DNAME, ANNUAL_SAL DESC;






--  PART2


--1.EMP 테이블에서 모든 사원에 대한 이름,부서번호,부서명을 출력하는 SELECT 문장을 작성하여라.
SELECT ENAME, EMP.DEPTNO, DNAME
    FROM EMP, DEPT
    WHERE EMP.DEPTNO = DEPT.DEPTNO;

--2. EMP 테이블에서 NEW YORK에서 근무하고 있는 사원에 대하여 이름,업무,급여,부서명을 출력
SELECT ENAME, JOB, SAL, DNAME
    FROM EMP, DEPT
    WHERE EMP.DEPTNO = DEPT.DEPTNO AND LOC = 'NEW YORK';

--3. EMP 테이블에서 보너스를 받는 사원에 대하여 이름,부서명,위치를 출력
SELECT ENAME, DNAME, LOC
    FROM EMP, DEPT
    WHERE EMP.DEPTNO = DEPT.DEPTNO AND COMM IS NOT NULL AND COMM > 0;

--4. EMP 테이블에서 이름 중 L자가 있는 사원에 대하여 이름,업무,부서명,위치를 출력
SELECT ENAME, JOB, DNAME, LOC
    FROM EMP, DEPT
    WHERE EMP.DEPTNO = DEPT.DEPTNO AND ENAME LIKE '%L%';

--5. 사번, 사원명, 부서코드, 부서명을 검색하라. 사원명기준으로 오름차순정열
SELECT EMPNO, ENAME, EMP.DEPTNO, DNAME
    FROM EMP, DEPT
    WHERE EMP.DEPTNO = DEPT.DEPTNO 
    ORDER BY ENAME;

--6. 사번, 사원명, 급여, 부서명을 검색하라. 
    --단 급여가 2000이상인 사원에 대하여 급여를 기준으로 내림차순으로 정열하시오
SELECT EMPNO, ENAME, SAL, DNAME
    FROM EMP, DEPT
    WHERE EMP.DEPTNO = DEPT.DEPTNO AND SAL >= 2000
    ORDER BY SAL DESC;

--7. 사번, 사원명, 업무, 급여, 부서명을 검색하시오. 단 업무가 MANAGER이며 급여가 2500이상인
-- 사원에 대하여 사번을 기준으로 오름차순으로 정열하시오.
SELECT EMPNO, ENAME, SAL, DNAME
    FROM EMP, DEPT
    WHERE EMP.DEPTNO = DEPT.DEPTNO AND JOB = 'MANAGER' AND SAL >=2500
    ORDER BY EMPNO;

--8. 사번, 사원명, 업무, 급여, 등급을 검색하시오. 단, 급여기준 내림차순으로 정렬하시오
SELECT EMPNO, ENAME, JOB, SAL, GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL
    ORDER BY SAL DESC;

--9. 사원테이블에서 사원명, 사원의 상사를 검색하시오(상사가 없는 직원까지 전체)
SELECT E1.ENAME, E2.ENAME "MNAME"
    FROM EMP E1, EMP E2
    WHERE E1.MGR = E2.EMPNO(+);

--10. 사원명, 상사명, 상사의 상사명을 검색하시오
SELECT E1.ENAME, E2.ENAME "MNAME", E3.ENAME "MNAME'S"
    FROM EMP E1, EMP E2, EMP E3
    WHERE E1.MGR = E2.EMPNO AND E2.MGR = E3.EMPNO;

--11. 위의 결과에서 상위 상사가 없는 모든 직원의 이름도 출력되도록 수정하시오
SELECT E1.ENAME, E2.ENAME "MNAME", E3.ENAME "MNAME'S"
    FROM EMP E1, EMP E2, EMP E3
    WHERE E1.MGR = E2.EMPNO(+) AND E2.MGR = E3.EMPNO(+);