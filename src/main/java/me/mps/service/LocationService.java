package me.mps.service;

import java.util.Date;
import java.util.List;

import me.mps.dao.ILocationDao;
import me.mps.po.Location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

	@Autowired
	private ILocationDao dao;
	
	public int add(Location l){
		l=dao.save(l);
		return l.getId();
	}
	
	public Iterable<Location> findByTime(Date start,Date end){
		return dao.findByDatetimeBetween(start, end);
	}

	public List<Location> findCircle(double lng, double lat,double r) {
		
		return null;
		
	}
	public List<Location> findRectangle(double lng, double lat,double w,double h) {
		
		
		return null;
		
	}
	
	
	
}
