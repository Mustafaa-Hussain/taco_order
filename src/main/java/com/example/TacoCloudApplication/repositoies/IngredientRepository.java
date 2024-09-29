package com.example.TacoCloudApplication.repositoies;

import com.example.TacoCloudApplication.data.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
