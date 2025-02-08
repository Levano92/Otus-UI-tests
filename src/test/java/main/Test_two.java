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

public class Test_two {
    private WebDriver driver;


    @BeforeEach
    public void setUpHEadless() {
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless"); // Включение headless режима
        options.addArguments("--kiosk"); // Включение режима kiosk
        driver = new ChromeDriver(options);

    }


    @Test
    public void checkModalWind (){
        driver.get("https://otus.home.kartushin.su/training.html");
        WebElement ModalWind = driver.findElement(By.xpath("//*[@id='openModalBtn']"));
        ModalWind.click();

        WebElement modalTextElement = driver.findElement(By.xpath("//div[@id='myModal']//h2[text()='Это модальное окно']"));
        String modalText = modalTextElement.getText();
        assertEquals("Это модальное окно", modalText, "Текст неверный!");
        System.out.println(modalText);


    }

    @AfterEach
    public void tearDown() {
        // Закрытие браузера после теста
        if (driver != null) {
            driver.quit();
        }
    }
}


