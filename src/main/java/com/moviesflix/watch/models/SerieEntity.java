package com.moviesflix.watch.models;

import com.moviesflix.watch.constant.ParentalRatingEnum;
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
@Table(name = "serie")
public class SerieEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private UID id;

    @Column(name = "name")
    private String name;

    @Column(name = "duration")
    private Duration duration;

    @ElementCollection(targetClass = SeasonEntity.class)
    @OneToMany
    private List<SeasonEntity> seasons;

    @ElementCollection(targetClass = SceneryCountriesEntity.class)
    @OneToMany
    private List<SceneryCountriesEntity> sceneryCountries;

    @Column(name = "description", length = 128)
    private String description;

    @ElementCollection(targetClass = AuthorEntity.class)
    //@Transient não cria tabela
    @OneToMany
    private List<AuthorEntity> mainAuthors;

    @Column(name = "releaseDate")
    private LocalDateTime releaseDateOf;

    @Enumerated(EnumType.STRING)
    @Column(name = "age")
    private ParentalRatingEnum recommendation;

    @Column(name = "category")
    private GenreEntity category;




}
