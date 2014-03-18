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

import sun.security.util.BigInt;

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
			double speed,double direction,String datatime,int loctype,int locacc){
		Map<String,Object> m=new HashMap<String, Object>();
		Date date=new Date();
		Point pt=new Point(lng,lat);
		Position l=null;
		int id=-1;
		try {
			l=	new Position(0, key, lng, lat, alt,pt, speed, direction, date, loctype, locacc);
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
			String usercode,BigInt fdt,BigInt edt) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		Map<String,Object> m=new HashMap<String, Object>();
		Iterable<Position> its= ser.findByTime(sdf.parse("20100101"),sdf.parse("21000101"));
		try {
			m.put("result", "true");
		} catch (Exception e) {
			m.put("result", "false");
			m.put("error", e.getMessage());
			m.put("list", its);
		}
		return m;
	}
	@RequestMapping(value="findall")
	public @ResponseBody Iterable<Position> findall(){
		return ser.findAll();
			
	}
	
	@RequestMapping(value="add/test")
	public @ResponseBody Map<String,Object> addlocationtest(int id){
		Map<String,Object> m=new HashMap<String, Object>();
		Date date=new Date();
		Position l=null;
		try {
			l=	new Position(0, "testkey", id, id, id,new Point(id, id), id,id, date, id, id);
			l.setId(id);
			id= ser.add(l);
			m.put("result", "true");
			m.put("id", id);
		}catch (Exception e) {
			m.put("result", "false");
			m.put("error",e.getMessage());
		}
		return m;
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
	
	
}
