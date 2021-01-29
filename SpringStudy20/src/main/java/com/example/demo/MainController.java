package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping(value = "/")
	public ModelAndView index(ModelAndView mv) {
		// テンプレートを指定
		mv.setViewName("index");
		// 返却
		return mv;
	}
	
	// POST用のパラメータを受け取る
	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public ModelAndView postTest1(ModelAndView mv,
			@RequestParam(value="type") String type,
			@RequestParam(value="status", required = false) String status,
			@RequestParam(value="selectedItem") double selectedItem) {
		
		if(type.equals("中古")) {
			selectedItem *= 0.7;
//			selectedItem -= status;
		}
		// テンプレートを指定
		mv.setViewName("result");
		
		// modelに設定して画面に表示するようにする
		mv.addObject("type", type);
		mv.addObject("status", status);
		mv.addObject("selectedItem", selectedItem);
		System.out.println(status);
		// 返却
		return mv;
	}
	
//	// GET用のパラメータを受け取る
//	@RequestMapping(value = {"/result"}, method = {RequestMethod.GET})
//	public ModelAndView getTest1(ModelAndView mv,
//			@RequestParam(value="type") String type,
//			@RequestParam(value="status",required = false) String status,
//			@RequestParam(value="selectedItem") String selectedItem) {
//		// テンプレートを指定
//		mv.setViewName("result");
//		
//		// modelに設定して画面に表示するようにする
//		mv.addObject("type", type);
//		mv.addObject("status", status);
//		mv.addObject("selectedItem", selectedItem);
//		
//		// 返却
//		return mv;
//	}
	
}

