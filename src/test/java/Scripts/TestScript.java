package Scripts;

import Generic.CommonLib;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

import Generic.BaseLib;
import pom.CartPage;
import pom.ContactPage;
import pom.HomePage;
import pom.ProductPage;

public class TestScript extends BaseLib{


	@Test
	public void verifyMandatoryField() {
		HomePage hp = new HomePage(driver);
		ContactPage cp = new ContactPage(driver);
		hp.clickOnContact();
		cp.verifyMandatoryField();
		cp.enterValueCheckMessage();
	}

	@Test(invocationCount = 5)
	public void contactSubmission(){
		HomePage hp = new HomePage(driver);
		ContactPage cp = new ContactPage(driver);
		hp.clickOnContact();
		cp.submitContact();
		cp.validateSuccessMessage();
	}

	@Test
	public void priceValidation(){
		ProductPage pp = new ProductPage(driver);
		HomePage hp = new HomePage(driver);
		CartPage cartPage = new CartPage(driver);
		hp.clickOnShopping();
		int firstprod=pp.StuffedFrogPriceAndAddToCart();
		int sectprod=pp.fluffyPriceAndAddToCart();
		int thirdProd=pp.valentinePriceAndAddToCart();
		cartPage.enterQuantity();
		int q1=cartPage.firstProductQuantity();
		if(q1*firstprod==cartPage.firstProductSubtotal()){
			testinfo.log(Status.INFO,"Subtotal of first product has verified");
		}
		else {
			testinfo.log(Status.FAIL,"Subtotal of first product iss not correct "+cartPage.firstProductSubtotal());
		}
		int q2=cartPage.secProductQuantity();

		if(q2*firstprod==cartPage.secProductSubtotal()){
			testinfo.log(Status.INFO,"Subtotal of second product has verified");
		}
		else {
			testinfo.log(Status.FAIL,"Subtotal of second product is not correct "+cartPage.secProductSubtotal());
		}
		int q3 = cartPage.thirdProductQuantity();

		if(q3*firstprod==cartPage.thirdProductSubtotal()){
			testinfo.log(Status.INFO,"Subtotal of third product has verified");
		}
		else {
			testinfo.log(Status.FAIL,"Subtotal of third product is not correct "+cartPage.thirdProductQuantity());
		}

		if((q1+q2+q3)==cartPage.total()){
			testinfo.log(Status.INFO,"Total of product has verified");
		}
		else {
			testinfo.log(Status.FAIL,"Total of product is not correct "+cartPage.total());
		}


	}




}
