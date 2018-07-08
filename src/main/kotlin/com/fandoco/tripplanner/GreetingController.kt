package com.fandoco.tripplanner

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * Created by prasad on 2016/11/20.
 */
@RestController
class GreetingController {

    @Autowired
    internal var repository: CustomerRepository? = null

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", required = false, defaultValue = "World") name: String, model: Model): String {
        model.addAttribute("name", name)
        var msg = "Nothing persisted"
        if ("World" != name) {
            msg = persistCustomer(name)
        }
        model.addAttribute("msg", msg)
        return "Hello, $name"
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

        private val log = LoggerFactory.getLogger(GreetingController::class.java)
    }

}