package com.mkyong.web.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mkyong.web.api.UserManager;
import com.mkyong.web.model.SearchCriteria;
import com.mkyong.web.model.User;

@Controller
public class WelcomeController {
	@Autowired
	private UserManager userManager;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		return "welcome";
	}
	@RequestMapping(value = "/search/api/getSearchResult",method = RequestMethod.POST)
	@ResponseBody
	public  List<User> getSearchResultViaAjax(@RequestBody SearchCriteria search) {
		return userManager.getSearchResultViaAjax(search);
	}

}
