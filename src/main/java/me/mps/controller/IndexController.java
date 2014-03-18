package me.mps.controller;

import java.util.Date;

import me.mps.po.Location;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class IndexController {
	@RequestMapping(value="/")
	public  String index(){
		return "test";
	}
	
	@RequestMapping(value="hi")
	public @ResponseBody Location  hi(){
		Location l=	new Location(1, "user", 1.1, 1.2, 1.3, 2.2, 2.3, new Date(), 5, 6);
		return l;
	}

	

}
