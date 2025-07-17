package com.example.taskmate.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.taskmate.bean.TaskListBean;
import com.example.taskmate.dao.TTaskDao;
import com.example.taskmate.entity.TTask;
import com.example.taskmate.service.TaskService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

	private final TTaskDao tTaskDao;

	/** Tタスクテーブル一覧 取得 */
	@Override
	@Transactional(readOnly = true)
	public List<TTask> selectAll() {
		return tTaskDao.selectAll();
	}
	
	/** タスク一覧 表示 */	
	@Override
	@Transactional(readOnly = true)
	public List<TaskListBean> getTaskList() {
		return tTaskDao.getTaskList();
	}

}
