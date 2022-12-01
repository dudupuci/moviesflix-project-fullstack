package com.moviesflix.watch.dto;

import com.moviesflix.watch.constant.ParentalRatingEnum;
import com.moviesflix.watch.models.*;
import lombok.*;

import java.rmi.server.UID;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
                .id(id)
                .name(name)
                .duration(duration)
                .description(description)
                .director(director)
                .mainAuthors(mainAuthors)
                .productionDate(productionDate)
                .releaseDateOf(releaseDateOf)
                .sceneryCountries(sceneryCountries)
                .parentalRating(parentalRating)
                .genre(genre)
                .build();
    }

    public List<MovieEntity> movieListDTOtoEntity(List<MovieEntityDTO> movieListDTOtoEntity) {
        return movieListDTOtoEntity.stream().map(MovieEntityDTO::toEntity).collect(Collectors.toList());
    }
}
