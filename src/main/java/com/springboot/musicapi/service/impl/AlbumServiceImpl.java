package com.springboot.musicapi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.springboot.musicapi.model.Album;
import com.springboot.musicapi.service.AlbumService;

/**
 * 
 * @author Vinicius Falcão
 *
 */
@Component
public class AlbumServiceImpl implements AlbumService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private MessageSourceAccessor messageAccessor;

	@Cacheable("albums")
	@Override
	public List<Album> findAll() {
		return restTemplate.exchange(messageAccessor.getMessage("base_url") + "/albums", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Album>>() {
				}).getBody();

	}

	@Cacheable("albums")
	@Override
	public List<Album> findByBand(String bandId) {
		return findAll().stream().filter(album -> album.getBand().equals(bandId)).collect(Collectors.toList());
	}

	@Cacheable("albums")
	@Override
	public Album findById(String albumId) {
		return findAll().stream().filter(album -> album.getId().equals(albumId)).findFirst().orElse(null);
	}

	@Cacheable("albums")
	@Override
	public List<Album> findByName(String name) {
		return findAll().stream().filter(album -> album.getName().toUpperCase().contains(name.toUpperCase()))
				.collect(Collectors.toList());
	}

}
