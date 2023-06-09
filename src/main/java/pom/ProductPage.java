package pom;

import Generic.CommonLib;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    @FindBy(xpath = "//h4[text()='Stuffed Frog']/parent::div/p/a")
    private WebElement btnBuyStuffedFrog;
    @FindBy(xpath = "//h4[text()='Stuffed Frog']/parent::div/p/span")
    private WebElement priceStuffedFrog;

    @FindBy(xpath = "//h4[text()='Fluffy Bunny']/parent::div/p/a")
    private WebElement btnBuyFluffyBunny;
    @FindBy(xpath = "//h4[text()='Fluffy Bunny']/parent::div/p/span")
    private WebElement priceFluffyBunny;

    @FindBy(xpath = "//h4[text()='Valentine Bear']/parent::div/p/a")
    private WebElement btnBuyValentineBear;
    @FindBy(xpath = "//h4[text()='Valentine Bear']/parent::div/p/a")
    private WebElement priceValentineBear;

    @FindBy(xpath = "//a[contains(@href,'cart')]")
    private WebElement btnCart;

    public ProductPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    CommonLib cl = new CommonLib();
    public int StuffedFrogPriceAndAddToCart(){
        int price=cl.getText(priceStuffedFrog);
        cl.clickOnElement(btnBuyStuffedFrog,"Buy button of stuffed frog");
        return price;
    }

    public int fluffyPriceAndAddToCart(){
        int price=cl.getText(priceFluffyBunny);
        cl.clickOnElement(btnBuyFluffyBunny,"Buy button of fluffy bunny");
        return price;
    }

    public int valentinePriceAndAddToCart(){
        int price=cl.getText(priceValentineBear);
        cl.clickOnElement(btnBuyValentineBear,"Buy button of Valentine bear");
        return price;
    }

    public void clickOnCart(){
        cl.clickOnElement(btnCart, "cart button");
    }


}
