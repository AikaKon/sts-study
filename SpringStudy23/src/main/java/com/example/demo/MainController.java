package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	@Autowired
	UserDataRepository repository;
	@Autowired
	MessageDataRepository messageRepository;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView indexGet(ModelAndView mv) {
		List<UserData> customers1 = repository.findAll();
		mv.addObject("customers1", customers1);
		mv.setViewName("index");
		mv.addObject("formModel", new MessageData());
		System.out.println("Get動いた");
		return mv;
	}
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public ModelAndView indexPost(@Validated @ModelAttribute("formModel") UserData userData , BindingResult result, ModelAndView mv) {
		 Date dateObj = new Date();
		 SimpleDateFormat format = new SimpleDateFormat( "yyyy/MM/dd HH:mm:ss" );
		 // 日時情報を指定フォーマットの文字列で取得
		 String display = format.format( dateObj );
		 userData.setData(display);
		 mv.setViewName("index");
		 if (result.hasErrors()) {
			 return mv;
		 }
		 // 保存
		 repository.saveAndFlush(userData);
		
		 System.out.println("Post動いた");
		 return new ModelAndView("redirect:/");
	}
	
	

}
