package com.sist.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sist.web.dao.*;
import com.sist.web.vo.*;
@Service
public class UserService {
   @Autowired
   private UserRepository userRepository;
   
   public void saveUser(User user)
   {
	   userRepository.save(user);
   }
   public void deleteUser(User user)
   {
	   userRepository.delete(user);
   }
   public Iterable<User> getAllUsers()
   {
	   return userRepository.findAll();
   }
   public User getUserId(String id)
   {
	   return userRepository.findById(id).orElse(null);
   }
}