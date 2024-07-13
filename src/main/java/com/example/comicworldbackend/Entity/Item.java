package com.example.comicworldbackend.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
@Table(name="item")
public class Item {
    @Id
    @SequenceGenerator(name = "items_seq_gen", sequenceName = "items_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "items_seq_gen", strategy = GenerationType.SEQUENCE)
    private Long itemId;

    @Column(name = "item_name", nullable = false, unique = true)
    private String itemName;

    @Column(name = "release_date")
    private LocalDate releasedDate;

    @Column(name = "item_description",columnDefinition = "TEXT")
    private String itemDescription;

    @Column(name = "download_link")
    private String downloadLink;

    @Column(name = "item_image")
    private String itemImage;

//    @Column(name = "comic_size")
//    private String comicSize;

    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genreId;
}
