package pom;

import Generic.CommonLib;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;

public class ContactPage {

    @FindBy(xpath = "//a[text()='Submit']")
    private WebElement btnSubmit;

    @FindBy(xpath = "//span[text()='Forename is required']")
    private WebElement forNameMsg;


    @FindBy(xpath = "//span[text()='Email is required']")
    private WebElement emailMsg;

    @FindBy(xpath = "//span[text()='Message is required']")
    private WebElement commentMsg;

    @FindBy(xpath = "//input[@id='forename']")
    private WebElement txtForName;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement txtEmail;

    @FindBy(xpath = "//textarea[@id='message']")
    private WebElement txtMsg;

    @FindBy(xpath = "//div[@class='nav-home']")
    private WebElement home;

    @FindBy(xpath = "//li[@id='alert alert-success']")
    private WebElement successMsg;

    public ContactPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    CommonLib cl = new CommonLib();

    public  void verifyMandatoryField(){
        cl.clickOnElement(btnSubmit,"Submit button");
        cl.verifyText(forNameMsg,"Forename is required");
        cl.verifyText(emailMsg,"Email is required");
        cl.verifyText(commentMsg,"Message is required");
    }
    public void enterValueCheckMessage(){
        cl.enterValue(txtForName,"Test","Forname");
        cl.enterValue(txtEmail,"Test@gmmail.com","Email");
        cl.enterValue(txtMsg,"Test12123","Message");
        Assert.assertTrue(cl.validateElementNotPresent(forNameMsg));
        Assert.assertTrue(cl.validateElementNotPresent(emailMsg));
        Assert.assertTrue(cl.validateElementNotPresent(commentMsg));
        cl.clickOnElement(btnSubmit,"Submit button");
    }
    public  void submitContact(){
        cl.verifyText(forNameMsg,"Forename is required");
        cl.verifyText(emailMsg,"Email is required");
        cl.verifyText(commentMsg,"Message is required");
        cl.clickOnElement(btnSubmit,"Submit button");
    }
    public void validateSuccessMessage(){
        Assert.assertTrue(cl.validateElementPresent(successMsg));
        cl.clickOnElement(home, "Home button");
    }
}
