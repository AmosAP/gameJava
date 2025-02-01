package com.devsuperios.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperios.dslist.dto.GameListDTO;
import com.devsuperios.dslist.dto.GameMinDTO;
import com.devsuperios.dslist.dto.ReplacementDTO;
import com.devsuperios.dslist.services.GameListService2;
import com.devsuperios.dslist.services.GameService;

@RestController
@RequestMapping(value ="/lists")
public class GameListControlle2 {
	
	@Autowired
	private GameListService2 gameListService2;
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<GameListDTO> findAll() {
		List<GameListDTO> result = gameListService2.findAll();
		return result;
	}
	@GetMapping(value = "/{listId}/games")
	public List<GameMinDTO> findBylist(@PathVariable Long listId) {
		List<GameMinDTO> result = gameService.findByList(listId);
		return result;
	}
	
	@PostMapping(value = "/{listId}/replacement")
	public void  move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
		gameListService2.move(listId, body.getSourceIndex(), body.getDestinationIndex());
		
	}
	
	

}
