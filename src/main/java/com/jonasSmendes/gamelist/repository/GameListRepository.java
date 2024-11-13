package com.jonasSmendes.gamelist.repository;

import com.jonasSmendes.gamelist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
