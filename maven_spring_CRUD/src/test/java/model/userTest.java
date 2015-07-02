package model;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dao.UserMapper;
import model.User;

public class userTest {

	ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"ApplicationContext.xml");
	UserMapper userMapper = (UserMapper) ctx.getBean("userMapper");
	User user = new User();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test_serch() {
		// User user = new User();
		user.setUsername("admin");
		user.setPassword("admin");
		System.out.println(userMapper.selectUser(user));
	}

	@Test
	public void test_insert() {
		User insertUser = new User();
		insertUser.setUsername("testUsername");
		insertUser.setPassword("testPassword");
		userMapper.insertUser(insertUser);

	}

	@Test
	public void test_update() {
		user.setId(1);
		user.setPassword("updatePassword");
		userMapper.updateUser(user);
	}
	
	@Test
	public void test_delete() {
		userMapper.deleteUser(2);
	}
}
