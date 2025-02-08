package main;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_one {
    private WebDriver driver;


    @BeforeEach
    public void setUpHEadless() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Включение headless режима
        driver = new ChromeDriver(options);

    }

    @Test
    public void checkTest(){
        driver.get("https://otus.home.kartushin.su/training.html");
        WebElement inputText = driver.findElement(By.xpath("//*[@id='textInput']"));
        inputText.sendKeys("ОТУС");
        String enteredText = inputText.getAttribute("value");
        assertEquals("ОТУС", enteredText, "Текст неверный!");

    }

    @AfterEach
    public void tearDown() {
        // Закрытие браузера после теста
        if (driver != null) {
            driver.quit();
        }
    }
}


