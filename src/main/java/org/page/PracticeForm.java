package org.page;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigUtil;

import java.io.ObjectInputFilter;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;

public class PracticeForm extends BaseClass {
    //locators of the page
    By firstNameField=By.id("firstName");
    By lastNameField=By.id("lastName");
    By emailAddressField=By.cssSelector("input[placeholder='name@example.com']");
    By genderFemaleField=By.xpath("//label[text()='Female']");
    By genderMaleField=By.xpath("//label[text()='Male']");
    By genderOtherField=By.xpath("//label[text()='Other']");
    By mobNumField=By.cssSelector("#userNumber");
    By dobField=By.id("dateOfBirthInput");
    By dobMonthField= By.cssSelector("select.react-datepicker__month-select");
    By dobYearField=By.cssSelector("select.react-datepicker__year-select");
    By subjectField=By.cssSelector("#subjectsInput");
    By checkboxField=By.cssSelector("label[for='hobbies-checkbox-1']");
    By uploadField=By.className("form-control-file");
    By addressField=By.cssSelector("#currentAddress.form-control");
    By stateField=By.cssSelector("#react-select-3-input");
    By cityField= By.cssSelector("#react-select-4-input");
    By submitFormField=By.cssSelector("button[id='submit']");
    By actualMessageField=By.cssSelector("#example-modal-sizes-title-lg");

    //reading config file
    public static Properties myProp = ConfigUtil.getConfig("config");
    //constructor
    public PracticeForm(WebDriver driver) {
            super(driver);
        }

    //functions of practice form
        public void setFullName(String firstname, String lastname) {
            //first name
            WebElement firstName = driver.findElement(firstNameField);
            firstName.sendKeys(firstname);

            //last name
            WebElement lastName = driver.findElement(lastNameField);
            lastName.sendKeys(lastname);
        }
        public void setEmail(String emailAddress) {
            //email
            WebElement email = driver.findElement(emailAddressField);
            email.sendKeys(emailAddress);
        }
        public void clickOnGender(String gender) {
            //gender selection
            Actions actions = new Actions(driver);
            WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
            if (gender.equals("Male")) {
                WebElement maleRadioButton = driver.findElement(genderMaleField);
                actions.moveToElement(maleRadioButton).click();
                w.until(ExpectedConditions.visibilityOf(maleRadioButton));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", maleRadioButton);
            } else if (gender.equals("Female")) {
                WebElement femaleRadioButton =driver.findElement(genderFemaleField);
                actions.moveToElement(femaleRadioButton).click();
                w.until(ExpectedConditions.visibilityOf(femaleRadioButton));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", femaleRadioButton);
            } else {
                WebElement otherRadioButton =driver.findElement(genderOtherField);
                actions.moveToElement(otherRadioButton).click();
                w.until(ExpectedConditions.visibilityOf(otherRadioButton));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", otherRadioButton);
            }
        }
        public void setMobileNum(String mobileNumber) {
            //mobile number
            WebElement mobileNum = driver.findElement(mobNumField);
            mobileNum.sendKeys(mobileNumber);
        }
        public void setDOB(String month, String year, String day) {
            //date of birth
            WebElement dob = driver.findElement(dobField);
            dob.sendKeys(Keys.SPACE);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(dob));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dob);
            WebElement dobMonthSelector = driver.findElement(dobMonthField);
            Select selectMonth = new Select(dobMonthSelector);
            selectMonth.selectByVisibleText(month);
            WebElement dobYearSelector = driver.findElement(dobYearField);
            Select selectYear = new Select(dobYearSelector);
            selectYear.selectByVisibleText(year);
            WebElement dobDaySelector = driver.findElement(By.xpath("//div[contains(@class, 'react-datepicker__day--0" + day +"') and not(contains(@class, 'react-datepicker__day--outside-month'))]"));
            wait.until(ExpectedConditions.visibilityOf(dobDaySelector));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dobDaySelector);
        }
        public void setSubject(String subject1, String subject2) {
            //subject
            WebElement subjectOption= driver.findElement(subjectField);
            subjectOption.sendKeys(subject1);
            subjectOption.sendKeys(Keys.RETURN);
            subjectOption.sendKeys(subject2);
            subjectOption.sendKeys(Keys.RETURN);
        }
        public void clickOnHobbies() {
            //hobbies
            WebElement hobbiesCheckbox = driver.findElement(checkboxField);
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(25));
            wait1.until(ExpectedConditions.visibilityOf(hobbiesCheckbox));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", hobbiesCheckbox);
        }
        public void uploadPicture(String path) throws InterruptedException {
            //picture upload
            WebElement pictureFile = driver.findElement(uploadField);
            String absoluteImagePath = Paths.get(path).toAbsolutePath().toString();
            Thread.sleep(1000);
            pictureFile.sendKeys(absoluteImagePath);
        }
        public void setAddress(String address) {
            //address
            Actions actions = new Actions(driver);
            WebElement currentAddress = driver.findElement(addressField);
            actions.moveToElement(currentAddress).sendKeys(address);
        }
        public void setStateAndCity(String state, String city) throws InterruptedException {
            //state
            Actions actions = new Actions(driver);
            WebElement selectState = driver.findElement(stateField);
            Thread.sleep(1000);
            actions.moveToElement(selectState).sendKeys(state)
                    .sendKeys(Keys.RETURN);
            //city
            WebElement selectCity = driver.findElement(cityField);
            Thread.sleep(1000);
            actions.moveToElement(selectCity).sendKeys(city)
                    .sendKeys(Keys.RETURN);
        }
        public void submitForm() throws InterruptedException {
            //submit
            Actions actions = new Actions(driver);
            WebElement submitButton = driver.findElement(submitFormField);
            Thread.sleep(1000);
            actions.moveToElement(submitButton).click();
        }
        public boolean isSubmitted(){
            try {
                WebElement confirmationMessage = driver.findElement(actualMessageField);
                return confirmationMessage.isDisplayed();
            } catch (Exception e) {
                return false;
            }
        }
        public String actualSubmitMessage() throws InterruptedException {
            //actualSubmitMessage
            WebElement actualMessage = driver.findElement(actualMessageField);
            return actualMessage.getText();
        }
    }

