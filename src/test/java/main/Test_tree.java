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

public class Test_tree {
    private WebDriver driver;


    @BeforeEach
    public void setUpHEadless() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-fullscreen"); // Режим полного экрана
        driver = new ChromeDriver(options);

    }

    @Test
    public void checkEmail (){
        driver.get("https://otus.home.kartushin.su/training.html");
        WebElement name = driver.findElement(By.xpath("//*[@id='name']"));
        name.sendKeys("Дмитрий");
        String namelText = name.getAttribute("value");
        //String namelText = name.getText();
        //System.out.println("имя"+ namelText);


        WebElement email = driver.findElement(By.xpath("//*[@id='email']"));

        email.sendKeys("test@test.ru");
        String emaillText = email.getAttribute("value");
        //System.out.println("почта"+ emaillText);



        WebElement sendButton = driver.findElement(By.xpath("//form[@id='sampleForm']//button[text()='Отправить']"));
        sendButton.click();
        driver.findElement(By.xpath("//*[@id='name']"));
        WebElement checksend = driver.findElement(By.xpath("//*[@id='messageBox']"));
        String messedge = checksend.getText();
        assertEquals("Форма отправлена с именем: " + namelText +" и email: "+ emaillText, messedge, "Текст неверный!");







    }
    @AfterEach
    public void tearDown() {
        // Закрытие браузера после теста
        if (driver != null) {
            driver.quit();
        }
    }
}


