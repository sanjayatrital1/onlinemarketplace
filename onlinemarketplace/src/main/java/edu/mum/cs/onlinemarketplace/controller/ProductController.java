package edu.mum.cs.onlinemarketplace.controller;

import edu.mum.cs.onlinemarketplace.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public String getProductFzorm(){
        return "productForm";
    }
}
