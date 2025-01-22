package com.devsuperios.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperios.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
