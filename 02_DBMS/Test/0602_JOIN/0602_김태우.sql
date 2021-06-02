-- �� <��������> PART1

--1. �̸�, ���ӻ��
SELECT E1.ENAME "ENAME", E2.ENAME "MNAME"
    FROM EMP E1, EMP E2
    WHERE E1.MGR = E2.EMPNO;

--2. �̸�, �޿�, ����, ���ӻ��
SELECT E1.ENAME "ENAME", E1.SAL, E1.JOB, E2.ENAME "MNAME"
    FROM EMP E1, EMP E2
    WHERE E1.MGR = E2.EMPNO;

--3. �̸�, �޿�, ����, ���ӻ��. (��簡 ���� �������� ��ü ���� �� ���.
    --��簡 ���� �� '����'���� ���)
SELECT E1.ENAME "ENAME", E1.SAL, E1.JOB, NVL(E2.ENAME, '����') "MNAME"
    FROM EMP E1, EMP E2
    WHERE E1.MGR = E2.EMPNO(+);

--4. �̸�, �޿�, �μ���, ���ӻ���
SELECT E1.ENAME "ENAME", E1.SAL, DNAME, E2.ENAME "MNAME"
    FROM EMP E1, EMP E2, DEPT
    WHERE E1.MGR = E2.EMPNO AND E1.DEPTNO = DEPT.DEPTNO;

--5. �̸�, �޿�, �μ��ڵ�, �μ���, �ٹ���, ���ӻ���, (��簡 ���� �������� ��ü ���� �� ���)
SELECT E1.ENAME "ENAME", E1.SAL, E1.DEPTNO, DNAME, LOC, E2.ENAME "MNAME"
    FROM EMP E1, EMP E2, DEPT
    WHERE E1.MGR = E2.EMPNO(+) AND E1.DEPTNO = DEPT.DEPTNO;
    
--6. �̸�, �޿�, ���, �μ���, ���ӻ���. �޿��� 2000�̻��� ���
SELECT E1.ENAME "ENAME", E1.SAL, GRADE, DNAME, E2.ENAME "MNAME"
    FROM EMP E1, EMP E2, DEPT, SALGRADE
    WHERE E1.MGR = E2.EMPNO AND E1.DEPTNO = DEPT.DEPTNO 
        AND E1.SAL BETWEEN LOSAL AND HISAL AND E1.SAL >= 2000;

--7. �̸�, �޿�, ���, �μ���, ���ӻ���, (���ӻ�簡 ���� �������� ��ü���� �μ��� �� ����)
SELECT E1.ENAME "ENAME", E1.SAL, GRADE, DNAME, E2.ENAME "MNAME"
    FROM EMP E1, EMP E2, DEPT, SALGRADE
    WHERE E1.MGR = E2.EMPNO(+) AND E1.DEPTNO = DEPT.DEPTNO
        AND E1.SAL BETWEEN LOSAL AND HISAL;

--8. �̸�, �޿�, ���, �μ���, ����, ���ӻ���. ����=(�޿�+comm)*12 �� comm�� null�̸� 0
SELECT E1.ENAME, E1.SAL, GRADE, DNAME, (E1.SAL+NVL(E1.COMM,0))*12 "ANNUAL_SAL",  E2.ENAME "MNAME"
    FROM EMP E1, EMP E2, DEPT, SALGRADE
    WHERE E1.MGR = E2.EMPNO AND E1.DEPTNO = DEPT.DEPTNO 
        AND E1.SAL BETWEEN LOSAL AND HISAL;

--9. 8���� �μ��� �� �μ��� ������ �޿��� ū �� ����
SELECT E1.ENAME, E1.SAL, GRADE, DNAME, (E1.SAL+NVL(E1.COMM,0))*12 "ANNUAL_SAL",  E2.ENAME "MNAME"
    FROM EMP E1, EMP E2, DEPT, SALGRADE
    WHERE E1.MGR = E2.EMPNO AND E1.DEPTNO = DEPT.DEPTNO 
        AND E1.SAL BETWEEN LOSAL AND HISAL
    ORDER BY DNAME, ANNUAL_SAL DESC;






