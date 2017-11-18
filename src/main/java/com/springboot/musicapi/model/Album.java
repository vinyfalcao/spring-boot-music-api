package com.springboot.musicapi.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Album {

	private String id;
	private String name;
	private String image;
	private String releasedDate;
	private String band;
	private List<Track> tracks;

}
