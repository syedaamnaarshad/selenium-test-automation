package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.page.PracticeForm;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

import static org.page.PracticeForm.myProp;

public class TestPracticeForm {
    WebDriver driver;
    PracticeForm practiceForm;
@Before
    @Given("^I am on practice form page$")
    public void i_am_on_practice_form_page() {
        driver = new ChromeDriver();
        driver.get(myProp.getProperty("weburl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        practiceForm=new PracticeForm(driver);
    }
    @When("^I enter first and last name$")
    public void i_enter_first_and_last_name() {
    //setFullName
    practiceForm.setFullName("Amna", "Arshad");
    }
    @When("^I enter email$")
    public void i_enter_email() {
        //setEmail
        practiceForm.setEmail("name@example.com");
    }
    @When("^I enter gender$")
    public void i_enter_gender() {
        //setGender
        practiceForm.clickOnGender();
    }
    @When("^I enter mobileNum$")
    public void i_enter_mobileNum() {
        //mobileNum
        practiceForm.setMobileNum("0123456789");
    }
    @When("^I enter dob$")
    public void i_enter_dob() {
        //dob
        practiceForm.setDOB("May", "2000", "15");
    }
    @When("^I enter subject$")
    public void i_enter_subject() {
        //subject
        practiceForm.setSubject("Computer Science", "Maths");
    }
    @When("^I enter hobbies$")
    public void i_enter_hobbies() {
        //hobbies
        practiceForm.clickOnHobbies();
    }
    @When("^I upload picture$")
    public void i_upload_picture() {
        //upload
        practiceForm.uploadPicture("src/test/resources/picture.webp");
    }
    @When("^I enter current address$")
    public void i_enter_current_address() {
        //address
        practiceForm.setAddress("abc street");
    }
    @When("^I enter state and city$")
    public void i_enter_state_and_city() {
        //state and city
        practiceForm.setStateAndCity("Rajasthan", "Jaipur");
    }
    @Then("^Form should be submitted successfully$")
    public void form_should_be_submitted_successfully() {
        //submit
        practiceForm.submitForm();
        //assert the message
        Assert.assertEquals("Form submission", "Thanks for submitting the form", practiceForm.actualSubmitMessage());
        System.out.println(practiceForm.actualSubmitMessage());
    }
@After
    public void tearDown() {
       driver.quit();
    }
}