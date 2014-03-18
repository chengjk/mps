package me.mps.dao;

import java.util.Date;

import me.mps.po.Location;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ILocationDao extends MongoRepository<Location, String>,
				PagingAndSortingRepository<Location, String> {
	
	Iterable<Location> findByUsercode(String usercode);
	Iterable<Location> findByDatetimeBetween(Date b,Date e);
}
