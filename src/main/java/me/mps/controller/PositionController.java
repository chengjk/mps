package me.mps.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import me.mps.po.Position;
import me.mps.service.PositionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.geo.Point;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/location")
public class PositionController {
	@Autowired
	private PositionService ser;
	
	/**
	 * 提交位置
	 * @param key
	 * @param lng
	 * @param lat
	 * @param alt
	 * @param speed
	 * @param direction
	 * @param datatime
	 * @param loctype
	 * @param locacc
	 * @return
	 */
	@RequestMapping(value="add")
	public @ResponseBody Map<String,Object> addlocation(String key,double lng,double lat,double alt,
			double speed,double direction,int loctype,int locacc){
		Map<String,Object> m=new HashMap<String, Object>();
		Date date=new Date();
		Point pt=new Point(lng,lat);
		Position l=null;
		String id="";
		try {
			l=	new Position(key, lng, lat, alt,pt, speed, direction, date, loctype, locacc);
			id= ser.add(l);
			m.put("result", "true");
		}catch (Exception e) {
			m.put("result", "false");
			m.put("error",e.getMessage());
			m.put("id", id);
		}
		return m;
	}
	/**
	 * 获取周边位置
	 * @param key
	 * @param type
	 * @param lng
	 * @param lat
	 * @param query
	 * @param r
	 * @param w
	 * @param h
	 * @param datatime
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="nearby")
	public @ResponseBody Map<String,Object>  nearbylocation(String key,int type,double lng,double lat,
			int query,double r,double w,double h,String datatime){
		Map<String,Object> m=new HashMap<String, Object>();
		Iterable<Position> lst=null;
		try {
			if(query==1){
				lst=ser.findCircle(new Point(lng,lat),r);
			}else if(query==2){
				lst=ser.findRectangle(new Point(lng,lat), w, h);
			}
			m.put("result", "true");
			m.put("list", lst);
		} catch (Exception e) {
			m.put("result", "false");
			m.put("error", e.getMessage());
		}
		return m;
	}
	
	/**
	 * 获取指定用户位置
	 * @param key
	 * @param usercode
	 * @param fdt
	 * @param edt
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value="user")
	public @ResponseBody Map<String,Object>  userlocaiton(String key,
			String usercode,String fdt,String edt) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
		Map<String,Object> m=new HashMap<String, Object>();
		
		try {
			Iterable<Position> its= ser.findByUserAndDatetime(usercode,sdf.parse(fdt),sdf.parse(edt));
			m.put("result", "true");
			m.put("list", its);
		} catch (Exception e) {
			m.put("result", "false");
			m.put("error", e.getMessage());
		}
		return m;
	}
	
	
	@RequestMapping(value="findall")
	public @ResponseBody Iterable<Position> findall(){
		return ser.findAll();
	}
	
	@RequestMapping(value="deleteall")
	public @ResponseBody Map<String,Object> removeall(){
		Map<String,Object> m=new HashMap<String, Object>();
		try {
			ser.deleteAll();
			m.put("result", "true");
		}catch (Exception e) {
			m.put("result", "false");
			m.put("error",e.getMessage());
		}
		return m;
	}
	
	
	//------------------assists-------------
	
	@RequestMapping(value="add/one")
	public @ResponseBody Map<String,Object> addlocationtest(){
		int num=1;
		Map<String,Object> m=new HashMap<String, Object>();
		Date date=new Date();
		Position l=null;
		String id="";
		try {
			l=	new Position("testkey", num, num, num,new Point(12, 12), num,num, date, num, num);
			l.setId(String.valueOf(num));
			id=ser.add(l);
			m.put("result", "true");
			m.put("id", id);
		}catch (Exception e) {
			m.put("result", "false");
			m.put("error",e.getMessage());
		}
		return m;
	}
	
	@RequestMapping(value="add/random")
	public @ResponseBody Map<String,Object> addrandom(int size){
		Map<String,Object> m=new HashMap<String, Object>();
		Date date=new Date();
		double r=0;
		double lng=0;
		double lat=0;
		Point location;
		Position l=null;
		try {
			int i=0;
			while(i++<size){
				r=Math.random();
				lng=20+100*r;
				lat=60*r;
				location=new Point(lng,lat);
				l=new Position("testkey"+i, lng, lat, i, location, i, i, date, 1, 1);
				ser.add(l);
			}
			m.put("result", "true");
		}catch (Exception e) {
			m.put("result", "false");
			m.put("error",e.getMessage());
		}
		return m;
	}
	
	
	
}
