package com.springboot.musicapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.musicapi.model.Band;
import com.springboot.musicapi.model.enumerations.OrderBy;
import com.springboot.musicapi.service.BandService;

/**
 * 
 * @author Vinicius Falcão
 *
 */
@RestController
@RequestMapping("bands")
public class BandController {

	@Autowired
	private BandService bandService;

	@GetMapping
	public ResponseEntity<List<Band>> findAll() {
		return new ResponseEntity<List<Band>>(bandService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/orderBy/{orderBy}")
	public ResponseEntity<List<Band>> findAll(@PathVariable("orderBy") OrderBy orderBy) {
		return new ResponseEntity<List<Band>>(bandService.findAll(orderBy), HttpStatus.OK);
	}

	@GetMapping("/findByName/{name}")
	public ResponseEntity<List<Band>> findByName(@PathVariable("name") String name) {
		return new ResponseEntity<List<Band>>(bandService.findByName(name), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Band> findById(@PathVariable("id") String id) {
		return new ResponseEntity<Band>(bandService.findById(id), HttpStatus.OK);
	}

}
