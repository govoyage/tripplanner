package com.govoyage.tripplanner;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by prasad on 2016/12/11.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}