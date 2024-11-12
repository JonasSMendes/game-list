package com.jonasSmendes.gamelist.repository;

import com.jonasSmendes.gamelist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
