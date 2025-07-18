package com.example.taskmate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.taskmate.form.TaskRegistForm;

@Controller
public class TaskRegistController {

	/** タスク登録画面表示リクエスト */
	@PostMapping("/task-show-regist")
	public String showRegist(@ModelAttribute TaskRegistForm form) {
		return "task-regist";
	}

	/** タスク登録リクエスト */
	@PostMapping("/task-regist")
	public String regist(@Validated @ModelAttribute TaskRegistForm form,
						BindingResult result) {
		//入力エラーがある場合は タスク登録画面に遷移
		if(result.hasErrors()) {
			return "task-regist";
		}
		//正常の場合は タスク登録確認画面に遷移
		return "task-confirm-regist";
	}
	
	/** タスク登録リクエスト */
	@PostMapping("/task-confirm-regist")
	public String confirmRegist(@Validated @ModelAttribute TaskRegistForm form,
						BindingResult result, RedirectAttributes redirectAttributes) {
		//入力エラーがある場合は タスク登録画面に遷移
		if(result.hasErrors()) {
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
