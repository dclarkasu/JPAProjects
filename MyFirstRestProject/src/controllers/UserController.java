package controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import data.User;

@RestController
public class UserController {
	
	@RequestMapping(path="users", method=RequestMethod.GET)
	public User getUser() {
		User myUser = new User();
		myUser.setFullName("Daniel");
		myUser.setUsername("dclarkasu");
		myUser.setPassword("wombat1");;
		myUser.setEmail("dc@sd.com");
		
		return myUser;
	}

}
