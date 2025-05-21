package com.sist.web.controller;
// 서버 => 클라이언트 통신
/*
 * 	서버 = 클라이언트와 동일한 언어
 * 	-------------- 언어가 다른 경우 파이썬 == 장고 , 스프링 
 * 
 */
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.service.*;
import com.sist.web.entity.*;
@RestController
public class BusanInfoRestController {
	@Autowired
	private BusanInfoService bService;
	
	@GetMapping("/main_react")
	public Map main_react()
	{
		List<BusanInfoEntity> list1=bService.getBusanInfoData(1);
		List<BusanInfoEntity> list2=bService.getBusanInfoData(2);
		List<BusanInfoEntity> list3=bService.getBusanInfoData(3);
		
		Map map=new HashMap();
		map.put("list1",list1);
		map.put("list1",list2);
		map.put("list1",list3);
		
		return map;
	}
	
	@GetMapping("/info/list_react")
	public Map info_list(int page)
	{
		List<BusanInfoEntity> list=bService.getBusanInfoAll(page);
		int[] data=bService.getPageDatas(page);
		Map map=new HashMap();
		map.put("list", list);
		map.put("page",data);
		
		return map;
 	}
}
