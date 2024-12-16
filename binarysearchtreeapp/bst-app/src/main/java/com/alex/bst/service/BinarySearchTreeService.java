package com.alex.bst.service;

import com.alex.bst.model.BinarySearchTree;
import com.alex.bst.model.StoredTree;
import com.alex.bst.repository.TreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BinarySearchTreeService {

    private final TreeRepository treeRepository;

    @Autowired
    public BinarySearchTreeService(TreeRepository treeRepository) {
        this.treeRepository = treeRepository;
    }

    public String createBinarySearchTree(List<Integer> numbers) {
        BinarySearchTree bst = new BinarySearchTree();
        for (int number : numbers) {
            bst.insert(number);
        }

        String treeStructure = bst.toJson();

        StoredTree storedTree = new StoredTree();
        storedTree.setInputNumbers(numbers.toString());
        storedTree.setTreeStructure(treeStructure);
        treeRepository.save(storedTree);

        return treeStructure;
    }

    public List<StoredTree> getAllPreviousTrees() {
        return treeRepository.findAll();
    }

}