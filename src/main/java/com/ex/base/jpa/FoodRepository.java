package com.ex.base.jpa;
import com.ex.base.entity.food;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends CrudRepository<food, Long> {
}


