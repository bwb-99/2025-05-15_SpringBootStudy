package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.entity.*;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeEntity, Integer> {

    // 페이지네이션 레시피 목록
    @Query(value = "SELECT no, poster, chef, hit, likecount, num, title FROM ( " +
            "SELECT r.no, r.poster, r.chef, r.hit, r.likecount, r.title, " +
            "ROW_NUMBER() OVER (ORDER BY r.no ASC) AS num " +
            "FROM recipe r " +
            "INNER JOIN recipeDetail rd ON r.no = rd.no " +
            ") AS sub " +
            "WHERE num BETWEEN :start AND :end", nativeQuery = true)
    public List<RecipeVO> recipeListData(@Param("start") Integer start,
                                         @Param("end") Integer end);

    // 상세보기
    public RecipeEntity findByNo(int no);

    // 전체 페이지 수 계산
    @Query(value = "SELECT CEIL(COUNT(*)/12.0) FROM recipe r " +
            "INNER JOIN recipeDetail rd ON r.no = rd.no", nativeQuery = true)
    public int recipeTotalPage();

    // 검색 기반 레시피 목록
    @Query(value = "SELECT no, poster, chef, hit, likecount, num, title FROM ( " +
            "SELECT r.no, r.poster, r.chef, r.hit, r.likecount, r.title, " +
            "ROW_NUMBER() OVER (ORDER BY r.no ASC) AS num " +
            "FROM recipe r " +
            "INNER JOIN recipeDetail rd ON r.no = rd.no " +
            "WHERE r.title LIKE CONCAT('%', :title, '%') " +
            ") AS sub " +
            "WHERE num BETWEEN :start AND :end", nativeQuery = true)
    public List<RecipeVO> recipeFindData(@Param("start") Integer start,
                                         @Param("end") Integer end,
                                         @Param("title") String title);

    // 검색 기반 페이지 수 계산
    @Query(value = "SELECT CEIL(COUNT(*)/12.0) FROM recipe r " +
            "INNER JOIN recipeDetail rd ON r.no = rd.no " +
            "WHERE r.title LIKE CONCAT('%', :title, '%')", nativeQuery = true)
    public int recipeFindTotalPage(@Param("title") String title);
}
