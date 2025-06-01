package tniteam.marketplaceb2b.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tniteam.marketplaceb2b.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
