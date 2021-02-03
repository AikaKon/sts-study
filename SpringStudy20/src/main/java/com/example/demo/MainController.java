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
			@RequestParam(value="status1", defaultValue = "0") int status1,
			@RequestParam(value="status2", defaultValue = "0") int status2,
			@RequestParam(value="status3", defaultValue = "0") int status3,
			@RequestParam(value="selectedItem") double selectedItem) {
		
		System.out.println(status1);
		System.out.println(status2);
		System.out.println(status3);
		if(type.equals("中古")) {
			selectedItem *= 0.7;
			selectedItem = selectedItem - status1 - status2 - status3;
		}
		// テンプレートを指定
		mv.setViewName("result");
		
		// modelに設定して画面に表示するようにする
		mv.addObject("type", type);
		mv.addObject("status1", status1);
		mv.addObject("status2", status2);
		mv.addObject("status3", status3);
		mv.addObject("selectedItem", (int)selectedItem);
		// 返却
		return mv;
	}
	
	//※htmlの値を取得したい、value複数取得したい、複数あった場合の計算もしたい
	
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

