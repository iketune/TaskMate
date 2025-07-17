package com.example.taskmate.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.taskmate.entity.TTask;

@Controller
public class TaskSearchController {
	/* 最初のリクエスト */
	@GetMapping("/top")
	private String showListSelection() {
		return "task-list";
	}
	
	/* 一覧検索リクエスト */
	@PostMapping("/task-search-list")
	private String searchList(Model model) {
		List<TTask> taskEntityList = new ArrayList<>();
		TTask entity1 = new TTask();
		entity1.setTaskId(1);
		entity1.setTaskName("タスク1");
		entity1.setLimitDate(Date.valueOf("2025-12-22"));
		entity1.setStatusCode("00");
		entity1.setRemarks("テストentity1");
		taskEntityList.add(entity1);
		TTask entity2 = new TTask();
		entity2.setTaskId(2);
		entity2.setTaskName("タスク2");
		entity2.setLimitDate(Date.valueOf("2025-12-23"));
		entity2.setStatusCode("05");
		entity2.setRemarks("テストentity2");
		taskEntityList.add(entity2);
		
		model.addAttribute("taskEntityList", taskEntityList);
		
		return "task-list";
	}
}
