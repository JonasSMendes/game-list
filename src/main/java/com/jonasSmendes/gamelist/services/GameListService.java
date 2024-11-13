package com.jonasSmendes.gamelist.services;

import com.jonasSmendes.gamelist.dto.GameDTO;
import com.jonasSmendes.gamelist.dto.GameListDTO;
import com.jonasSmendes.gamelist.dto.GameMinDTO;
import com.jonasSmendes.gamelist.entities.GameList;
import com.jonasSmendes.gamelist.repository.GameListRepository;
import com.jonasSmendes.gamelist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
