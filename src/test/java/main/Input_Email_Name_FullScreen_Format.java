package main;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.MainPage;



public class Input_Email_Name_FullScreen_Format {
    private WebDriver driver;


    @BeforeEach
    public void setUpHEadless() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-fullscreen");
        driver = new ChromeDriver(options);

    }

    @Test
    public void checkEmail () {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        String name = "Дмитрий";
        String email = "test@test.ru";
        mainPage.inputName(name);
        mainPage.inputEmail(email);
        mainPage.sendBntClick();
        mainPage.checkSentMessedge(name, email);
    }

        @AfterEach
        public void tearDown () {

            if (driver != null) {
                driver.quit();
            }
        }

}


