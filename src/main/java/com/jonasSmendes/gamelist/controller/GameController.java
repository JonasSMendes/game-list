package com.jonasSmendes.gamelist.controller;


import com.jonasSmendes.gamelist.dto.GameMinDTO;
import com.jonasSmendes.gamelist.entities.Game;
import com.jonasSmendes.gamelist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameMinDTO>> gameList(){
        List<GameMinDTO> result = gameService.findAll();
        return ResponseEntity.ok().body(result);
    }
}
