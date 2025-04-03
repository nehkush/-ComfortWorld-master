package com.app.service;

import com.app.model.ProductIssue;

import java.util.List;
import java.util.Optional;

public interface IProductIssueService {

    // Create
    ProductIssue createProductIssue(ProductIssue productIssue);

    // Read
    Optional<ProductIssue> getProductIssueById(Long id);

    List<ProductIssue> getAllProductIssues();

    // Update
    ProductIssue updateProductIssue(Long id, ProductIssue updatedProductIssue);

    // Delete
    void deleteProductIssue(Long id);

    // Additional methods (if needed)
    // Example: Find product issues by category
    List<ProductIssue> getProductIssuesByCategory(String category);
}
