package com.example.clotheswarehouse.controllers;

import com.example.clotheswarehouse.models.Item;
import com.example.clotheswarehouse.models.Brand;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ItemController {
    private static final String ADD_ITEM_FORM = "add-item-form";
    private static final String ERROR = "error";

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("item", new Item());
        model.addAttribute("brands", Brand.values());
        return ADD_ITEM_FORM;
    }

    @PostMapping("/")
    public String submitForm(@ModelAttribute Item item, Model model) {
        if (item.getPrice() <= 1000) {
            model.addAttribute(ERROR, "Price should be more than 1000");
            return ADD_ITEM_FORM;
        }
        if (!isValidBrand(item.getBrand())) {
            model.addAttribute(ERROR, "Invalid brand");
            return ADD_ITEM_FORM;
        }
        if (item.getYearOfCreation() <= 2021) {
            model.addAttribute(ERROR, "Year of creation should be more than 2021");
            return ADD_ITEM_FORM;
        }
        
        model.addAttribute("item", new Item());
        model.addAttribute("brands", Brand.values());
        model.addAttribute("success", "Item added successfully");
        return ADD_ITEM_FORM;
    }

    private boolean isValidBrand(Brand brand) {
        for (Brand b : Brand.values()) {
            if (b.equals(brand)) {
                return true;
            }
        }
        return false;
    }
}