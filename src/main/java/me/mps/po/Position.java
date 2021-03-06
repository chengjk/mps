package me.mps.po;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.Point;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Position implements Serializable {

	/**
	 * auto
	 */
	private static final long serialVersionUID = -6693293502277478399L;

	@Id
	private String id;

	private String usercode;

	private double lng;

	private double lat;

	private double alt;
	
	private Point location;

	private double speed;

	private double direction;
	private Date datetime;

	private int loctype;

	private int locacc;
	

	public String getId() {
		return id;
	}
 
	

	public Position( String usercode, double lng, double lat,
			double alt, Point location, double speed, double direction,
			Date datetime, int loctype, int locacc) {
		super();
		this.usercode = usercode;
		this.lng = lng;
		this.lat = lat;
		this.alt = alt;
		this.location = location;
		this.speed = speed;
		this.direction = direction;
		this.datetime = datetime;
		this.loctype = loctype;
		this.locacc = locacc;
	}



	public void setId(String id) {
		this.id = id;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getAlt() {
		return alt;
	}

	public void setAlt(double alt) {
		this.alt = alt;
	}
	

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getDirection() {
		return direction;
	}

	public void setDirection(double direction) {
		this.direction = direction;
	}


	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public int getLoctype() {
		return loctype;
	}

	public void setLoctype(int loctype) {
		this.loctype = loctype;
	}

	public int getLocacc() {
		return locacc;
	}

	public void setLocacc(int locacc) {
		this.locacc = locacc;
	}

}
