package com.qfedu.bigweb.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.qfedu.bigweb.domain.Message;
import com.qfedu.bigweb.domain.User;
import com.qfedu.bigweb.service.UserService;
import com.qfedu.bigweb.util.CommonUtil;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public String doLogin(String username, String password, String vc, Model model, HttpSession session) {
		String code = (String) session.getAttribute("vc");
		if (vc != null && code != null && vc.equalsIgnoreCase(code)) {
			if (userService.login(username, password)) {
				session.setAttribute("username", username);
				return "redirect:index";
			} else {
				model.addAttribute("hint", "用户名或密码错误!");
				return "login";
			}
		} else {
			model.addAttribute("hint", "请输入正确的验证码!");
			return "login";
		}
	}
	
	@PostMapping("/reg")
	public String doRegister(User user, Model model) {
		if (userService.register(user)) {
			return "redirect: toLogin";
		} else {
			model.addAttribute("hint", "注册失败请尝试不同的用户名!");
			return "register";
		}
	}
	
	@PostMapping("/pub")
	public String doPublish(@RequestParam("message") String content, MultipartFile photo, MultipartFile music, HttpServletRequest req) throws IOException {
		String photoPath = req.getServletContext().getRealPath("/images");
		String photoFilename = photo.getOriginalFilename();
		String photoSuffix = CommonUtil.getSuffix(photoFilename);
		String newPhotoFilename = CommonUtil.getMd5Filename(photo.getInputStream(), photoSuffix);
		File photoDestFile = new File(photoPath + "/" + newPhotoFilename);
		if (!photoDestFile.exists()) {
			photo.transferTo(photoDestFile);
		}
		String musicPath = req.getServletContext().getRealPath("/mp3");
		String musicFilename = music.getOriginalFilename();
		String musicSuffix = CommonUtil.getSuffix(musicFilename);
		String newMusicFilename = CommonUtil.getMd5Filename(music.getInputStream(), musicSuffix);
		File musicDestFile = new File(musicPath + "/" + newMusicFilename);
		if (!musicDestFile.exists()) {
			music.transferTo(musicDestFile);
		}
		Message message = new Message();
		message.setContent(content);
		message.setPhoto(newPhotoFilename);
		message.setMusic(newMusicFilename);
		message.setSongName(CommonUtil.getFilenameWithoutSuffix(musicFilename));
		message.setPubDate(new Date());
		User user = new User();
		user.setUsername((String) req.getSession().getAttribute("username"));
		message.setUser(user);
		userService.publishMessage(message);
		return "redirect: index";
	}
}
