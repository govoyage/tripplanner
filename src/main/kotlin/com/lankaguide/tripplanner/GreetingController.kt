package com.lankaguide.tripplanner

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

/**
 * Created by prasad on 2016/11/20.
 */
@Controller
class GreetingController {

    @Autowired
    internal var repository: CustomerRepository? = null

    @RequestMapping("/greeting")
    fun greeting(@RequestParam(value = "name", required = false, defaultValue = "World") name: String, model: Model): String {
        model.addAttribute("name", name)
        var msg = "Nothing persisted"
        if ("World" != name) {
            msg = persistCustomer(name)
        }
        model.addAttribute("msg", msg)
        return "greeting"
    }

    fun persistCustomer(name: String): String {
        val sb = StringBuilder()
        repository!!.save(Customer(name, name))
        log.info("Saved successfully")
        val customer = repository!!.findByLastName(name)[0]
        val msg = "Loaded customer : " + customer.toString()
        log.info(msg)
        sb.append(msg)
        return sb.toString()
    }

    companion object {

        private val log = LoggerFactory.getLogger(TripPlanner::class.java)
    }

}