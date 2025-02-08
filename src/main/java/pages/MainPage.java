package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends AbsBasePage {


    public MainPage(WebDriver driver)  {
        super(driver, "/");
    }

    private  By theacherItenmLocator = By.xpath("//div[@class='sc-1vudvvv-6 gWhoVo']");


}
