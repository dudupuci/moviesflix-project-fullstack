package com.moviesflix.watch.models;

import com.moviesflix.watch.dto.MovieEntityDTO;
import com.moviesflix.watch.constant.ParentalRatingEnum;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.rmi.server.UID;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@ToString
@Builder(toBuilder = true)
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movies")
public class MovieEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private UID id;

    @Column(name = "name")
    private String name;

    @Column(name = "duration")
    private Duration duration;

    @Column(name = "description", length = 128)
    private String description;

    @JoinColumn(name = "director_name")
    @OneToOne
    private DirectorEntity director;

    @ElementCollection(targetClass = AuthorEntity.class)
    @OneToMany // mappedBy = tenho que relational as tables
    private List<AuthorEntity> mainAuthors;

    @Column(name = "productionDate")
    private LocalDateTime productionDate;

    @Column(name = "releaseDate")
    private LocalDateTime releaseDateOf;

    @ElementCollection(targetClass = SceneryCountriesEntity.class)
    @OneToMany
    private List<SceneryCountriesEntity> sceneryCountries;

    @Enumerated(EnumType.STRING)
    @Column(name = "parentalRating")
    private ParentalRatingEnum parentalRating;

    @Column(name = "genre")
    private GenreEntity genre;

    public MovieEntityDTO toDto() {
        return MovieEntityDTO.builder()
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

    public List<MovieEntityDTO> listMovieEntityDto(List<MovieEntity> movieEntityList) {
       return movieEntityList.stream().map(MovieEntity::toDto).collect(Collectors.toList());
    }


}
