package com.sist.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.*;

/*
 *     interface ===== interface 
 *               extends
 *     interface ====== class
 *               implements
 *               
 *      no int 
		CNO int 
		TITLE text 
		POSTER text 
		ADDRESS text 
		PHONE text 
		INFO text
 */
@Repository
public interface BusanInfoRepostory extends JpaRepository<BusanInfoEntity, Integer>{
	@Query(value = 
		    "SELECT no, poster, title, num " +
		    "FROM ( " +
		    "    SELECT bi.no, bi.poster, bi.title, " +
		    "           ROW_NUMBER() OVER (ORDER BY bi.no ASC) AS num " +
		    "    FROM busan_info bi " +
		    ") AS sub " +
		    "WHERE sub.num BETWEEN :start AND :end",
		    nativeQuery = true
		)
		public List<BusanInfoVO> busanInfoListData(
		        @Param("start") Integer start,
		        @Param("end")   Integer end);
 
     public BusanInfoEntity findByNo(int no); 
}