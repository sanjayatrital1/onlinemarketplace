package edu.mum.cs.onlinemarketplace.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Cart {
    @Id
    @GeneratedValue
    private Long id;
    private double totalPrice;
    private boolean active;
    @OneToMany
    private List<Product>productList;
    @OneToOne
    private User buyer;

    public void calculateTotalPrice(){
        this.totalPrice = productList.stream().mapToDouble(Product::getPrice).sum();
    }
}
