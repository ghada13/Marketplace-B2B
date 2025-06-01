package tniteam.marketplaceb2b.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tniteam.marketplaceb2b.dao.CategoryRepository;
import tniteam.marketplaceb2b.model.Category;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping
    public Category create(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @GetMapping
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(@PathVariable int id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable int id, @RequestBody Category updatedCategory) {
        return categoryRepository.findById(id).map(category -> {
            category.setName(updatedCategory.getName());
            return ResponseEntity.ok(categoryRepository.save(category));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }










}