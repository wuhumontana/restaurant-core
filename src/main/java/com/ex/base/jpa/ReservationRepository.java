package com.ex.base.jpa;

import com.ex.base.entity.reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<reservation, Long> {
}