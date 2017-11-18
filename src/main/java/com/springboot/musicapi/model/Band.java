package com.springboot.musicapi.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Vinicius Falcão
 *
 */
@Getter
@Setter
public class Band {

	private String id;
	private String name;
	private String image;
	private String genre;
	private String biography;
	private Long numPlays;
	private List<String> albums;
}
