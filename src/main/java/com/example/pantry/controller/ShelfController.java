package com.example.pantry.controller;

import com.example.pantry.model.ProductModel;
import com.example.pantry.model.ShelfModel;
import com.example.pantry.service.ProductService;
import com.example.pantry.service.ShelfService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ShelfController {
    private final ShelfService shelfService;
    private final ProductService productService;

    public ShelfController(ShelfService shelfService, ProductService productService) {
        this.shelfService = shelfService;
        this.productService = productService;
    }

    @GetMapping("/shelfMenu")
    public String showShelfMenu(Model model) {
        List<ShelfModel> shelves = shelfService.getAllShelves();
        model.addAttribute("shelves", shelves);
        model.addAttribute("newShelf", new ShelfModel());
        return "shelfMenu";
    }

    @PostMapping("/shelves/add")
    public String addShelf(@ModelAttribute ShelfModel shelfModel) {
        shelfService.addShelf(shelfModel);
        return "redirect:/shelfMenu";
    }

    @PostMapping("/shelves/delete/{shelfId}")
    public String deleteShelf(@PathVariable Long shelfId) {
        shelfService.deleteShelfById(shelfId);
        return "redirect:/shelfMenu";
    }

// Rzeczy z dodawaniem produktów na półki

    @GetMapping("view/{shelfId}")
    public String viewShelf(@PathVariable("shelfId") Long shelfId, Model model) {
        ShelfModel shelf = shelfService.getShelfById(shelfId);
        List<ProductModel> products = productService.getProductsByShelf(shelf);

        model.addAttribute("shelf", shelf);
        model.addAttribute("products", products);

        return "shelfView";
    }




}
