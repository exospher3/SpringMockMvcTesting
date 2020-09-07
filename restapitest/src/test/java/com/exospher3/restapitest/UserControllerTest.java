package com.exospher3.restapitest;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.when;

import com.exospher3.restapitest.controller.UserController;
import com.exospher3.restapitest.entity.User;
import com.exospher3.restapitest.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(UserController.class)
public class UserControllerTest {
	
	@Autowired
	private UserController userController;
	
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@MockBean
	private UserService userService;
	
	
	@Test
	public void getUserByIdTest() throws Exception {
		
		//Mock the data return by the user service class
		User user = new User();
		
		user.setName("John");
		user.setEmail("John@Devt.com");
		user.setPhone("1231231234");
		
		
		when(userService.getUserById(anyInt())).thenReturn(user);
		
		
		//create a mock HTTP request to verify the expected result
		mockMvc.perform(MockMvcRequestBuilders.get("/user/12"))
						.andDo(print())
						.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("John"))	
						.andExpect(MockMvcResultMatchers.jsonPath("$.email").value("John@Devt.com"))	
						.andExpect(MockMvcResultMatchers.jsonPath("$.phone").value("1231231234"))	
						.andExpect(status().isOk());
			
		
		
	}
	
	
	@Test
	public void saveUserTest() throws Exception {
		
		//mock the user data 
		User user = new User();
		user.setId(1);
		user.setName("Baloo");
		user.setEmail("Baloon@Sharikan.com");
		user.setPhone("808 222 3333");
		
		when(userService.saveUser(any(User.class))).thenReturn(user);
		
		//mock the request /user
		mockMvc.perform(MockMvcRequestBuilders.post("/user")
						.content(new ObjectMapper().writeValueAsString(user))
						.contentType(MediaType.APPLICATION_JSON))
						.andExpect(status().isCreated())
						.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
						.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Baloo"))	
						.andExpect(MockMvcResultMatchers.jsonPath("$.email").value("Baloon@Sharikan.com"))	
						.andExpect(MockMvcResultMatchers.jsonPath("$.phone").value("808 222 3333"));	
		
		
	}
	
	
}
