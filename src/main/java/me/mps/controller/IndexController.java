package me.mps.controller;

import java.util.Date;

import me.mps.po.Position;

import org.springframework.data.mongodb.core.geo.Point;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class IndexController {
	@RequestMapping(value="/")
	public  String index(){
		return "test/test";
	}
	
	@RequestMapping(value="hi")
	public @ResponseBody Position  hi(){
		Position l=	new Position("user", 1.1, 1.2, 1.3,new Point(1.1,1.2), 2.2, 2.3, new Date(), 5, 6);
		return l;
	}

	

}
