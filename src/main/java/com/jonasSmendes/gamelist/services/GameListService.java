package com.jonasSmendes.gamelist.services;

import com.jonasSmendes.gamelist.dto.GameListDTO;
import com.jonasSmendes.gamelist.entities.GameList;
import com.jonasSmendes.gamelist.repository.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    public List<GameListDTO> gamelist(){
        List<GameList> gameLists = gameListRepository.findAll();

        List<GameListDTO> dto = gameLists.stream()
                .map(l -> new GameListDTO(l))
                .toList();

        return dto;
    }
}
