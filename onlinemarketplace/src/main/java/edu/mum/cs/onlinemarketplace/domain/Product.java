package edu.mum.cs.onlinemarketplace.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Product {
    @Id @GeneratedValue
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private  String description;
    private double price;
    private int quantiy;
    @OneToOne
    private User serrer;
    private Integer points;
    private LocalDate createDate;
    @OneToMany
    private List<Review>reviewList;

    @JsonIgnore
    private MultipartFile productImage;

}
