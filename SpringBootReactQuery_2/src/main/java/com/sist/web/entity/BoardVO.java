package com.sist.web.entity;

import java.util.Date;

public interface BoardVO {
   public int getNo();
   public String getSubject();
   public String getName();
   public String getContent();
   public String getDbday();
   public Date getHiredate();
   public int getHit();
   public int getNum();
}