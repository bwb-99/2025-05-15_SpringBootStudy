package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sist.web.vo.*;
import com.sist.web.service.*;
import java.util.*;
@Controller
public class UserController {
  @Autowired
  private UserService userService;
  
  @GetMapping("/user/list")
  public String user_list(Model model)
  {
	  Iterable<User> iter=userService.getAllUsers();
	  List<User> list=new ArrayList<User>();
	  
	  iter.forEach(list::add);
	  model.addAttribute("list", list);
	  return "user/list";
  }
  @GetMapping("/user/insert")
  public String user_insert()
  {
	  return "user/insert";
  }
  @PostMapping("/user/insert_ok")
  public String user_insert_ok(User user)
  {
	  userService.saveUser(user);
	  return "redirect:/user/list";
  }
  
}