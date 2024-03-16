package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Admin;
import com.example.entity.Feedback;
import com.example.entity.OrderNow;
import com.example.entity.User;
import com.example.serviceimpl.AdminServiceImpl;
import com.example.serviceimpl.FeedbackServiceimpl;
import com.example.serviceimpl.OrderServiceimpl;
import com.example.serviceimpl.UserServiceImpl;

@Controller
public class Admincontroller {

	@Autowired
	private AdminServiceImpl adminServiceImpl;

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private FeedbackServiceimpl feedbackServiceimpl;
	
	@Autowired
	private OrderServiceimpl orderServiceimpl;
	
	@PostMapping("/adminlogin")
	public String Adminlogin(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model) {
		Admin admin = this.adminServiceImpl.findUserByUsername(username, password);
		if (admin != null) {
			return "redirect:adminhome";
		} else {
			return "redirect:adminlogin2";
		}
	}

	@PostMapping("/saveAdmin")
	public String saveAdmin(Admin admin, Model model) {
		adminServiceImpl.saveUser(admin);
		model.addAttribute("message", "Admin saved successfully!");
		return "redirect:/successPage"; 
	}

	@GetMapping("/adminhome")
	public String adminhome() {
		return "adminhome";
	}

	@GetMapping("/adminlogin2")
	public String adminLogin() {

		return "adminlogin2";
	}

	@GetMapping("/user")
	public String showUsers(Model model) {
		List<User> users = new ArrayList<>();
		users = this.userServiceImpl.getAllUsers();
		model.addAttribute("userlist", users);
		return "userlist";
	}

	@GetMapping("/feedback")
	public String showFeedback(Model model) {
		List<Feedback> feedbacks = new ArrayList<>();
		feedbacks = this.feedbackServiceimpl.getAllFeedbacks();
		model.addAttribute("feedbacklist", feedbacks);
		return "feedbacklist";
	}
	@GetMapping("/orders")
	public String showorders(Model model) {
		List<OrderNow> orders = new ArrayList<>();
		orders = this.orderServiceimpl.getAllOrder();
		model.addAttribute("orderslist", orders);
		return "orderslist";
	}

}
