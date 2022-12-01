package com.moviesflix.watch.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.rmi.server.UID;

@Entity
@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "scenery_countries")
public class SceneryCountriesEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private UID id;
    @Column(name = "country")
    private String nameOfCountry;


}
