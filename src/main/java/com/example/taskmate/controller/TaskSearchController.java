package com.example.taskmate.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.taskmate.bean.TaskListBean;
import com.example.taskmate.service.TaskService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TaskSearchController {

	private final TaskService taskService;

	/* 最初のリクエスト */
	@GetMapping("/top")
	private String showListSelection() {
		return "task-list";
	}
	
	/* 一覧検索リクエスト */
	@PostMapping("/task-search-list")
	private String searchList(Model model) {
		List<TaskListBean> taskList = taskService.getTaskList();
		
		model.addAttribute("taskList", taskList);
		
		return "task-list";
	}
}