--  PART2


--1.EMP ���̺��� ��� ����� ���� �̸�,�μ���ȣ,�μ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT ENAME, EMP.DEPTNO, DNAME
    FROM EMP, DEPT
    WHERE EMP.DEPTNO = DEPT.DEPTNO;

--2. EMP ���̺��� NEW YORK���� �ٹ��ϰ� �ִ� ����� ���Ͽ� �̸�,����,�޿�,�μ����� ���
SELECT ENAME, JOB, SAL, DNAME
    FROM EMP, DEPT
    WHERE EMP.DEPTNO = DEPT.DEPTNO AND LOC = 'NEW YORK';

--3. EMP ���̺��� ���ʽ��� �޴� ����� ���Ͽ� �̸�,�μ���,��ġ�� ���
SELECT ENAME, DNAME, LOC
    FROM EMP, DEPT
    WHERE EMP.DEPTNO = DEPT.DEPTNO AND COMM IS NOT NULL AND COMM > 0;

--4. EMP ���̺��� �̸� �� L�ڰ� �ִ� ����� ���Ͽ� �̸�,����,�μ���,��ġ�� ���
SELECT ENAME, JOB, DNAME, LOC
    FROM EMP, DEPT
    WHERE EMP.DEPTNO = DEPT.DEPTNO AND ENAME LIKE '%L%';

--5. ���, �����, �μ��ڵ�, �μ����� �˻��϶�. ������������ ������������
SELECT EMPNO, ENAME, EMP.DEPTNO, DNAME
    FROM EMP, DEPT
    WHERE EMP.DEPTNO = DEPT.DEPTNO 
    ORDER BY ENAME;

--6. ���, �����, �޿�, �μ����� �˻��϶�. 
    --�� �޿��� 2000�̻��� ����� ���Ͽ� �޿��� �������� ������������ �����Ͻÿ�
SELECT EMPNO, ENAME, SAL, DNAME
    FROM EMP, DEPT
    WHERE EMP.DEPTNO = DEPT.DEPTNO AND SAL >= 2000
    ORDER BY SAL DESC;

--7. ���, �����, ����, �޿�, �μ����� �˻��Ͻÿ�. �� ������ MANAGER�̸� �޿��� 2500�̻���
-- ����� ���Ͽ� ����� �������� ������������ �����Ͻÿ�.
SELECT EMPNO, ENAME, SAL, DNAME
    FROM EMP, DEPT
    WHERE EMP.DEPTNO = DEPT.DEPTNO AND JOB = 'MANAGER' AND SAL >=2500
    ORDER BY EMPNO;

--8. ���, �����, ����, �޿�, ����� �˻��Ͻÿ�. ��, �޿����� ������������ �����Ͻÿ�
SELECT EMPNO, ENAME, JOB, SAL, GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL
    ORDER BY SAL DESC;

--9. ������̺��� �����, ����� ��縦 �˻��Ͻÿ�(��簡 ���� �������� ��ü)
SELECT E1.ENAME, E2.ENAME "MNAME"
    FROM EMP E1, EMP E2
    WHERE E1.MGR = E2.EMPNO(+);

--10. �����, ����, ����� ������ �˻��Ͻÿ�
SELECT E1.ENAME, E2.ENAME "MNAME", E3.ENAME "MNAME'S"
    FROM EMP E1, EMP E2, EMP E3
    WHERE E1.MGR = E2.EMPNO AND E2.MGR = E3.EMPNO;

--11. ���� ������� ���� ��簡 ���� ��� ������ �̸��� ��µǵ��� �����Ͻÿ�
SELECT E1.ENAME, E2.ENAME "MNAME", E3.ENAME "MNAME'S"
    FROM EMP E1, EMP E2, EMP E3
    WHERE E1.MGR = E2.EMPNO(+) AND E2.MGR = E3.EMPNO(+);