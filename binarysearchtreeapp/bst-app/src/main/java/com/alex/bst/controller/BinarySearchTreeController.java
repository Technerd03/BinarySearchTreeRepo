package com.alex.bst.controller;

import com.alex.bst.model.StoredTree;
import com.alex.bst.service.BinarySearchTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class BinarySearchTreeController {

    private final BinarySearchTreeService treeService;

    @Autowired
    public BinarySearchTreeController(BinarySearchTreeService treeService) {
        this.treeService = treeService;
    }

    @GetMapping("/enter-numbers")
    public String loadInputPage() {
        return "enter-numbers.html"; // Reference to the static HTML page
    }

    @PostMapping("/process-numbers")
    public ResponseEntity<String> processNumbers(@RequestBody List<Integer> numbers) {
        String treeStructure = treeService.createBinarySearchTree(numbers);
        return ResponseEntity.ok(treeStructure);
    }

    @GetMapping("/previous-trees")
    public ResponseEntity<List<StoredTree>> getPreviousTrees() {
        return ResponseEntity.ok(treeService.getAllPreviousTrees());
    }
}