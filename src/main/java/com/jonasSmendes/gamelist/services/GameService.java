package com.jonasSmendes.gamelist.services;

import com.jonasSmendes.gamelist.dto.GameMinDTO;
import com.jonasSmendes.gamelist.entities.Game;
import com.jonasSmendes.gamelist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll (){
       List<Game> gameList = gameRepository.findAll();
       List<GameMinDTO> dtos = gameList.stream()
               .map(d -> new GameMinDTO(d))
               .toList();
       return dtos;
    }
}
