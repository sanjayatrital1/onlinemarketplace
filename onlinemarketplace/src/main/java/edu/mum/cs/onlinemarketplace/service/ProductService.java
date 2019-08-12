package edu.mum.cs.onlinemarketplace.service;


import edu.mum.cs.onlinemarketplace.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product>getAllProducts();
    Product save(Product product);
}
