package cn.xclick.bestsudokuserver.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import cn.xclick.bestsudokuserver.data.Constants;
import cn.xclick.bestsudokuserver.model.User;
import cn.xclick.bestsudokuserver.service.CommonService;
import cn.xclick.bestsudokuserver.service.UserService;

@Controller
public class BaseController {
	@Resource  
	protected UserService userService; 
	@Resource  
	protected CommonService commonService ;
	
}