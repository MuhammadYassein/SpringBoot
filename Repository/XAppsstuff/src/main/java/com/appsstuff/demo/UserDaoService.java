package com.appsstuff.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class UserDaoService {

	private static List<User> userList = new ArrayList<>();
	private static int userCount;
	private static int userSeq;
	
	static {
		userList.add(new User(10, "Muhammad"));
		userList.add(new User(20, "Mona"));
		userList.add(new User(30, "Hala"));
		userList.add(new User(40, "Ahmed"));
		userList.add(new User(50, "Ali"));
	}

	
	public User getUserInfo(int userId) {

		for(User user :userList) {
			if (user.getUserId() == userId) {
				return user;
			}
		}
		return null;			
		}
		

	public List<User> getAllUsers() {
		return userList;

	}

	public void AddNew(User user) {
		userSeq = userList.size() * 10;
		if (user.getUserId() == null) {
			user.setUserId(userSeq);
		}
		userList.add(user);
	}

	@SuppressWarnings("unlikely-arg-type")
	public String deleteUser(int userId) {
		String res;
		Iterator<User> iter = userList.iterator();
		User user ;
		while (iter.hasNext()) {
			user = iter.next(); 
			if (user.getUserId() == userId) {
				res = "User " + iter.next().getUserName() + "Deleted Successfully.. ";
				userList.remove(user);
				return "User " + "Deleted Successfully.. ";
			}
		}

		return "User Id" + userId + " not Found , Deleted Failed ..";

	}
	
	public int getCount() {
		
		return userList.size();
	}

}
