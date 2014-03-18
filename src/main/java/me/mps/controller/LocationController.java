package me.mps.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.mps.po.Location;
import me.mps.service.LocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sun.security.util.BigInt;

@Controller
@RequestMapping("/location")
public class LocationController {
	@Autowired
	private LocationService ser;
	
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
			double speed,double direction,BigInt datatime,int loctype,int locacc){
		Map<String,Object> m=new HashMap<String, Object>();
		Date date=new Date();
		Location l=null;
		int id=-1;
		try {
			l=	new Location(0, key, lng, lat, alt, speed, direction, date, loctype, locacc);
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
			int query,double r,double w,double h,BigInt datatime){
		Map<String,Object> m=new HashMap<String, Object>();
		List<Location> lst=null;
		try {
			lst=ser.findCircle(lng,lat,r);
			m.put("result", "true");
		} catch (Exception e) {
			m.put("result", "false");
			m.put("error", e.getMessage());
			m.put("list", lst);
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
		Iterable<Location> its= ser.findByTime(sdf.parse("20100101"),sdf.parse("21000101"));
		try {
			m.put("result", "true");
		} catch (Exception e) {
			m.put("result", "false");
			m.put("error", e.getMessage());
			m.put("list", its);
		}
		return m;
	}
	
}
