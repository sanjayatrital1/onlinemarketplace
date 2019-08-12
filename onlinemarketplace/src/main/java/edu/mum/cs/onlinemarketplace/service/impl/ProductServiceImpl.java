package edu.mum.cs.onlinemarketplace.service.impl;

import edu.mum.cs.onlinemarketplace.domain.Product;
import edu.mum.cs.onlinemarketplace.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product save(Product product) {
        return null;
    }
}
