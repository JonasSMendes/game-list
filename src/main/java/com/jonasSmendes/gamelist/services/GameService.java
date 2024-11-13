package com.jonasSmendes.gamelist.services;

import com.jonasSmendes.gamelist.dto.GameDTO;
import com.jonasSmendes.gamelist.dto.GameMinDTO;
import com.jonasSmendes.gamelist.entities.Game;
import com.jonasSmendes.gamelist.projections.GameMinProjection;
import com.jonasSmendes.gamelist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findId(Long id){
        Optional<Game> gameId = gameRepository.findById(id);

        if (gameId.isEmpty()) {
            throw new RuntimeException("id not found");
        }

        GameDTO dto = new GameDTO(gameId);
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll (){
       List<Game> gameList = gameRepository.findAll();
       List<GameMinDTO> dtos = gameList.stream()
               .map(d -> new GameMinDTO(d))
               .toList();
       return dtos;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList (Long listId){
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        List<GameMinDTO> dtos = result.stream()
                .map(d -> new GameMinDTO(d))
                .toList();
        return dtos;
    }
}
