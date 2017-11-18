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
public class AlbumControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testFindAll() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/albums")).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testFindByBandId() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/albums/byBand/58c15e07a7ec6204001f0448"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("[0].id", Matchers.is("58c15e08a7ec6204001f05fc")));
	}

	@Test
	public void findByName() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/albums/byName/Chasing"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("[0].id", Matchers.is("58c15e08a7ec6204001f0605")));
	}

	@Test
	public void findById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/albums/58c15e08a7ec6204001f0605"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("id", Matchers.is("58c15e08a7ec6204001f0605")));
	}

}
