package hooks;

import io.cucumber.java.After;
import utilities.DriverFactory;

public class Hooks {

    @After
    public void tearDown() {

        if (DriverFactory.driver != null) {
            DriverFactory.driver.quit();
        }
    }
}