package com.demoqa.tests;

import com.demoqa.helpers.User;
import com.demoqa.helpers.UserBuilder;
import com.demoqa.pages.RegistrationPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationPageTests extends TestTemplate {

    @Test(priority = 1)
    public void registerUserTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver).open();
        registrationPage.fillRequiredFieldsByUserCredentials(UserBuilder.createSignUpUser());
        registrationPage.submitData();
        Assert.assertTrue(registrationPage.isRegistrationSuccessfull());
    }

    @DataProvider(name = "minimumAndMaximumCharactersToInput")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{UserBuilder.createUserWithMaximumCredentials()}
                , {UserBuilder.createUserWithMinimalCredentials()}};
    }


    @Test(priority = 1, dataProvider = "minimumAndMaximumCharactersToInput"
            , description = "Testing maximum and minimum number of characters accepted for each field")
    public void maxAndMinCharsAvailableTest(User user) {

        RegistrationPage registrationPage = new RegistrationPage(driver).open();
        registrationPage.fillRequiredFieldsByUserCredentials(user);
        registrationPage.submitData();
        Assert.assertTrue(registrationPage.isRegistrationFailedByEmail());
    }

    @Test(priority = 2)
    public void testLeavingRequiredFieldsBlank() {
        RegistrationPage registrationPage = new RegistrationPage(driver).open();
        registrationPage.verifyErrorMessageOnElement(registrationPage.firstNameField);
        registrationPage.verifyErrorMessageOnElement(registrationPage.phoneNumberField);
        registrationPage.verifyErrorMessageOnElement(registrationPage.usernameField);
        registrationPage.verifyErrorMessageOnElement(registrationPage.emailField);
        registrationPage.verifyErrorMessageOnElement(registrationPage.passwordField);
        registrationPage.verifyErrorMessageOnElement(registrationPage.confirmPasswordField);
    }

    @Test(priority = 2)
    public void edFieldsBlank() {


        driver.get("https://id.q1-np.sonyentertainmentnetwork.com/signin/?ui=pr&response_type=token&scope=user%3Aaccount.authentication.mode.get%20kamaji%3Aget_account_hash%20user%3Aaccount.phone.masked.get%20user%3Aaccount.notification.create%20openid%3Acontent_ctrl%20openid%3Auser_id%20openid%3Aonline_id%20openid%3Actry_code%20openid%3Alang%20user%3Aaccount.communication.get%20oauth%3Amanage_user_auth_sessions%20openid%3Aacct_uuid%20kamaji%3Aactivity_feed_set_feed_privacy%20user%3Aaccount.identityMapper%20user%3Aaccount.email.create%20user%3Aaccount.emailVerification.get%20user%3Aaccount.tosua.update&redirect_uri=https%3A%2F%2Fid.q1-np.sonyentertainmentnetwork.com%2Fid%2Fmanagement%2F%23%2Fp%2Fsecurity%2Flist%3Fpr_referer%3Dcam%26entry%3Dsecurity&client_id=ce381e15-9cdd-4cf9-8384-0cf63db17f6a&state=44448f78eb7ad7280383338a32eb302&entry=security&error=login_required&error_code=4165&error_description=User+is+not+authenticated#/signin?entry=%2Fsignin");
        driver.findElement(By.xpath("//div[@data-components='kekka-legal-links']/div[@class='columns-center']/div[@data-components='hokkai-text-link']/button[@class='touch-feedback inline-text-footer']")).click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}

