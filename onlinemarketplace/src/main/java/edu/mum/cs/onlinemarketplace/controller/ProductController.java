package edu.mum.cs.onlinemarketplace.controller;

import edu.mum.cs.onlinemarketplace.domain.Product;
import edu.mum.cs.onlinemarketplace.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product/{uid}")
    public String getProductFzorm(@PathVariable Long uid, @ModelAttribute Product product){
        return "productForm";
    }

    @PostMapping("/product/{uid}")
    public String saveProduct(Product product, BindingResult bindingResult, Model model ){
        if(bindingResult.hasErrors()){
            return "productForm";
        }
        else {
            productService.save(product);
            return "redirect;/showDetais";
        }
    }
}
