package com.example.taskmate.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.taskmate.dao.MStatusDao;
import com.example.taskmate.entity.MStatus;
import com.example.taskmate.service.StatusService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StatusServiceImpl implements StatusService {

	private final MStatusDao mStatusDao;

	/** Mステータステーブル一覧 取得 */
	@Override
	@Transactional(readOnly = true)
	public List<MStatus> selectAll() {
		return mStatusDao.selectAll();
	}
	
	/** Mステータス取得 */
	@Override
	@Transactional(readOnly = true)
	public MStatus selectByCode(String statusCode) {
		return mStatusDao.selectByCode(statusCode);
	}

}
