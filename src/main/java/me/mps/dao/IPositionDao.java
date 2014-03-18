package me.mps.dao;

import java.util.Date;
import java.util.List;

import me.mps.po.Position;

import org.springframework.data.mongodb.core.geo.Box;
import org.springframework.data.mongodb.core.geo.Circle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IPositionDao extends MongoRepository<Position, String>,
				PagingAndSortingRepository<Position, String> {
	
	Iterable<Position> findByUsercode(String usercode);
	
	Iterable<Position> findByDatetimeBetween(Date b,Date e);
	
	List<Position> findByLocationWithin(Box box);
	List<Position> findByLocationWithin(Circle circle);
}
