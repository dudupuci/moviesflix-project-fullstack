package com.movies.netflix.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.rmi.server.UID;
import java.util.Map;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SeasonEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private UID id;

    @Column(name = "seasonName")
    private String seasonName;

    @Column(name = "episodes")
    private Map<EpisodeEntity, Integer> episodes;
}
