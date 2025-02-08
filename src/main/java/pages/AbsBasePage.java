package pages;

import org.openqa.selenium.WebDriver;

public abstract class AbsBasePage {

    protected   WebDriver driver;
    private String path;
    public AbsBasePage(WebDriver driver, String path){
        this.driver = driver;
    }
    public  void  open () {

        driver.get("");
    }


}
