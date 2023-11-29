package com.example.demo.hello.controller;

import java.net.http.HttpRequest;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.hello.domain.Board;


@Controller
@RequestMapping("/main")
public class MainController {
	
	/*
	 * private final MainService service;
	 * 
	 * public MainController(MainService service) { this.service = service; }
	 */
	
	@GetMapping("/rank")
	public String rank(Model model) {
		
		return "main/rank";
	}
	
	/*
	 * @PostMapping("/boardList")
	 * 
	 * @ResponseBody public List<Board> boardList(HttpRequest request){
	 * 
	 * List<Board> list = service.boardList(request);
	 * 
	 * return list; }
	 */
	
	
}
