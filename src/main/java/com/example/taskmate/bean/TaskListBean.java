package com.example.taskmate.bean;

import java.sql.Date;

import lombok.Data;

@Data
public class TaskListBean {

	private Integer taskId;
	private String taskName;
	private Date limitDate;
	private String statusName;
	private Integer memoCnt;

}
