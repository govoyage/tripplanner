/*
package com.govoyage;

import com.govoyage.tripplanner.TripPlanner;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * Created by prasad on 2016/11/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(TripPlanner.class)
@WebIntegrationTest
public class ApplicationTest {
    private static FirefoxDriver driver;

    @BeforeClass
    public static void setUp() throws IOException {
        driver = new FirefoxDriver();

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void contextLoads() {
        driver.get("http://localhost:8080/greeting");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.id("hello"),
                "Hello, World!")
        );
    }
}
*/
