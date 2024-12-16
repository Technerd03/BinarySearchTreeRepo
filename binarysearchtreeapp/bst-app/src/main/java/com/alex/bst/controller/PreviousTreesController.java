package com.alex.bst.controller;

import com.alex.bst.model.StoredTree; // Ensure this is the correct import for your entity
import com.alex.bst.service.BinarySearchTreeService; // Ensure this is the correct import for your service
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PreviousTreesController {
    private final BinarySearchTreeService binarySearchTreeService;

    public PreviousTreesController(BinarySearchTreeService binarySearchTreeService) {
        this.binarySearchTreeService = binarySearchTreeService;
    }

    @GetMapping("/previous-trees")
    public String getPreviousTrees(Model model) {
        List<StoredTree> trees = binarySearchTreeService.getAllPreviousTrees(); // Ensure this method exists in your service
        model.addAttribute("trees", trees);
        return "previous-trees"; // This should match your HTML file name
    }
}
