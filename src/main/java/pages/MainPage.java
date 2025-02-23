package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPage extends AbsBasePage {


    public MainPage(WebDriver driver)  {
        super(driver, "/training.html");
    }

    private  By theacherItenmLocator = By.xpath("//div[@class='sc-1vudvvv-6 gWhoVo']");
                                                            //div[contains(@class,'sc-1vudvvv-6')][contains(@class,'gWhoVo')]
    private By emailField = By.xpath("//*[@id='email']");
    private By nameField = By.xpath("//*[@id='name']");

    private  By sendBtn = By.xpath("//form[@id='sampleForm']//button[text()='Отправить']");

    private  By input = By.xpath("//*[@id='textInput']");

    private By modalWindow = By.xpath("//*[@id='openModalBtn']");

    private By modalText = By.xpath("//div[@id='myModal']//h2[text()='Это модальное окно']");

    public void setInput(String word) {
        WebElement inputText = driver.findElement(input);
        inputText.sendKeys(word);
    }


    public void checkText (String word){
        WebElement inputText = driver.findElement(input);
        String enteredText = inputText.getAttribute("value");
        assertEquals(word, enteredText, "Текст неверный!");
    }

    public void clickOnModalWindow () {
        WebElement ModalWind = driver.findElement(modalWindow);
        ModalWind.click();

    }
    public void checkTextModalWindow (){
        WebElement modalTextElement = driver.findElement(modalText);
        String modalText = modalTextElement.getText();
        assertEquals("Это модальное окно", modalText, "Текст неверный!");
    }

    public void inputName(String word) {
        WebElement inputText = driver.findElement(nameField);
        inputText.sendKeys(word);
    }

    public void inputEmail(String word) {
        WebElement inputText = driver.findElement(emailField);
        inputText.sendKeys(word);
    }

    public  void sendBntClick(){
        WebElement sendButton = driver.findElement(sendBtn);
        sendButton.click();
    }

    public void  checkSentMessedge (String name, String email ){
        WebElement checksend = driver.findElement(By.xpath("//*[@id='messageBox']"));
        String messedge = checksend.getText();
        assertEquals("Форма отправлена с именем: " + name +" и email: "+ email, messedge, "Текст неверный!");
    }
}
