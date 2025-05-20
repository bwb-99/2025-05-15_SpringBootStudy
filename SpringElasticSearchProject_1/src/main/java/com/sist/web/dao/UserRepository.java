package com.sist.web.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.sist.web.vo.*;
public interface UserRepository extends ElasticsearchRepository<User,String>{
  
}