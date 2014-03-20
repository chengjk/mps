package me.mps.service;

import java.util.Date;
import java.util.List;

import me.mps.dao.IPositionDao;
import me.mps.po.Position;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.geo.Box;
import org.springframework.data.mongodb.core.geo.Circle;
import org.springframework.data.mongodb.core.geo.Point;
import org.springframework.stereotype.Service;

@Service
public class PositionService {

	@Autowired
	private IPositionDao dao;
	
	public String add(Position l){
		l=dao.save(l);
		return l.getId();
	}
	
	public Iterable<Position> findAll(){
		return dao.findAll();
	}
	
	public Iterable<Position> findByTime(Date start,Date end){
		return dao.findByDatetimeBetween(start, end);
	}
	public Iterable<Position> findByUserAndDatetime(String code,Date start,Date end){
		return dao.findByUsercodeAndDatetimeBetween(code,start, end);
	}

	/**
	 * 圆形查询
	 * @param lng
	 * @param lat
	 * @param r
	 * @return
	 */
	public List<Position> findCircle(Point pt,double r) {
		Circle circle=new Circle(pt, r);
		return dao.findByLocationWithin(circle);
	}
	/**
	 * 矩形查询
	 * @param lng
	 * @param lat
	 * @param w
	 * @param h
	 * @return
	 */
	public List<Position> findRectangle(Point pt,double w,double h) {
		Point lowerLeft=new Point(pt.getX()-w/2,pt.getY()-h/2);
		Point upperRight=new Point(pt.getX()+w/2, pt.getY()+h/2);
		Box box=new Box(lowerLeft, upperRight);
		return dao.findByLocationWithin(box);
	}

	public void deleteAll() {
		dao.deleteAll();
		
	}
	
	
	
}
