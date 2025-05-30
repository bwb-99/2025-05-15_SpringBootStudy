package com.sist.web.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.vo.*;
import com.sist.web.dao.*;
@RestController
@CrossOrigin(origins = "*")
// port => 전화선
public class BusanFoodRestController {
	@Autowired
	private BusanFoodRepository bDao;
	
	@GetMapping("/food/list_react")
	public Map food_list(@RequestParam("page") int page)
	{
		int rowSize=12;
		int start=(rowSize*page)-rowSize;
		//Limit => 0번 시작
		List<BusanFoodVO> list=bDao.busanListData(start);
		int count=(int)bDao.count();
		
		Map map=new HashMap();
		map.put("list", map);
		map.put("curpage", page);
		map.put("total", rowSize);
		
		
	}

}
