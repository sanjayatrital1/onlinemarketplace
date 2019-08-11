package edu.mum.cs.onlinemarketplace.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class UserOrder {
    @Id
    @GeneratedValue
    private Long id;
    private String status;
    @OneToOne
    private Cart cart;
    @ManyToOne
    @JoinColumn
    private User seller;
    private LocalDate deliveryDate;
    private LocalDate createDate;

}
