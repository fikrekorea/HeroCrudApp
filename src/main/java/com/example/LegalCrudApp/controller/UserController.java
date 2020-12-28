package com.example.LegalCrudApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.LegalCrudApp.model.User;
import com.example.LegalCrudApp.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		List<User> listUser = userService.listAll();
		model.addAttribute("listUser", listUser);
		System.out.print("Get / ");
		return "index";
	}
	
	@GetMapping("/new")
	public String add(Model model) {
		model.addAttribute("user", new User());
		return "new";
	}
	
	@RequestMapping(value = "/save", method=RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User usr) {
		userService.save(usr);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditUserPage(@PathVariable(name="id") int id) {
		ModelAndView mav = new ModelAndView("new");
		User user= userService.get(id);
		mav.addObject("user", user);
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteUser(@PathVariable(name="id") int id) {
		userService.delete(id);
		return "redirect:/";
	}
}
