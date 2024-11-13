package com.jonasSmendes.gamelist.dto;

import com.jonasSmendes.gamelist.entities.GameList;
import lombok.Getter;

@Getter
public class GameListDTO {

    private Long id;
    private String name;

    public GameListDTO(){}

    public GameListDTO(GameList list){
        this.id = list.getId();
        this.name = list.getName();
    }
}
