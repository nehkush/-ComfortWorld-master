package com.app.service;

import com.app.model.ProductIssue;
import com.app.repository.ProductIssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductIssueServiceImpl implements IProductIssueService {

    private final ProductIssueRepository productIssueRepository;

    @Autowired
    public ProductIssueServiceImpl(ProductIssueRepository productIssueRepository) {
        this.productIssueRepository = productIssueRepository;
    }

    @Override
    public ProductIssue createProductIssue(ProductIssue productIssue) {
        return productIssueRepository.save(productIssue);
    }

    @Override
    public Optional<ProductIssue> getProductIssueById(Long id) {
        return productIssueRepository.findById(id);
    }

    @Override
    public List<ProductIssue> getAllProductIssues() {
        return productIssueRepository.findAll();
    }

    @Override
    public ProductIssue updateProductIssue(Long id, ProductIssue updatedProductIssue) {
        if (productIssueRepository.existsById(id)) {
            updatedProductIssue.setId(id);
            return productIssueRepository.save(updatedProductIssue);
        } else {
            // Handle the case where the product issue with the given ID doesn't exist
            return null;
        }
    }

    @Override
    public void deleteProductIssue(Long id) {
        productIssueRepository.deleteById(id);
    }

    @Override
    public List<ProductIssue> getProductIssuesByCategory(String category) {
        return productIssueRepository.findByCategory(category);
    }
}
