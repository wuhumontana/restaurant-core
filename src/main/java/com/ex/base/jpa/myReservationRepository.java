package com.ex.base.jpa;

import com.ex.base.entity.reservation;
import org.springframework.data.repository.CrudRepository;

public interface myReservationRepository extends CrudRepository<reservation, Long> {
}