package com.maryan.zenchef.repository;

import com.maryan.zenchef.model.entity.Chef;
import com.maryan.zenchef.model.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChefRepository extends JpaRepository<Chef, Long> {
}
