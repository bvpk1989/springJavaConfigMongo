package com.mkyong.web.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.mkyong.web.dao.UserDAOImpl;
import com.mkyong.web.model.SearchCriteria;
import com.mkyong.web.model.User;

@Component
public class UserManager {
	List<User> users;
	@Autowired
	private UserDAOImpl userDAOImpl;

	public List<User> getSearchResultViaAjax(SearchCriteria search) {
		userDAOImpl.save();
		List<User> users=null;
		if (isValidSearchCriteria(search)) {
			 users = userDAOImpl.search(search.getUsername());
		}
		return users;
	}

	private boolean isValidSearchCriteria(SearchCriteria search) {

		boolean valid = true;

		if (search == null) {
			valid = false;
		}

		if ((StringUtils.isEmpty(search.getUsername())) && (StringUtils.isEmpty(search.getEmail()))) {
			valid = false;
		}

		return valid;
	}

	// Init some users for testing
	@PostConstruct
	private void iniDataForTesting() {
		users = new ArrayList<User>();

		User user1 = new User("mkyong", "pass123");
		User user2 = new User("yflow", "pass456");
		User user3 = new User("laplap", "pass789");
		users.add(user1);
		users.add(user2);
		users.add(user3);

	}

	// Simulate the search function
	private List<User> findByUserNameOrEmail(String username, String lastName) {

		List<User> result = new ArrayList<User>();

		for (User user : users) {

			if ((!StringUtils.isEmpty(username)) && (!StringUtils.isEmpty(lastName))) {

				if (username.equals(user.getFirstName()) && lastName.equals(user.getFirstName())) {
					result.add(user);
					continue;
				} else {
					continue;
				}

			}
			if (!StringUtils.isEmpty(username)) {
				if (username.equals(user.getLastName())) {
					result.add(user);
					continue;
				}
			}

			if (!StringUtils.isEmpty(lastName)) {
				if (lastName.equals(user.getLastName())) {
					result.add(user);
					continue;
				}
			}

		}

		return result;

	}
}
