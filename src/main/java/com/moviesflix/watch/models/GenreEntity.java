package com.moviesflix.watch.models;

import com.moviesflix.watch.constant.GenreTypesEnum;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.rmi.server.UID;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "genre")
public class GenreEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private UID id;
    @Column(name = "name")
    private GenreTypesEnum genreType;


}