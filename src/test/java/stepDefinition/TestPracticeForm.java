package stepDefinition;

import io.cucumber.java.en.And;
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
    public void setup(){
    driver = new ChromeDriver();
    }
    @Given("^User is on practice form page$")
    public void user_is_on_practice_form_page() {
        driver = new ChromeDriver();
        driver.get(myProp.getProperty("weburl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        practiceForm=new PracticeForm(driver);
    }
    @When("^User enters first(.*) and last name(.*)$")
    public void user_enters_first_and_last_name(String firstName, String lastName) {
        // Check for the placeholder <empty> in both first and last names
        if ("<empty>".equals(firstName.trim())) {
            firstName = "";
        }
        if ("<empty>".equals(lastName.trim())) {
            lastName = "";
        }
    //setFullName
    practiceForm.setFullName(firstName, lastName);
    }
    @When("^User enters email (.*)$")
    public void user_enters_email(String email) {
        //setEmail
        practiceForm.setEmail(email);
    }
    @When("^User selects gender (.*)$")
    public void user_selects_gender(String gender) {
        //setGender
        practiceForm.clickOnGender(gender);
    }
    @When("^User enters (.*) mobileNum$")
    public void user_enters_mobileNum(String mobNum) {
        //mobileNum
        practiceForm.setMobileNum(mobNum);
    }
    @When("^User enters dob$")
    public void user_enters_dob() {
        //dob
        practiceForm.setDOB("May","2000","15");
    }
    @When("^User enters subject (.*),(.*)$")
    public void user_enters_subject(String sub1, String sub2) {
        //subject
        practiceForm.setSubject(sub1,sub2);
    }
    @When("^User selects hobbies$")
    public void user_selects_hobbies() {
        //hobbies
        practiceForm.clickOnHobbies();
    }
    @When("^User upload picture (.*)$")
    public void user_upload_picture(String path) throws InterruptedException {
        //upload
        practiceForm.uploadPicture(path);
    }
    @When("^User enters current address (.*)$")
    public void user_enters_current_address(String address) throws InterruptedException {
        //address
        practiceForm.setAddress(address);
    }
    @When("^User enters state and city (.*),(.*)$")
    public void user_enters_state_and_city(String state, String city) throws InterruptedException {
        //state and city
        practiceForm.setStateAndCity(state,city);
    }
    @When("^User clicks the submit button$")
    public void user_clicks_the_submit_button() throws InterruptedException {
        //submit
        practiceForm.submitForm();
    }
    @Then("^Form should be submitted successfully$")
    public void form_should_be_submitted_successfully() throws InterruptedException {
        //assert the submit message by comparing
        Assert.assertEquals("Form submission", "Thanks for submitting the form", practiceForm.actualSubmitMessage());
        System.out.println(practiceForm.actualSubmitMessage());
        driver.quit();
    }
    @Then("Form should not be submitted successfully")
    public void form_should_not_be_submitted_successfully() {
        //assert the submit message
        Assert.assertFalse(practiceForm.isSubmitted());
        driver.quit();
    }
    @After
    public void tearDown() {
        if(driver!=null) {
            driver.quit();
        }
    }
}