package com.souvik.org.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.souvik.org.dao.UserRepositoryDao;
import com.souvik.org.model.User;

@Service
public class UserService {
	Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	UserRepositoryDao userDao;

	// Scheduled a job to add object in DB (Every 5 sec)
	@Scheduled(fixedRate = 5000)
	public void addToDB() {
		User user = new User();
		user.setName("User_" + new Random().nextInt());
		userDao.save(user);
		logger.info("Object added in DB {}", new Date().toString());
	}

	// fetch each 15 seconds
	@Scheduled(cron = "0/15 * * * * *")
	public void fetchDB() {
		List<User> user = userDao.findAll();
		logger.info("fetch service call, no of record {} date {}", user.size(), new Date().toString());
		logger.info("users {}", user);
	}
}
