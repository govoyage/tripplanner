package com.lanka_guide.tripplanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by prasad on 2016/11/20.
 */
@SpringBootApplication
public class TripPlanner {

    private static final Logger log = LoggerFactory.getLogger(TripPlanner.class);

    public static void main(String[] args) {
        SpringApplication.run(TripPlanner.class, args);
    }
}