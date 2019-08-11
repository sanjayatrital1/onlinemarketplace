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
import java.time.LocalDate;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(value = {"/product","/product/{uid}/update{pid}"})
    public String getProductForm(@PathVariable(value = "uid", required = false) Long uid, @PathVariable(value = "pid",required = false) Long pid, @ModelAttribute("newProduct") Product product,Model model){
      model.addAttribute("product",productService.findById(pid));
        return "addProductForm";
    }

    @PostMapping("/product")
    public String saveProduct(@Valid Product product, BindingResult bindingResult, Model model, HttpServletRequest request ){
        if(bindingResult.hasErrors()){
            return "addProductForm";
        }
        else {

//            String[] suppressedFields = bindingResult.getSuppressedFields();
//            if (suppressedFields.length > 0) {
//                throw new RuntimeException("Attempting to bind disallowed fields: "
//                        + StringUtils.arrayToCommaDelimitedString(suppressedFields));
//            }
//
//            MultipartFile productImage = product.getProductImage();
//            String rootDirectory = request.getSession().getServletContext().getRealPath("/");
//            if (productImage != null && !productImage.isEmpty()) {
//                try {
//                    System.out.println(rootDirectory + "resources\\statis\\images\\" + product.getId() + ".png");
//                    productImage.transferTo(
//                            new File(rootDirectory + "resources\\static\\images\\" + product.getId() + ".png"));
//                } catch (Exception e) {
//                    throw new RuntimeException("Product Image saving failed", e);
//                }
//            }
            product.setCreateDate(LocalDate.now());
            productService.save(product);
            return "redirect:/showProductDetais";
        }
    }

    @PostMapping("/product/delete/{pid}")
    public String deleteProduct(@PathVariable Long pid){
         productService.delete(pid);
         return "showProductDetails";
    }

    @GetMapping(value = "/product/{uid}/update{pid}")
    public String updateProductForm(@PathVariable(value = "uid", required = false) Long uid, @PathVariable(value = "pid",required = false) Long pid, @ModelAttribute("newProduct") Product product,Model model){
        model.addAttribute("product",productService.findById(pid));
        return "updateProductForm";
    }

    @PostMapping("/product/{uid}/update{pid}")
    public String updateProduct(Product product, @PathVariable Long uid, @PathVariable Long pid){
        Product updateProduct = productService.findById(pid);
        updateProduct.setName(product.getName());
        updateProduct.setDescription(product.getDescription());
        updateProduct.setPrice(product.getPrice());
       // updateProduct.setProductImage(product.getProductImage());
        productService.save(updateProduct);
        return "redirect:/showProductDetais";
    }


}
