package com.jonasSmendes.gamelist.dto;

import com.jonasSmendes.gamelist.entities.Game;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Optional;

@Getter
@Setter
public class GameDTO {

    private Long id;
    private String title;
    private Integer year;
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;
    private String longDescription;
    private String shortDescription;

    public GameDTO(){}

    public GameDTO(Game entity){
        BeanUtils.copyProperties(entity, this);
    }

    public GameDTO(Optional<Game> gameId) {
          id = gameId.get().getId();
          title = gameId.get().getTitle();
          year = gameId.get().getYear();
          genre = gameId.get().getGenre();
          platforms = gameId.get().getPlatforms();
          score = gameId.get().getScore();
          imgUrl = gameId.get().getImgUrl();
          longDescription = gameId.get().getLongDescription();
          shortDescription = gameId.get().getShortDescription();
    }
}
