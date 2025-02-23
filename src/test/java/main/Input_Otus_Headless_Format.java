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

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Input_Otus_Headless_Format {
    private WebDriver driver;


    @BeforeEach
    public void setUpHEadless() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Включение headless режима
        driver = new ChromeDriver(options);

    }

    @Test
    public void checkTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        String keyWord = "ОТУС";
        mainPage.setInput(keyWord);
        mainPage.checkText(keyWord);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


