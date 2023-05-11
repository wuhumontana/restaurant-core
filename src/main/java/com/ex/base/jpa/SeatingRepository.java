package com.ex.base.jpa;

import com.ex.base.entity.Seating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatingRepository extends CrudRepository<Seating, Long> {
}