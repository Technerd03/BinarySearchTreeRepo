package com.alex.bst.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class BinarySearchTree {

    private Node root;

    static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    public String toJson() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(serializeTree(root));
        } catch (Exception e) {
            return "{}";
        }
    }

    private Map<String, Object> serializeTree(Node node) {
        if (node == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("value", node.value);
        map.put("left", serializeTree(node.left));
        map.put("right", serializeTree(node.right));
        return map;
    }
}