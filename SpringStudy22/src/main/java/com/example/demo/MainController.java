package com.example.demo;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	@RequestMapping(value="/")
	public ModelAndView indexPost(ModelAndView mv) {
		ArrayList<String[]> customers = new ArrayList<String[]>();
		customers.add(new String[] {"佐藤HTML太郎","35歳","男性"});
		customers.add(new String[] {"鈴木Java吾郎","24歳","男性"});
		customers.add(new String[] {"高橋CSS子","25歳","女性"});
		mv.addObject("customers", customers);
		mv.setViewName("index");
		System.out.println(customers.get(0));
		System.out.println(customers.get(0)[0]);
		return mv;
	}
	@RequestMapping(value="/a")
	public ModelAndView indexPost2(ModelAndView mv) {
		ArrayList<String[]> customers = new ArrayList<String[]>();
		customers.add(new String[] {"アイウエオ","🐈","🐶"});
		customers.add(new String[] {"アイウエオ","🐈","🐶"});
		customers.add(new String[] {"アイウエオ","🐈","🐶"});
		mv.addObject("customers", customers);
		mv.setViewName("index");
		System.out.println(customers.get(0));
		System.out.println(customers.get(0)[0]);
		return mv;
	}

}
