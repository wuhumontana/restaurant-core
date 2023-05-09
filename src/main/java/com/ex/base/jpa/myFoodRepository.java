package com.ex.base.jpa;
import com.ex.base.entity.Food;
import org.springframework.data.repository.CrudRepository;

public interface myFoodRepository extends CrudRepository<Food, Long> {
}


