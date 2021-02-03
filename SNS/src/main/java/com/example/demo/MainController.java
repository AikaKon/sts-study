package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {
	@Autowired
	UserDataRepository repository;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView indexGet(ModelAndView mv) {
		List<UserData> customers = repository.findAll();
		mv.addObject("customers", customers);
		mv.setViewName("index");
		System.out.println("Get動いた");
		return mv;
	}
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public ModelAndView indexPost(ModelAndView mv, @ModelAttribute("formModel") UserData userData) {
		Date dateObj = new Date();
		SimpleDateFormat format = new SimpleDateFormat( "yyyy/MM/dd HH:mm:ss" );
		// 日時情報を指定フォーマットの文字列で取得
		String display = format.format( dateObj );
		userData.setData(display);
		repository.saveAndFlush(userData);
		System.out.println("Post動いた");
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/mypage/{id}", method = RequestMethod.GET)
	public ModelAndView mypage(@ModelAttribute UserData userData, ModelAndView mv,
			@PathVariable long id) {
		Optional<UserData> user = repository.findById(id);
		mv.addObject("user", user.get());
		mv.setViewName("mypage");
		return mv;
	}
	
	@RequestMapping(value="/mypage/", method = RequestMethod.POST)
	public ModelAndView mypage(@ModelAttribute UserData userData, ModelAndView mv) {
		Date dateObj = new Date();
		SimpleDateFormat format = new SimpleDateFormat( "yyyy/MM/dd HH:mm:ss" );
		// 日時情報を指定フォーマットの文字列で取得
		String display = format.format( dateObj );
		userData.setData(display);
		repository.saveAndFlush(userData);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/delete/", method = RequestMethod.POST)
	public ModelAndView delete(@RequestParam("id") long id, ModelAndView mv) {
		repository.deleteById(id);
		return new ModelAndView("redirect:/");
	}



}
