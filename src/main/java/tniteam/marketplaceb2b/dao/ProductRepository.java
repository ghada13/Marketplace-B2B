package tniteam.marketplaceb2b.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tniteam.marketplaceb2b.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
