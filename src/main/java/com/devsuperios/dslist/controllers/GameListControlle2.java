package com.devsuperios.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperios.dslist.dto.GameListDTO;
import com.devsuperios.dslist.services.GameListService2;

@RestController
@RequestMapping(value ="/lists")
public class GameListControlle2 {
	
	@Autowired
	private GameListService2 gameListService2;
	
	@GetMapping
	public List<GameListDTO> findAll() {
		List<GameListDTO> result = gameListService2.findAll();
		return result;
	}
	

}
