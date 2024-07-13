package com.example.comixnookbackend.Pojo;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemPojo {

    private Long itemId;

    @NotNull
    private String itemName;

    private LocalDate releasedDate;

    private String itemDescription;

    private String downloadLink;

    private MultipartFile itemImage;

    private Long genreId;  // Assuming genreIds represent the IDs of associated genres
}
