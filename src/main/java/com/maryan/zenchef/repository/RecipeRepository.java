package com.maryan.zenchef.repository;

import com.maryan.zenchef.model.entity.Chef;
import com.maryan.zenchef.model.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
//    @Query("SELECT r FROM Recipe r WHERE r.chef = ?1")
//    List<Recipe> findRecipesByChef(Long chefID);

    List<Recipe> findAllByChef(Chef chef);
}
