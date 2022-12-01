package com.moviesflix.watch.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.rmi.server.UID;
import java.time.Duration;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "episode")
public class EpisodeEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private UID id;

    @Column(name = "episodeName")
    private String episodeName;

    @Column(name = "duration")
    private Duration durationInHoursAndMinutes;
}
