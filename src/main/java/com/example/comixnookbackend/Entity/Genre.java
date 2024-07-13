package com.example.comixnookbackend.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="genre")
public class Genre {

    @Id
    @SequenceGenerator(name = "genres_seq_gen", sequenceName = "genres_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "genres_seq_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name="genre", nullable = false, unique = true)
    private String genre;
}
