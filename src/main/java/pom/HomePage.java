package pom;

import Generic.CommonLib;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

    @FindBy(xpath = "//a[text()='Contact']")
    private WebElement lnkContact;

    @FindBy(xpath = "//a[text()='Start Shopping »']")
    private WebElement btnStartShopping;



    public HomePage(WebDriver driver){

        PageFactory.initElements(driver, this);
    }

    CommonLib cl =  new CommonLib();

    public void clickOnContact(){
        cl.clickOnElement(lnkContact,"Contact link");
    }

    public void clickOnShopping(){
        cl.clickOnElement(btnStartShopping,"Shopping button");
    }



}
