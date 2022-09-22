package com.movies.netflix.models;

import com.movies.netflix.dto.MovieEntityDTO;
import com.movies.netflix.constant.ParentalRatingEnum;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.rmi.server.UID;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class MovieEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private UID id;

    @Column(name = "name")
    private String name;

    @Column(name = "duration")
    private Duration duration;

    @Column(name = "description", length = 128)
    private String description;

    @JoinColumn(name = "director_name")
    private DirectorEntity director;

    @ToString.Include
    @JoinColumn(name = "main_authors")
    private List<AuthorEntity> mainAuthors;

    @Column(name = "productionDate")
    private LocalDateTime productionDate;

    @Column(name = "releaseDate")
    private LocalDateTime releaseDateOf;

    @Column(name = "movieCountries")
    private List<SceneryCountriesEntity> sceneryCountries;

    @Enumerated(EnumType.STRING)
    @Column(name = "parentalRating")
    private ParentalRatingEnum parentalRating;

    @Column(name = "genre")
    private GenreEntity genre;

    public MovieEntityDTO toDto() {
        return MovieEntityDTO.builder()
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

    public List<MovieEntityDTO> listMovieEntityDto(List<MovieEntity> movieEntityList) {
       return movieEntityList.stream().map(MovieEntity::toDto).collect(Collectors.toList());
    }


}
