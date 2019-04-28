package com.operr.springboot.operrlocations;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OperrLocationsApplicationTests {


	@Autowired
	private MockMvc mvc;

	@Autowired
	ObjectMapper objectMapper;

	@Test
	public void exampleTest() throws Exception {
		this.mvc.perform(get("http://localhost:8080/operr/test")).andExpect(content().string("Hello"));
	}

	@Test
	public void testGetAll() throws Exception {
		this.mvc.perform(get("http://localhost:8080/operr/getAll")).andExpect(jsonPath("$",hasSize(4)));
	}


}
