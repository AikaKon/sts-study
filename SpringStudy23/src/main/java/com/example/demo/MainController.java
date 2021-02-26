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
		List<UserData> customer = repository.findAll();
		mv.addObject("customer", customer);
//		List<MessageData> message = messageRepository.findAll();
//		mv.addObject("message", message);
		mv.setViewName("index");
//		mv.addObject("formModel", new MessageData());
		mv.addObject("User", new UserData());
		System.out.println("Get動いた");
		return mv;
	}
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public ModelAndView indexPost(@ModelAttribute("User") UserData userData, ModelAndView mv) {
//		 @Validated @ModelAttribute("formModel") MessageData messageData , BindingResult result,
		mv.setViewName("index");
//		if (result.hasErrors()) {
//			 return mv;
//		 } 
		Date dateObj = new Date();
		SimpleDateFormat format = new SimpleDateFormat( "yyyy/MM/dd HH:mm:ss" );
		// 日時情報を指定フォーマットの文字列で取得
		String display = format.format( dateObj );
//		messageData.setData(display);
		 
		// 保存
		repository.saveAndFlush(userData);
//		messageRepository.saveAndFlush(messageData);

		System.out.println("Post動いた");
		return new ModelAndView("redirect:/");
	}
	
	

}
