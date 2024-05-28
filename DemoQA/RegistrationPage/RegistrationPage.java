package com.demoqa.pages;

import com.demoqa.core.CommonExpectedConditions;
import com.demoqa.helpers.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RegistrationPage extends BasePage {

    public final static String URL_PATH = "https://web.archive.org/web/20180815044632/http://demoqa.com/registration";
    public final static String EXPECTED_TITLE = "Registration | Demoqa";


    @FindBy(id = "name_3_firstname")
    public WebElement firstNameField;
    @FindBy(id = "name_3_lastname")
    public WebElement lastNameField;
    @FindBy(id = "phone_9")
    public WebElement phoneNumberField;
    @FindBy(id = "username")
    public WebElement usernameField;
    @FindBy(id = "email_1")
    public WebElement emailField;
    @FindBy(id = "password_2")
    public WebElement passwordField;
    @FindBy(id = "confirm_password_password_2")
    public WebElement confirmPasswordField;
    @FindBy(name = "pie_submit")
    public WebElement submitButton;
    @FindBy(css = ".piereg_message")
    public WebElement regInfo;
    @FindBy(css = "[class='legend error']")
    public WebElement legendError;
    @FindBy(id = "description")
    public WebElement desciptionField;
    @FindBy(css = "[class='fieldset error']")
    public WebElement fieldError;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void fillFirstName(String str) {
        firstNameField.sendKeys(str);
        Assert.assertEquals(firstNameField.getAttribute("value"), str);
    }

    public void fillLastName(String str) {
        lastNameField.sendKeys(str);
        Assert.assertEquals(lastNameField.getAttribute("value"), str);

    }

    public void fillPhoneNumber(String str) {
        phoneNumberField.sendKeys(str);
        Assert.assertEquals(phoneNumberField.getAttribute("value"), str);

    }

    public void fillUsername(String str) {
        usernameField.sendKeys(str);
        Assert.assertEquals(usernameField.getAttribute("value"), str);

    }

    public void fillEmail(String str) {
        emailField.sendKeys(str);
        Assert.assertEquals(emailField.getAttribute("value"), str);

    }

    public void fillPassword(String str) {
        passwordField.sendKeys(str);
        Assert.assertEquals(passwordField.getAttribute("value"), str);

    }

    public void fillConfirmPassword(String str) {
        confirmPasswordField.sendKeys(str);
        Assert.assertEquals(confirmPasswordField.getAttribute("value"), str);

    }

    public void fillRequiredFieldsByUserCredentials(User signUpUser) {

        fillFirstName(signUpUser.getFirstName());
        fillLastName(signUpUser.getLastName());
        fillPhoneNumber(signUpUser.getPhoneNumber());
        fillUsername(signUpUser.getUsername());
        fillEmail(signUpUser.getEmail());
        fillPassword(signUpUser.getPassword());
        fillConfirmPassword(signUpUser.getPassword());
    }

    public RegistrationPage open() {
        driver.get(URL_PATH);
        wait.until(CommonExpectedConditions.pageLoaded());
        String actualTitle = driver.getTitle();
        Assert.assertEquals(EXPECTED_TITLE, actualTitle);
        return this;
    }

    public void submitData() {
        submitButton.click();
    }

    public boolean isRegistrationSuccessfull() {
        return regInfo.getText().equals("Thank you for your registration");
    }

    public boolean isRegistrationFailedByEmail() {
        return regInfo.getText().equals("Email already exists");
    }

    public void setFocusToDescription() {
        desciptionField.click();
    }

    public void verifyErrorMessageOnElement(WebElement element) {
        element.clear();
        setFocusToDescription();
        Assert.assertTrue(doesElementHaveErrorMessage(element));
    }
}
