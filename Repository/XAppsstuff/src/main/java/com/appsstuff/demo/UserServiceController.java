package com.appsstuff.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceController {

	
@Autowired
private UserDaoService userService;

		@RequestMapping(method=RequestMethod.GET , path = "/user/{userId}")
		public User findById(@PathVariable int userId) {
			return userService.getUserInfo(userId);
			
		}
		@RequestMapping(method=RequestMethod.GET , path="/user")
		public List<User> findAll(){
			return userService.getAllUsers();
			
		}
		
		@RequestMapping(method= RequestMethod.DELETE , path = "/user/{userId}")
		public String deleteUser(@PathVariable int userId) {
			return userService.deleteUser(userId);
			
		}
		
	   //@RequestMapping(method=RequestMethod.POST , path="/user")
		@PostMapping("/user")
		public void addUser(@RequestBody User user) {
			userService.AddNew(user);
			
		}
	
		@RequestMapping(method=RequestMethod.GET , path="/user/count")
		public int findCount() {
			return userService.getCount();
			
		}
}
