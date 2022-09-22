package com.movies.netflix.dto;

import com.movies.netflix.constant.ParentalRatingEnum;
import com.movies.netflix.models.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.rmi.server.UID;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class MovieEntityDTO {

    private UID id;
    private String name;
    private Duration duration;
    private String description;
    private DirectorEntity director;
    private List<AuthorEntity> mainAuthors;
    private LocalDateTime productionDate;
    private LocalDateTime releaseDateOf;
    private List<SceneryCountriesEntity> sceneryCountries;
    private ParentalRatingEnum parentalRating;
    private GenreEntity genre;

    public MovieEntity toEntity() {
        return MovieEntity.builder()
                .id(this.getId())
                .name(this.getName())
                .duration(this.getDuration())
                .description(this.getDescription())
                .director(this.getDirector())
                .mainAuthors(this.getMainAuthors())
                .productionDate(this.getProductionDate())
                .sceneryCountries(this.getSceneryCountries())
                .parentalRating(this.getParentalRating())
                .genre(this.getGenre())
                .build();
    }

    public List<MovieEntity> listMovieEntity(List<MovieEntityDTO> movieEntityDtoList) {
        return movieEntityDtoList.stream().map(MovieEntityDTO::toEntity).collect(Collectors.toList());
    }
}
