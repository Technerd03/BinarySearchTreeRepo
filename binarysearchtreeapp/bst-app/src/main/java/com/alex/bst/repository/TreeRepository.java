package com.alex.bst.repository;

import com.alex.bst.model.StoredTree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreeRepository extends JpaRepository<StoredTree, Long> {}
