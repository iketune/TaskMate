package com.example.taskmate.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.taskmate.entity.MStatus;

public interface StatusService {
	
	/** Mステータステーブル一覧 取得 */
	List<MStatus> selectAll();
	
	/** Mステータス取得 */
	MStatus selectByCode(@Param("statusCode") String statusCode);
}
