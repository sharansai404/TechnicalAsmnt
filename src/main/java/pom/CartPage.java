package pom;

import Generic.CommonLib;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    @FindBy(xpath = "//tbody/tr[1]/td[2]")
    private WebElement priceFirstProduct;

    @FindBy(xpath = "//tbody/tr[1]/td[3]/input")
    private WebElement quantityFirstProduct;

    @FindBy(xpath = "//tbody/tr[1]/td[4]")
    private WebElement subTotalFirstProduct;

    @FindBy(xpath = "//tbody/tr[2]/td[2]")
    private WebElement priceSecProduct;

    @FindBy(xpath = "//tbody/tr[2]/td[3]/input")
    private WebElement quantitySecProduct;

    @FindBy(xpath = "//tbody/tr[2]/td[4]")
    private WebElement subTotalSecProduct;

    @FindBy(xpath = "//tbody/tr[3]/td[2]")
    private WebElement priceThirdProduct;

    @FindBy(xpath = "//tbody/tr[3]/td[3]/input")
    private WebElement quantityThirdProduct;

    @FindBy(xpath = "//tbody/tr[3]/td[4]")
    private WebElement subTotalThirdProduct;

    @FindBy(xpath = " //tfoot/tr[1]//strong")
    private WebElement Total;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    CommonLib cl = new CommonLib();

    public int firstProductQuantity() {
       int price= cl.getValue(quantityFirstProduct);
        return price;
    }
    public int firstProductSubtotal() {
        int price= cl.getValue(subTotalFirstProduct);
        return price;
    }

    public int secProductQuantity() {
        int price= cl.getValue(quantitySecProduct);
        return price;
    }
    public int secProductSubtotal() {
        int price= cl.getValue(subTotalSecProduct);
        return price;
    }

    public int thirdProductQuantity() {
        int price= cl.getValue(quantityThirdProduct);
        return price;
    }
    public int thirdProductSubtotal() {
        int price= cl.getValue(subTotalThirdProduct);
        return price;
    }

    public int total() {
        int price= cl.getValue(Total);
        return price;
    }
    public void enterQuantity(){
        cl.enterValue(quantityFirstProduct,"2","First Product");
        cl.enterValue(quantitySecProduct,"5","Second Product");
        cl.enterValue(quantityThirdProduct,"3","Third Product");
    }


}




