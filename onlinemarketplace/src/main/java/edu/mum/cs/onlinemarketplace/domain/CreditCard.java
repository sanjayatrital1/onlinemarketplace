package edu.mum.cs.onlinemarketplace.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class CreditCard {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String validDate;

    private Long number;

    @OneToOne(mappedBy = "creditCard")
    private User user;
}
