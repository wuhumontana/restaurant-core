package com.ex.base.jpa;

import com.ex.base.entity.customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<customer, Long> {
}