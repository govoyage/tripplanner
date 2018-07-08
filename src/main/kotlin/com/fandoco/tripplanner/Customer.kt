package com.fandoco.tripplanner

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Created by prasad on 2016/12/11.
 */
@Entity
class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
    var firstName: String? = null
    var lastName: String? = null

    protected constructor() {}

    constructor(firstName: String, lastName: String) {
        this.firstName = firstName
        this.lastName = lastName
    }

    override fun toString(): String {
        return "Customer{" +
                "type=" + id +
                ", firstName='" + firstName + '\''.toString() +
                ", lastName='" + lastName + '\''.toString() +
                '}'.toString()
    }
}
