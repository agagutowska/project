package com.example.pantry.controller;

import com.example.pantry.model.ShelfModel;
import com.example.pantry.service.ShelfService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ShelfController {
    private final ShelfService shelfService;

    public ShelfController(ShelfService shelfService) {
        this.shelfService = shelfService;
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
}
