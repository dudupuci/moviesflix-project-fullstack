package com.movies.netflix.models;

import com.movies.netflix.constant.ParentalRatingEnum;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.rmi.server.UID;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class SerieEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private UID id;

    @Column(name = "name")
    private String name;

    @Column(name = "duration")
    private Duration duration;

    @Column(name = "seasons")
    private List<SeasonEntity> seasons;

    @Column(name = "countries")
    private List<SceneryCountriesEntity> sceneryCountries;

    @Column(name = "description", length = 128)
    private String description;

    @ToString.Include
    @JoinColumn(name = "main_authors")
    private List<AuthorEntity> mainAuthors;

    @Column(name = "releaseDate")
    private LocalDateTime releaseDateOf;

    @Enumerated(EnumType.STRING)
    @Column(name = "age")
    private ParentalRatingEnum recommendation;

    @Column(name = "category")
    private GenreEntity category;




}
