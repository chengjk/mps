package me.mps.dao;

import me.mps.po.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends MongoRepository<User, String>,
		PagingAndSortingRepository<User, String> {

	User findByUserName(String userName);
}
