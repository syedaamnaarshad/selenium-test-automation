package org.page;
import org.openqa.selenium.WebDriver;
public class BaseClass {

        protected WebDriver driver;
        //constructor
        public BaseClass(WebDriver driver) {
            this.driver = driver;
        }
}
