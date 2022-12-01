package com.moviesflix.watch.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.rmi.server.UID;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "author")
public class AuthorEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private UID id;
    @Column(name = "name")
    private String name;

    @ElementCollection(targetClass = MovieEntity.class)
    @OneToMany
    private List<MovieEntity> moviesActed;


}