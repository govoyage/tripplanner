package com.govoyage.tripplanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by prasad on 2016/11/20.
 */
@Controller
public class GreetingController {

    private static final Logger log = LoggerFactory.getLogger(TripPlanner.class);

    @Autowired
    CustomerRepository repository;

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        String msg = "Nothing persisted";
        if (!"World".equals(name)) {
            msg = persistCustomer(name);
        }
        model.addAttribute("msg", msg);
        return "greeting";
    }

    public String persistCustomer(String name) {
        StringBuilder sb = new StringBuilder();
        repository.save(new Customer(name, name));
        log.info("Saved successfully");
        Customer customer = repository.findByLastName(name).get(0);
        String msg = "Loaded customer : " + customer.toString();
        log.info(msg);
        sb.append(msg);
        return sb.toString();
    }

}