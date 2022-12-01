package com.moviesflix.watch.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.rmi.server.UID;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "season")
public class SeasonEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private UID id;

    @Column(name = "seasonName")
    private String seasonName;

    @ElementCollection(targetClass = EpisodeEntity.class)
    @OneToMany
    private List<EpisodeEntity> episodes;
}
