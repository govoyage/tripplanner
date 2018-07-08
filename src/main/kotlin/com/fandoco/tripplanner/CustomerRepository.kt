package com.fandoco.tripplanner


import org.springframework.data.repository.CrudRepository

/**
 * Created by prasad on 2016/12/11.
 */
interface CustomerRepository : CrudRepository<Customer, Long> {

    fun findByLastName(lastName: String): List<Customer>
}