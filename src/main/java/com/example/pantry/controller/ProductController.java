package com.example.pantry.controller;

import com.example.pantry.model.ProductModel;
import com.example.pantry.model.ShelfModel;
import com.example.pantry.service.ProductService;
import com.example.pantry.service.ShelfService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
@Controller

public class ProductController {

    private final ProductService productService;
    //nowe
    private final ShelfService shelfService;

    public ProductController(ProductService productService, ShelfService shelfService) {

        this.productService = productService;
        this.shelfService = shelfService;
    }

    @GetMapping("/shelfView")
    public String getProductList(Model model){
        List<ProductModel> productModelList = productService.getProductList();
        model.addAttribute("productList", productModelList);
        return "shelfView";
    }


    //nowe
    @GetMapping("/addProduct")
    public String showAddProductView(@RequestParam("shelfId") Long shelfId, Model model) {
        List<ShelfModel> shelves = shelfService.getAllShelves();
        model.addAttribute("shelves", shelves);
        model.addAttribute("productModel", new ProductModel());
        model.addAttribute("shelfId", shelfId); // TO TU Przekazuje wartość shelfId do widoku
        return "addProductView";
    }

    //nowe post maping do addProduct
    @PostMapping("/addProduct")
    public RedirectView postAddProductAction(ProductModel productModel, @RequestParam Long shelfId) {
        productService.addProduct(productModel);
        return new RedirectView("/view/" + shelfId);
    }

    @PostMapping("/deleteProduct/{productId}")
    public RedirectView deleteProductAction(@PathVariable Long productId, @RequestParam Long shelfId, Model model){
        productService.removeProduct(productId);
//       ShelfModel existingShelf = shelfService.getShelfById(shelfId); to już zaciąga z shelfcontrollera
//        model.addAttribute("shelf", existingShelf);
        return new RedirectView("/view/" + shelfId);
    }

    @GetMapping("/edit/{productId}")
    public String showEditForm(@PathVariable("productId") Long productId, Model model, @RequestParam Long shelfId) {
        ProductModel existingProduct = productService.findById(productId);
        model.addAttribute("existingProduct", existingProduct);
        ShelfModel existingShelf = shelfService.getShelfById(shelfId);
        model.addAttribute("shelf", existingShelf);
        return "editProductView";
    }

    @PostMapping("/products/save")
    public RedirectView saveProduct(ProductModel editProduct, @RequestParam Long shelfId){
        ShelfModel existingShelf = shelfService.getShelfById(shelfId);
       editProduct.setShelf(existingShelf);
        productService.saveEditProduct(editProduct);

       return new RedirectView("/view/" + shelfId);
   }

   //Dodawanie rzeczy na półki



}
