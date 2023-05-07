package com.ex.base.jpa;
import com.ex.base.entity.food;
import org.springframework.data.repository.CrudRepository;

public interface myFoodRepository extends CrudRepository<food, Long> {
}


