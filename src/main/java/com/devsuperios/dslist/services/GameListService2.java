package com.devsuperios.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperios.dslist.dto.GameListDTO;
import com.devsuperios.dslist.entities.GameList;
import com.devsuperios.dslist.projections.GameMinProjection;
import com.devsuperios.dslist.repositories.GameListRepository2;
import com.devsuperios.dslist.repositories.GameRepository;

@Service
public class GameListService2 {
	@Autowired
	private GameListRepository2 gameListRepository2;
	
	@Autowired
	private GameRepository gameRepository;
	@Transactional(readOnly = true)
	public List<GameListDTO>  findAll() {
		List<GameList>result = gameListRepository2.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
	
			
	}
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex :sourceIndex;
		
		for (int i = min; i <= max; i++) {
			gameListRepository2.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
		
	}

}
