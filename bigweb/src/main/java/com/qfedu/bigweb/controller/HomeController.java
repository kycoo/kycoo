package com.qfedu.bigweb.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.qfedu.bigweb.domain.Message;
import com.qfedu.bigweb.domain.PageModel;
import com.qfedu.bigweb.domain.User;
import com.qfedu.bigweb.service.MessageService;
import com.qfedu.bigweb.service.UserService;
import com.qfedu.bigweb.util.CommonUtil;

@Controller
public class HomeController {
	
	@Autowired
	private MessageService messageService;
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/test", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String doTest()  {
		List<User> users = userService.getAllUsers();
		return JSON.toJSONString(users);
	}
	
	@GetMapping(value = "/code", produces = "image/png")
	@ResponseBody
	public BufferedImage generateVerificationCode(HttpSession session) throws IOException {
//		resp.setContentType("image/png");
//		OutputStream output = resp.getOutputStream();
		String vc = CommonUtil.generateVC(4);
		session.setAttribute("vc", vc);
		BufferedImage vcImage = CommonUtil.getImageFromVC(vc, 120, 30);
//		ImageIO.write(vcImage, "PNG", output);
		return vcImage;
	}
	
	@GetMapping("/index")
	public String toIndex(Integer page, Integer size, Model model) {
		if (page == null) page = 1;
		if (size == null) size = 5;
		PageModel<Message> pm = messageService.getMessagesByPage(page, size);
		model.addAttribute("messageList", pm.getDataList());
		model.addAttribute("currentPage", pm.getCurrentPage());
		model.addAttribute("totalPage", pm.getTotalPage());
		return "diary";
	}
	
	@GetMapping("/toLogin")
	public String toLogin() {
		return "login";
	}
	
	@GetMapping("/toReg")
	public String toReg() {
		return "register";
	}
}
