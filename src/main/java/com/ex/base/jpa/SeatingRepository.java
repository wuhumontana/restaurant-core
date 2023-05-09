package com.ex.base.jpa;

import com.ex.base.entity.Seating;
import org.springframework.data.repository.CrudRepository;

public interface SeatingRepository extends CrudRepository<Seating, Long> {
}