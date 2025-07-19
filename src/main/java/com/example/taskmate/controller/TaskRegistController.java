package com.example.taskmate.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.taskmate.entity.MStatus;
import com.example.taskmate.form.TaskRegistForm;
import com.example.taskmate.service.StatusService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TaskRegistController {

	private final StatusService statusService;

	/** タスク登録画面表示リクエスト */
	@PostMapping("/task-show-regist")
	public String showRegist(@ModelAttribute TaskRegistForm form, Model model) {
		//ステータスリストを取得し Model に設定
		List<MStatus> mStatusList = statusService.selectAll();
		model.addAttribute("mStatusList", mStatusList);
		//登録画面へ
		return "task-regist";
	}

	/** タスク登録リクエスト */
	@PostMapping("/task-regist")
	public String regist(@Validated @ModelAttribute TaskRegistForm form,
						BindingResult result, Model model) {
		//入力エラーがある場合は タスク登録画面に遷移
		if(result.hasErrors()) {
			//ステータスリストを取得し Model に設定
			List<MStatus> mStatusList = statusService.selectAll();
			model.addAttribute("mStatusList", mStatusList);
			//登録画面へ
			return "task-regist";
		}
		//ステータス名を form に設定 （Model内）
		MStatus status = statusService.selectByCode(form.getStatusCode());
		form.setStatusName(status.getStatusName());
		//正常の場合は タスク登録確認画面に遷移
		return "task-confirm-regist";
	}
	
	/** タスク登録リクエスト */	
	@PostMapping("/task-confirm-regist")
	public String confirmRegist(@Validated @ModelAttribute TaskRegistForm form,
						BindingResult result, RedirectAttributes redirectAttributes,
						Model model) {
		//入力エラーがある場合は タスク登録画面に遷移
		if(result.hasErrors()) {
			//ステータスリストを取得し Model に設定
			List<MStatus> mStatusList = statusService.selectAll();
			model.addAttribute("mStatusList", mStatusList);
			//登録画面へ
			return "task-regist";
		}
		//とりあえず書き出し
		System.out.println("--登録form");
		System.out.println(form);
		
		//ここで登録処理の呼び出し
		
		//フラッシュスコープに完了メッセージを表示して リダイレクト
		redirectAttributes.addFlashAttribute("msg", "（タスク登録）");
		
		//正常の場合は タスク登録確認画面に遷移
		return "redirect:/task-complete";
	}
}
