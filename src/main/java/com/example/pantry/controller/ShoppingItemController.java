package com.example.pantry.controller;

import com.example.pantry.model.ProductModel;

import com.example.pantry.model.ShelfModel;
import com.example.pantry.model.ShoppingItemModel;
import com.example.pantry.service.ProductService;
import com.example.pantry.service.ShelfService;
import com.example.pantry.service.ShoppingItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping
public class ShoppingItemController {

    private final ShoppingItemService shoppingItemService;
    private final ProductService productService;
    private final ShelfService shelfService;

    public ShoppingItemController(ShoppingItemService shoppingListService, ProductService productService, ShelfService shelfService) {
        this.shoppingItemService = shoppingListService;
        this.productService = productService;
        this.shelfService = shelfService;
    }

    @GetMapping("/shoppingList")
    public String getItemList(Model model) {
        List<ShelfModel> shelfModelList = shelfService.getAllShelves();
        List<ShoppingItemModel> shoppingItemList = shoppingItemService.getItemList();
        model.addAttribute("itemList", shoppingItemList);
        model.addAttribute("shelves", shelfModelList);
        return "shoppingList";
    }

    @GetMapping("/addProductSL")
    public String showAddItemView(){
        return "addProductToShoppingList";
    }

    @PostMapping("/addProductSL")
    public RedirectView postAddItemAction(ShoppingItemModel shoppingItemModel){
        shoppingItemService.addProduct(shoppingItemModel);
        return new RedirectView("/shoppingList");
    }

    @PostMapping("/deleteProductSL/{shoppingItemId}")
    public RedirectView deleteItemAction(@PathVariable Long shoppingItemId){
        shoppingItemService.deleteItem(shoppingItemId);
        return new RedirectView("/shoppingList");
    }

    @PostMapping("/sendProduct/{shoppingItemId}")
    public RedirectView sendItemAction(@PathVariable Long shoppingItemId){
        ShoppingItemModel existingItem = shoppingItemService.findById(shoppingItemId);
        List <ProductModel> allProduct = productService.getProductList();
        for (ProductModel product : allProduct) {
            if (product.getProductName().equals(existingItem.getItemName())){
                product.setQuantityOfProduct(product.getQuantityOfProduct()+existingItem.getItemQuantity());
                productService.saveEditProduct(product);
                shoppingItemService.deleteItem(existingItem.getShoppingItemId());
            }
        }
        return new RedirectView("/shoppingList");
    }

//    @GetMapping("/edit/{productId}")
//    public String showEditForm(@PathVariable("productId") Long productId, Model model) {
//        ProductModel existingProduct = productService.findById(productId);
//        model.addAttribute("existingProduct", existingProduct);
//        return "editProductView";
//    }

//    @PostMapping("/products/save")
//    public RedirectView saveProduct(ProductModel editProduct){
//        productService.saveEditProduct(editProduct);
//        return new RedirectView("/");
//    }
}
