package com.example.taskmate.service;

import java.util.List;

import com.example.taskmate.bean.TaskListBean;
import com.example.taskmate.entity.TTask;

public interface TaskService {
	
	/** Tタスクテーブル一覧 取得 */
	List<TTask> selectAll();
	
	/** タスク一覧 表示 */
	List<TaskListBean> getTaskList();
}
