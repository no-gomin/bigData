-- 1. 사번, 이름, 급여를 출력
select pno, pname, pay 
	from personal;
    
-- 2. 급여가 2000~5000 사이 모든 직원의 모든 필드
select * 
	from personal
    where pay between 2000 and 5000;
    
-- 3. 부서번호가 10또는 20인 사원의 사번, 이름, 부서번호
select pno, pname, dno
	from personal
    where dno in (10, 20);

-- 4. 보너스가 null인 사원의 사번, 이름, 급여 급여 큰 순정렬
select pno, pname, pay
	from personal
	where bonus is null
    order by pay desc;
    
-- 5. 사번, 이름, 부서번호, 급여. 부서코드 순 정렬 같으면 PAY 큰순
select pno, pname, dno, pay
	from personal
    order by dno, pay desc;
    
-- 6. 사번, 이름, 부서명
select pno, pname, dname
	from personal p, division d
    where p.dno = d.dno;
    
-- 7. 사번, 이름, 상사이름
select p.pno, p.pname, m.pname M_pname
	from personal p, personal m
    where p.manager = m.pno;

-- 8. 사번, 이름, 상사이름(상사가 없는 사람도 출력)
select p.pno, p.pname, m.pname M_pname
	from personal p left outer join personal m
    on p.manager = m.pno;

-- 9. 이름이 s로 시작하는 사원 이름
select pname
	from personal
    where pname like 's%';

-- 10. 사번, 이름, 급여, 부서명, 상사이름
select p.pno, p.pname, p.pay, d.dname, m.pname M_pname
	from personal p, personal m, division d
    where p.manager = m.pno and p.dno = d.dno;

-- 11. 부서코드, 급여합계, 최대급여
select dno, sum(pay), max(pay)
	from personal
    group by dno;

-- 12. 부서명, 급여평균, 인원수
select d.dname, round(avg(p.pay), 1) avg_pay, count(*) p_pax
	from personal p, division d
    where p.dno = d.dno
    group by p.dno;

-- 13. 부서코드, 급여합계, 인원수 인원수가 4명 이상인 부서만 출력
select * 
	from (select dno, sum(pay) sum_pay, count(*) p_pax
			from personal
			group by dno) A
    where A.p_pax >= 4;

-- 14. 사번, 이름, 급여 회사에서 제일 급여를 많이 받는 사람
select pno, pname, pay
	from personal
    where pay = (select max(pay) from personal);    

-- 15. 회사 평균보다 급여를 많이 받는 사람 이름, 급여, 부서번호
select pname, pay, dno
	from personal
    where pay > (select avg(pay) from personal);

-- 16. 15번에 부서명을 추가하고 부서명순 정열 같으면 급여 큰순
select dname, A.*
	from division d, (select pname, pay, dno
							from personal
							where pay > (select avg(pay) from personal)) A
	order by dname, pay desc;
                            
-- 17. 자신이 속한 부서의 평균보다 많인 받는 사람의 이름, 금여, 부서번호, 반올림한 해당부서평균
select p.pname, p.pay, p.dno, A.*
	from personal p, (select dno, round(avg(pay),1) avg_pay 
						from personal group by dno) A
	where p.dno = A.dno	and p.pay > A.avg_pay;

-- 18. 입사가 가장 빠른 사람의 이름, 급여, 부서명
select pname, pay, dname
	from personal p, division d
    where p.dno = d.dno and p.startdate = (select min(startdate) from personal);

-- 19. 이름, 급여, 해당부서평균
select p.pname, p.pay, A.avg_pay
	from personal p, (select dno, round(avg(pay), 1) avg_pay from personal group by dno) A
    where p.dno = A.dno;

-- 20. 이름, 급여, 부서명, 해당부서평균
select p.pname, p.pay, d.dname, A.avg_pay
	from personal p, division d, (select dno, round(avg(pay), 1) avg_pay from personal group by dno) A
    where p.dno = A.dno and p.dno = d.dno;


