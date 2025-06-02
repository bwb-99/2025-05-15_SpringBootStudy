package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.entity.*;
@Repository
public interface RecipeRepository extends JpaRepository<RecipeEntity, Integer>{
	@Query(value = "SELECT no, poster, chef, hit, likecount, num, title FROM ( " +
	        "SELECT r.no, r.poster, r.chef, r.hit, r.likecount, r.title, " +
	        "ROW_NUMBER() OVER (ORDER BY r.no ASC) AS num " +
	        "FROM recipe r " +
	        "WHERE r.no IN (SELECT DISTINCT rd.no FROM recipeDetail rd) " +
	        ") AS sub " +
	        "WHERE num BETWEEN :start AND :end", nativeQuery = true)
	public List<RecipeVO> recipeListData(@Param("start") Integer start,
	                                     @Param("end") Integer end);

   
   public RecipeEntity findByNo(int no);
   
   @Query(value="SELECT CEIL(COUNT(*)/12.0) FROM recipe "
		 +"WHERE no IN (SELECT DISTINCT no FROM recipeDetail)",nativeQuery = true)
   public int recipeTotalPage();
   // Find 
   // Chef 
   // Chef의 recipe목록 
   // CRUD 
}