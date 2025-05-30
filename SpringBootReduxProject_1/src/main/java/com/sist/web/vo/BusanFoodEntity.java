package com.sist.web.vo;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import lombok.Data;

/*
 * 
 * id int 
NAME text 
TYPE text 
PHONE text 
ADDRESS text 
SCORE double 
THEME text 
POSTER text 
TIME text 
PARKING text 
CONTENT text 
HIT int 
PRICE text 
IMAGES text 
LIKECOUNT int 
REPLYCOUNT int
 */
@Entity(name="busan_food")
@Data
@DynamicUpdate
public class BusanFoodEntity {
	@Id
	private int fno;
	private String name,type,phone,address,poster,images,time,parking,content,price;
	private int hit,jjimcount,likecount,replycount;
	private double scroe;
		
	}

