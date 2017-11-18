package com.springboot.musicapi.service;

import java.util.List;

import com.springboot.musicapi.model.Band;
import com.springboot.musicapi.model.enumerations.OrderBy;

/**
 * 
 * @author Vinicius Falcão
 *
 */
public interface BandService {

	List<Band> findAll();

	Band findById(String id);

	List<Band> findAll(OrderBy orderBy);

	List<Band> findByName(String name);

}
