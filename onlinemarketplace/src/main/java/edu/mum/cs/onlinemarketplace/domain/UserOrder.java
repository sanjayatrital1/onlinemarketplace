package edu.mum.cs.onlinemarketplace.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class UserOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String status;
    private Double total;
    @OneToOne(cascade = CascadeType.ALL)
    private Cart cart;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private User seller;
    private LocalDate deliveryDate;
    private LocalDate createDate;


}
