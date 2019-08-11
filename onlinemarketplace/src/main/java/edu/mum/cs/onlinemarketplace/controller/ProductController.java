package edu.mum.cs.onlinemarketplace.controller;

import edu.mum.cs.onlinemarketplace.domain.Product;
import edu.mum.cs.onlinemarketplace.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product/{uid}")
    public String getProductForm(@PathVariable Long uid, @ModelAttribute Product product){
        return "addProductForm";
    }

    @PostMapping("/product/{uid}")
    public String saveProduct(@Valid Product product, BindingResult bindingResult, Model model, HttpServletRequest request ){
        if(bindingResult.hasErrors()){
            return "addProductForm";
        }
        else {

            String[] suppressedFields = bindingResult.getSuppressedFields();
            if (suppressedFields.length > 0) {
                throw new RuntimeException("Attempting to bind disallowed fields: "
                        + StringUtils.arrayToCommaDelimitedString(suppressedFields));
            }

            MultipartFile productImage = product.getProductImage();
            String rootDirectory = request.getSession().getServletContext().getRealPath("/");
            if (productImage != null && !productImage.isEmpty()) {
                try {
                    System.out.println(rootDirectory + "resources\\statis\\images\\" + product.getId() + ".png");
                    productImage.transferTo(
                            new File(rootDirectory + "resources\\static\\images\\" + product.getId() + ".png"));
                } catch (Exception e) {
                    throw new RuntimeException("Product Image saving failed", e);
                }
            }

            productService.save(product);
            return "redirect:/showProductDetais";
        }
    }
}
