package com.sist.web.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
/*
 *      EMPNO int 
		ENAME text 
		JOB text 
		MGR text 
		HIREDATE text 
		SAL int 
		COMM text 
		DEPTNO int
		csv = null 이 있는 경 => text
		
		=> 면접 
		   JPA? 
		   JPA의 장단점 
		   : ... 
		   결론 => 부연 
		   static / instance => 면접관 
		
		
 */
@Entity
@Data
public class Emp {
  @Id
  private int empno;
  private int sal;
  
  @Column(insertable = false,updatable = false)
  private int deptno;
  
  private String ename,job,mgr,hiredate,comm;
  
  @ManyToOne(fetch = FetchType.EAGER) // EAGER(즉시 로딩) ,LAZE(지연)
  @JoinColumn(name="deptno",referencedColumnName = "deptno")
  private Dept dept;
}