package com.example.demo.hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.hello.domain.User;
import com.example.demo.hello.dto.UserForm;
import com.example.demo.hello.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

@Controller
public class UserController {
	
	private UserService service;

	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}
	
	@GetMapping("/users/new")
	public String createForm() {
		return "users/createUserForm";
	}
	
	@PostMapping("/users/new")
	public String create(UserForm form) {
		User user = new User();
		user.setName(form.getName());
		user.setPassword(form.getPassword());
		user.setId(form.getId());
		
		System.out.println("create user : " + user.getName());
		
		service.join(user);
		
		return "redirect:/";
		
	}
	
	@GetMapping("/users")
	public String list(Model model) {
		List<User> users = service.findUsers();
		model.addAttribute("users", users);
		return "users/userList";
	}
	
	@GetMapping("/users/login")
	public String loginForm() {
		return "users/loginForm";
	}
	
	@GetMapping("/users/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.invalidate();
		}
		return "redirect:/";
	}
	
    @GetMapping("/status")
    public ResponseEntity<String> serverStatusCheck() {
        return ResponseEntity.ok("ok");
    }
    

    @GetMapping("/main")
    public String dashboardPage(@AuthenticationPrincipal org.springframework.security.core.userdetails.User user
    		, Model model) {
    	
        model.addAttribute("loginId", user.getUsername());
        model.addAttribute("loginRoles", user.getAuthorities());

        return "main/main";
    }

}
