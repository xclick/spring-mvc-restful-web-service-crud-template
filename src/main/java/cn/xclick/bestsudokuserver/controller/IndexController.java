package cn.xclick.bestsudokuserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	public IndexController(){
	}
	
	@RequestMapping("/")    
	 public ModelAndView getIndex(){      
		return new ModelAndView("index");   
	}
}
