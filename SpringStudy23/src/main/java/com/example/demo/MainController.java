package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	@Autowired
	UserDataRepository userRepository;
	@Autowired
	MessageDataRepository messageRepository;
	
	//初期画面
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView indexGet(ModelAndView mv) {
		// ユーザーの情報を全て取得
		List<UserData> customer = userRepository.findAll();
		mv.addObject("customers", customer);
		// メッセージ情報を全て取得
		List<MessageData> messageData = messageRepository.findAll();
		mv.addObject("messageDatas", messageData);
		
		mv.setViewName("index");
		mv.addObject("formModel", new MessageData());
		mv.addObject("userData", new UserData());
		System.out.println("Get動いた");
		return mv;
	}
	
//	// マイページ画面
//	@RequestMapping(value="/mypage", method = RequestMethod.GET)
//	public ModelAndView mypage(ModelAndView mv) {
//		List<UserData> customer = userRepository.findAll();
//		mv.addObject("customers", customer);
//		
//		mv.setViewName("mypage");
//		return mv;
//	}
	 
	// ユーザー登録
	@RequestMapping(value="/", method = RequestMethod.POST)
	public ModelAndView toroku(@ModelAttribute("userData") UserData userData, ModelAndView mv) {
		mv.setViewName("index");
		userRepository.saveAndFlush(userData);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/a", method = RequestMethod.POST)
	public ModelAndView indexPost(@Validated @ModelAttribute("formModel") MessageData messageData , BindingResult result,ModelAndView mv) {
		//ユーザー登録をして、マイページ画面に飛ぶ、ゆーざ情報更新削除
		// バリデーション
		mv.setViewName("index");
		if (result.hasErrors()) {
			 return mv;
		 } 
		Date dateObj = new Date();
		SimpleDateFormat format = new SimpleDateFormat( "yyyy/MM/dd HH:mm:ss" );
		// 日時情報を指定フォーマットの文字列で取得
		String display = format.format( dateObj );
		messageData.setData(display);
		// IDが１番の人を検索
		long one = 1;
		UserData user = userRepository.findById(one).get();
		// IDが1番の人をセット
		messageData.setUserData(user);
		// 保存
		messageRepository.saveAndFlush(messageData);
		System.out.println("Post動いた");
		return new ModelAndView("redirect:/");
	}
	
	//　更新
	@RequestMapping(value="/mypage/{id}", method = RequestMethod.GET)
	public ModelAndView mypage(@ModelAttribute UserData userData, ModelAndView mv,
			@PathVariable long id) {
		// ユーザーの情報を全て取得
		List<UserData> customer = userRepository.findAll();
		mv.addObject("customers", customer);
		Optional<UserData> user = userRepository.findById(id);
		mv.addObject("user", user.get());
		mv.setViewName("mypage");
		return mv;
	}
	
	@RequestMapping(value="/mypage/", method = RequestMethod.POST)
	public ModelAndView mypage(@ModelAttribute UserData userData, ModelAndView mv) {
		userRepository.saveAndFlush(userData);
		return new ModelAndView("redirect:/");
	}
	
	
	// 削除
	@RequestMapping(value="/delete/", method = RequestMethod.POST)
	public ModelAndView delete(@RequestParam("id") long id, ModelAndView mv) {
		userRepository.deleteById(id);
		return new ModelAndView("redirect:/");
	}
	
	

}
