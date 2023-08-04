package com.example.pantry.controller;

import com.example.pantry.model.ProductModel;
import com.example.pantry.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
@Controller

public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //puste dlatego że to dotyczy strony głównej
    @GetMapping()
    public String getProductList(Model model){
        List<ProductModel> productModelList = productService.getProductList();
        model.addAttribute("productList", productModelList);
        return "index";
    }

    @GetMapping("/addProduct")
    public String showAddProductView(){
        return "addProductView";
    }

    @PostMapping("/addProduct")
    public RedirectView postAddProductAction(ProductModel productModel){
        productService.addProduct(productModel);
        return new RedirectView("/");
    }

    @PostMapping("/deleteProduct/{id}")
    public RedirectView deleteProductAction(@PathVariable Long id){
        productService.removeProduct(id);
        return new RedirectView("/");
    }

    @GetMapping("/edit/{productId}")
    public String showEditForm(@PathVariable("productId") Long productId, Model model) {
        ProductModel existingProduct = productService.findById(productId);
        model.addAttribute("existingProduct", existingProduct);
        return "editProductView";
    }

    @PostMapping("/products/save")
    public RedirectView saveProduct(ProductModel editProduct){
       productService.saveEditProduct(editProduct);
       return new RedirectView("/");
   }

}
