package com.springboot.musicapi.service;

import java.util.List;

import com.springboot.musicapi.model.Album;

/**
 * 
 * @author Vinicius Falcão
 *
 */
public interface AlbumService {

	List<Album> findAll();

	List<Album> findByBand(String bandId);

	Album findById(String id);

	List<Album> findByName(String name);

}
