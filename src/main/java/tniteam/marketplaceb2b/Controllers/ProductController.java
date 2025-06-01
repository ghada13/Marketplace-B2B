package tniteam.marketplaceb2b.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tniteam.marketplaceb2b.dao.ProductRepository;
import tniteam.marketplaceb2b.model.Product;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id " + id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product updated) {
        return productRepository.findById(id).map(product -> {
            product.setName(updated.getName());
            product.setPrice(updated.getPrice());
            product.setQuantity(updated.getQuantity());
            return productRepository.save(product);
        }).orElseThrow(() -> new RuntimeException("Product not found with id " + id));
    }
}