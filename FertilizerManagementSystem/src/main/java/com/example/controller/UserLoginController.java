package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Feedback;
import com.example.entity.OrderNow;
import com.example.entity.User;
import com.example.serviceimpl.FeedbackServiceimpl;
import com.example.serviceimpl.OrderServiceimpl;
import com.example.serviceimpl.UserServiceImpl;

@Controller
public class UserLoginController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@Autowired
	private FeedbackServiceimpl feddFeedbackServiceimpl;

	@Autowired
	private OrderServiceimpl orderServiceimpl;

	@PostMapping("/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model) {
		User user = userServiceImpl.findUserByUsername(username, password);
		if (user != null) {
			return "redirect:home";
		} else {
			return "redirect:login2";
		}
	}

	@PostMapping("/saveUser")
	public String saveUser(User user, Model model) {
		System.out.println("Step 1..");
		userServiceImpl.saveUser(user);
		model.addAttribute("message", "User saved successfully!");
		return "redirect:/successPage";
	}

	@PostMapping("/savefeedback")
	public String savefeedback(Feedback feedback, Model model) {
		this.feddFeedbackServiceimpl.saveFeedback(feedback);
		model.addAttribute("message", "User saved successfully!");
		return "redirect:/successfedbk";
	}

	@PostMapping("/saveorder")
	public String saveorder(OrderNow order, Model model) {
		this.orderServiceimpl.saveOrder(order);
		model.addAttribute("message", "User saved successfully!");
		return "redirect:/successfedbk";
	}

	@RequestMapping("/successPage")
	public String successPage() {
		return "successPage";
	}

	@RequestMapping("/successfedbk")
	public String successfedbk() {
		return "successfedbk";
	}

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/login2")
	public String Login2() {
		return "login2";
	}

}
