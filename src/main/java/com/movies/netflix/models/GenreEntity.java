package com.movies.netflix.models;

import com.movies.netflix.constant.GenreTypesEnum;
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
public class GenreEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UID id;
    @Column(name = "name")
    private GenreTypesEnum genreType;


}