package Generic;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class CommonLib {
	public static ExtentTest testinfo;
	    public void Scroll (WebDriver driver ,int startpixel,int endpixel){
				RemoteWebDriver r = (RemoteWebDriver) driver;
				String j= "window.scrollTo("+Integer.toString(startpixel)+","+Integer.toString(endpixel)+")";

				r.executeScript(j);
		}

		public void clickOnElement(WebElement element,String objName){
				element.click();
//				testinfo.log(Status.INFO,"Successfully clicked on "+objName);
		}
		public void enterValue(WebElement element,String value, String objName){
				element.sendKeys(value);
//			testinfo.log(Status.INFO,"Successfully entered the value:- "+value+ "in "+objName);
		}
		public void verifyText(WebElement element, String expectedResult){
				String ExpResult=element.getText();
				Assert.assertEquals(element.getText(), expectedResult,"Not Verfyed");
				Reporter.log(ExpResult);
		}

		public boolean validateElementNotPresent(WebElement element){
			try{
				if(!element.isDisplayed()){
//					testinfo.log(Status.FAIL,"Message is not there");
				}
				else {
//					testinfo.log(Status.INFO,"Message is still there");
					return false;
				}
			}catch (Exception e) {
			}
			return true;
		}

	public boolean validateElementPresent(WebElement element){
		try{
			if(element.isDisplayed()){
//					testinfo.log(Status.FAIL,"Message is not there");
			}
			else {
//					testinfo.log(Status.INFO,"Message is still there");
				return false;
			}
		}catch (Exception e) {
		}
		return true;
	}



	public int getText(WebElement element){
			String txt=element.getText();
			return Integer.parseInt(txt.substring(1));
	}
	public int getValue(WebElement element){
		String txt=element.getAttribute("value");
		return Integer.parseInt(txt);
	}

}
