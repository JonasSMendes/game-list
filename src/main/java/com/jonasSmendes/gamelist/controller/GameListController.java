package com.jonasSmendes.gamelist.controller;

import com.jonasSmendes.gamelist.dto.GameListDTO;
import com.jonasSmendes.gamelist.dto.GameMinDTO;
import com.jonasSmendes.gamelist.services.GameListService;
import com.jonasSmendes.gamelist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameListDTO>> lists (){
        List<GameListDTO> result = gameListService.gamelist();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping(value = "/{listId}/games")
    public ResponseEntity<List<GameMinDTO>> listGame(@PathVariable Long listId){
        List<GameMinDTO> result = gameService.findByList(listId);
        return ResponseEntity.ok().body(result);
    }

}
