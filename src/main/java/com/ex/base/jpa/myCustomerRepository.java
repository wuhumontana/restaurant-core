package com.ex.base.jpa;

import com.ex.base.entity.customer;
import org.springframework.data.repository.CrudRepository;

public interface myCustomerRepository extends CrudRepository<customer, Long> {
}