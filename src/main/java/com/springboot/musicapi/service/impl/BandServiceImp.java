package com.springboot.musicapi.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springboot.musicapi.model.Band;
import com.springboot.musicapi.model.enumerations.OrderBy;
import com.springboot.musicapi.service.BandService;

/**
 * 
 * @author Vinicius Falcão
 *
 */
@Service
public class BandServiceImp implements BandService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private MessageSourceAccessor messageAccessor;

	@Cacheable("bands")
	@Override
	public List<Band> findAll() {
		return restTemplate.exchange(messageAccessor.getMessage("base_url") + "/bands", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Band>>() {
				}).getBody();
	}

	@Cacheable("bands")
	@Override
	public Band findById(String id) {
		return restTemplate.getForEntity(messageAccessor.getMessage("base_url") + "/bands/" + id, Band.class).getBody();
	}

	@Cacheable("bands")
	@Override
	public List<Band> findAll(OrderBy orderBy) {
		List<Band> allBands = findAll();
		if (orderBy.equals(OrderBy.NAME)) {
			Collections.sort(allBands, (band1, band2) -> band1.getName().compareTo(band2.getName()));
		} else {
			Collections.sort(allBands, (band1, band2) -> band2.getNumPlays().compareTo(band1.getNumPlays()));
		}
		return allBands;
	}

	@Cacheable("bands")
	@Override
	public List<Band> findByName(String name) {
		return findAll().stream().filter(band -> band.getName().toUpperCase().contains(name.toUpperCase()))
				.collect(Collectors.toList());
	}

}
