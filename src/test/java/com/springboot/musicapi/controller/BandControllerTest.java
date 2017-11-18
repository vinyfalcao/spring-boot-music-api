package com.springboot.musicapi.controller;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * 
 * @author Vinicius Falcão
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BandControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testFindAll() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/bands")).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testFindAllOrderByName() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/bands/orderBy/NAME"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("[0].name", Matchers.is("Adele")));
	}

	@Test
	public void testFindAllOrderByPopularity() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/bands/orderBy/POPULARITY"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("[0].name", Matchers.is("The Beatles")));
	}

	@Test
	public void testFindByName() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/bands/findByName/adele"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("[0].name", Matchers.is("Adele")));
	}

	@Test
	public void testFindById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/bands/58c15e07a7ec6204001f0448"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("id", Matchers.is("58c15e07a7ec6204001f0448")));
	}

}
