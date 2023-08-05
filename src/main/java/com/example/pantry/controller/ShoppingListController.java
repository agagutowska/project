package com.example.pantry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.pantry.model.ShoppingListModel;
import com.example.pantry.service.ShoppingListService;

@Controller
@RequestMapping
public class ShoppingListController {

    private final ShoppingListService shoppingListService;


    public ShoppingListController(ShoppingListService shoppingListService) {
        this.shoppingListService = shoppingListService;
    }

    @GetMapping("/shoppingList")
    public String showShoppingList(Model model) {
        return "shoppingList";
    }



    // ... tu mogą być dodatkowe metody, jeśli są potrzebne
}
