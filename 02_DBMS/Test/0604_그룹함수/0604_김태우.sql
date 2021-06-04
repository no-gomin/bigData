-- ��<�� ��������>

-- 1. ��� ���̺��� �ο���,�ִ� �޿�,�ּ� �޿�,�޿��� ���� ����Ͽ� ���
SELECT COUNT(*) MEMBERS, MAX(SAL), MIN(SAL), SUM(SAL)
    FROM EMP;

-- 2. ������̺��� ������ �ο����� ���Ͽ� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT JOB, COUNT(*) MEMBERS
    FROM EMP
    GROUP BY JOB;

--- 3. ������̺��� �ְ� �޿��� �ּ� �޿��� ���̴� ���ΰ� ����ϴ� SELECT������ �ۼ��Ͽ���.
SELECT MAX(SAL) - MIN(SAL) DIFFERENT
    FROM EMP;

-- 4. �� �μ����� �ο���, �޿� ���, ���� �޿�, �ְ� �޿�, �޿��� ���� ����ϵ� �޿��� ���� ���� ������ ����϶�.
SELECT DEPTNO, COUNT(*) MEMBERS, ROUND(AVG(SAL),2) "AVG(SAL)", MIN(SAL), MAX(SAL), SUM(SAL)
    FROM EMP
    GROUP BY DEPTNO
    ORDER BY SUM(SAL) DESC;

-- 5. �μ���, ������ �׷��Ͽ� ����� �μ���ȣ, ����, �ο���, �޿��� ���, �޿��� ���� 
    --���Ͽ� ����϶�(��°���� �μ���ȣ, ���������� �������� ����)
SELECT DEPTNO, JOB, COUNT(*) MEMBERS, ROUND(AVG(SAL),2) "AVG(SAL)", SUM(SAL)
    FROM EMP
    GROUP BY DEPTNO, JOB
    ORDER BY DEPTNO, JOB;    

-- 6. ������, �μ��� �׷��Ͽ� �����  ����, �μ���ȣ, �ο���, �޿��� ���, �޿��� ���� ���Ͽ� 
-- ����϶�.(��°���� ������, �μ���ȣ �� �������� ����)
SELECT JOB, DEPTNO, COUNT(*) MEMBERS, ROUND(AVG(SAL),2), SUM(SAL)
    FROM EMP
    GROUP BY JOB, DEPTNO
    ORDER BY JOB, DEPTNO;

--7. ������� 5���̻� �Ѵ� �μ���ȣ�� ������� ����Ͻÿ�.
SELECT DEPTNO, COUNT(*) MEMBERS
    FROM EMP
    GROUP BY DEPTNO
    HAVING COUNT(*) >= 5;
    
-- 8. ������� 5���̻� �Ѵ� �μ���� ������� ����Ͻÿ�
SELECT DNAME, COUNT(*) MEMBERS
    FROM EMP, DEPT
    WHERE EMP.DEPTNO = DEPT.DEPTNO
    GROUP BY DNAME
    HAVING COUNT(*) >= 5;

--9. ��� ���̺��� ������ �޿��� ����� 3000�̻��� ������ ���ؼ� ������, ��� �޿�, 
--�޿��� ���� ���Ͽ� ����϶�
SELECT JOB, ROUND(AVG(SAL), 2) "AVG(SAL)", SUM(SAL)
    FROM EMP
    GROUP BY JOB
    HAVING AVG(SAL) >= 3000;

--10. ������̺��� �޿����� 5000�� �ʰ��ϴ� �� ������ ���ؼ� ������ �޿��հ踦 ����϶� 
        --��, �޿� �հ�� �������� �����϶�.
SELECT JOB, SUM(SAL)
    FROM EMP
    GROUP BY JOB
    HAVING SUM(SAL) > 5000
    ORDER BY SUM(SAL) DESC;

--11. �μ��� �޿����, �μ��� �޿��հ�, �μ��� �ּұ޿��� ����϶�.
SELECT DEPTNO, ROUND(AVG(SAL), 2) "AVG(SAL)", SUM(SAL), MIN(SAL)
    FROM EMP
    GROUP BY DEPTNO;

--12. ���� 11���� �����Ͽ�, �μ��� �޿���� �ִ�ġ, �μ��� �޿����� �ִ�ġ,
            --�μ��� �ּұ޿��� �ִ�ġ�� ����϶�.
SELECT  MAX(ROUND(AVG(SAL), 2)) "AVG(SAL)", MAX(SUM(SAL)), MAX(MIN(SAL))
    FROM EMP
    GROUP BY DEPTNO;
    


--13. ��� ���̺��� �Ʒ��� ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.(�⵵�� ������)
--   H_YEAR	COUNT(*)	MIN(SAL)	MAX(SAL)	AVG(SAL)	SUM(SAL)
--     80	  1		    800		    800		    800		    800
--	81	 10		    950		    5000	    2282.5	  22825
--	82	  2		    1300	    3000	   2150		   4300
--	83	  1		    1100	    1100	    1100	   1100
SELECT TO_CHAR(HIREDATE, 'RR') "H_YEAR", COUNT(*), MIN(SAL), MAX(SAL), AVG(SAL), SUM(SAL)
    FROM EMP
    GROUP BY TO_CHAR(HIREDATE, 'RR')
    ORDER BY TO_CHAR(HIREDATE, 'RR');

-- 14.  ������̺��� �Ʒ��� ����� ����ϴ� SELECT �� �ۼ�
--  1980     1	
--  1981     10
--  1982     2
--  1983     1
--  total    14	
SELECT NVL(TO_CHAR(HIREDATE, 'YYYY'), 'total') "H_YEAR", COUNT(*)
    FROM EMP
    GROUP BY ROLLUP(TO_CHAR(HIREDATE, 'YYYY'))
    ORDER BY TO_CHAR(HIREDATE, 'YYYY');

--15. ������̺��� �ִ�޿�, �ּұ޿�, ��ü�޿���, ����� ���Ͻÿ�
SELECT MAX(SAL), MIN(SAL), SUM(SAL), ROUND(AVG(SAL), 2)
    FROM EMP;

--16. ������̺��� �μ��� �ο����� ���Ͻÿ�
SELECT DEPTNO, COUNT(*)
    FROM EMP
    GROUP BY DEPTNO;

--17. ��� ���̺��� �μ��� �ο����� 6���̻��� �μ��ڵ带 ���Ͻÿ�
SELECT DEPTNO
    FROM EMP
    GROUP BY DEPTNO
    HAVING COUNT(DEPTNO) >= 6;

--18. ������̺��� �޿��� ���� ������� ����� �ο��Ͽ� ������ ���� ����� ������ �Ͻÿ�. 
-- (��Ʈ self join, group by, count���)
--ENAME	    ���
--________________________
--KING		1
--SCOTT		2
--����
SELECT E1.ENAME "ENAME", COUNT(E2.ENAME) "���"
    FROM EMP E1, EMP E2
    WHERE E1.SAL <= E2.SAL
    GROUP BY E1.ENAME
    ORDER BY SUM(E2.SAL);