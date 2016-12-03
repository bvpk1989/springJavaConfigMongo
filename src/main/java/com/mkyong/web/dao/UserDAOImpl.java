package com.mkyong.web.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.mkyong.web.model.User;

@Component
public class UserDAOImpl {
	@Autowired
	private MongoTemplate mongoTemplate;

	public void save() {
		mongoTemplate.save(new User("Alice", "Smith"));
		mongoTemplate.save(new User("Bob", "Smith"));
	}
	
	public List<User> search(final String userName ){
		return mongoTemplate.find(Query.query(Criteria.where("firstName").is(userName)), User.class);
	}
}
