package com.ex.base.jpa;

import com.ex.base.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface myCustomerRepository extends CrudRepository<Customer, Long> {
}