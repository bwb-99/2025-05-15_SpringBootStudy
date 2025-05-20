package com.sist.web.vo;

import org.springframework.data.elasticsearch.annotations.Document;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Document(indexName = "user")
@Getter
@Setter
public class User {
   @Id
   private String id;
   private String name;
   private Integer age;
}