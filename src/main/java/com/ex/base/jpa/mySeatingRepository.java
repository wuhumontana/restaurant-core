package com.ex.base.jpa;

import com.ex.base.entity.seating;
import org.springframework.data.repository.CrudRepository;

public interface mySeatingRepository extends CrudRepository<seating, Long> {
}