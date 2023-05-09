package com.ex.base.jpa;

import com.ex.base.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface myReservationRepository extends CrudRepository<Reservation, Long> {
}