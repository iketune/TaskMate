package com.example.taskmate.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.taskmate.bean.TaskListBean;
import com.example.taskmate.entity.TTask;

@Mapper
public interface TTaskDao {
	
	/** Tタスクテーブル一覧 取得 */
	List<TTask> selectAll();
	
	/** タスク一覧 表示 */
	List<TaskListBean> getTaskList();
}
