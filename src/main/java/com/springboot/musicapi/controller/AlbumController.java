package com.springboot.musicapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.musicapi.model.Album;
import com.springboot.musicapi.service.AlbumService;

/**
 * 
 * @author Vinicius Falcão
 *
 */
@RestController
@RequestMapping("albums")
public class AlbumController {

	@Autowired
	private AlbumService albumService;

	@GetMapping
	public ResponseEntity<List<Album>> findAll() {
		return new ResponseEntity<List<Album>>(albumService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/byBand/{bandId}")
	public ResponseEntity<List<Album>> findByBandId(@PathVariable("bandId") String bandId) {
		return new ResponseEntity<List<Album>>(albumService.findByBand(bandId), HttpStatus.OK);
	}

	@GetMapping("/byName/{name}")
	public ResponseEntity<List<Album>> findByName(@PathVariable("name") String name) {
		return new ResponseEntity<List<Album>>(albumService.findByName(name), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Album> findById(@PathVariable("id") String id) {
		return new ResponseEntity<Album>(albumService.findById(id), HttpStatus.OK);
	}

}
