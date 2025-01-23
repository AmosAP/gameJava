package com.devsuperios.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperios.dslist.dto.GameListDTO;
import com.devsuperios.dslist.entities.GameList;
import com.devsuperios.dslist.repositories.GameListRepository2;

@Service
public class GameListService2 {
	@Autowired
	private GameListRepository2 gameListRepository2;
	
	@Transactional(readOnly = true)
	public List<GameListDTO>  findAll() {
		List<GameList>result = gameListRepository2.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
	
			
	}

}
