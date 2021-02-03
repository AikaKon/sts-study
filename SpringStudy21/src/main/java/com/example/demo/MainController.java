package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping("/{num}")
	public ModelAndView index(ModelAndView mv, @PathVariable int num) {
		mv.addObject("num", num);
		mv.setViewName("index");
		if (num < 2) {
			mv.addObject("boolean", false);
			return mv;
		}

		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				mv.addObject("boolean", false);
				return mv;
		     }
		}
		mv.addObject("boolean", true);
		return mv;
	}

}
