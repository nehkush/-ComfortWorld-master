package com.app.controller;

import com.app.model.ProductIssue;
import com.app.service.IProductIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:5173")
@RequestMapping("/product-issues")
public class ProductIssueController {

    private final IProductIssueService productIssueService;

    @Autowired
    public ProductIssueController(IProductIssueService productIssueService) {
        this.productIssueService = productIssueService;
    }

    @PostMapping
    public ResponseEntity<ProductIssue> createProductIssue(@RequestBody ProductIssue productIssue) {
        ProductIssue createdProductIssue = productIssueService.createProductIssue(productIssue);
        return new ResponseEntity<>(createdProductIssue, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductIssue> getProductIssueById(@PathVariable Long id) {
        Optional<ProductIssue> productIssue = productIssueService.getProductIssueById(id);
        return productIssue.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<ProductIssue>> getAllProductIssues() {
        List<ProductIssue> productIssues = productIssueService.getAllProductIssues();
        return new ResponseEntity<>(productIssues, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductIssue> updateProductIssue(@PathVariable Long id, @RequestBody ProductIssue updatedProductIssue) {
        ProductIssue productIssue = productIssueService.updateProductIssue(id, updatedProductIssue);
        return productIssue != null ?
                new ResponseEntity<>(productIssue, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductIssue(@PathVariable Long id) {
        productIssueService.deleteProductIssue(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/byCategory")
    public ResponseEntity<List<ProductIssue>> getProductIssuesByCategory(@RequestParam String category) {
        List<ProductIssue> productIssues = productIssueService.getProductIssuesByCategory(category);
        return new ResponseEntity<>(productIssues, HttpStatus.OK);
    }
}
