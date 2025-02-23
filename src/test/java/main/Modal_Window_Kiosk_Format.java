package main;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.MainPage;



public class Modal_Window_Kiosk_Format {
    private WebDriver driver;


    @BeforeEach
    public void setUpHEadless() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--kiosk");
        driver = new ChromeDriver(options);

    }


    @Test
    public void checkModalWind (){
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickOnModalWindow();
        mainPage.checkTextModalWindow();


    }

    @AfterEach
    public void tearDown() {
           if (driver != null) {
            driver.quit();
        }
    }
}


