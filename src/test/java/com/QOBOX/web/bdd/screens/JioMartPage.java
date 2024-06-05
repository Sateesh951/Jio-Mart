package com.QOBOX.web.bdd.screens;

import java.sql.DriverManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;

import com.QOBOX.web.bdd.ccl.WebActions;
import com.QOBOX.web.bdd.integrations.Common_Utils.ConfigReader;
import com.QOBOX.web.bdd.integrations.Common_Utils.DriverFactory;

import io.cucumber.datatable.DataTable;

public class JioMartPage {
	DriverFactory ConfigReader = DriverFactory.getInstance();
	WebDriver driver = ConfigReader.getWebDriver();
//	Set<Cookie> cookie;
	By signInBtn = By.id("sign_in_text");
	By signInTxt = By.xpath("(//h1[@id='sign-heading'])[1]");
	By signInInput = By.xpath("//input[@id='loginfirst_mobileno']");
	By sendOTPBtn = By.xpath("//button[@id='basic-button']");
	By inputOtp0 = By.id("id_input_0");
	By inputOtp1 = By.id("id_input_1");
	By inputOtp2 = By.id("id_input_2");
	By inputOtp3 = By.id("id_input_3");
	By verifyBtn = By.xpath("//div[text()=' Verify ']");
	By proceedBtn = By.xpath("//button[text()='Proceed']");
	By nameTxt = By.xpath("//span[text()='vishnurp..']");
	By groceries = By.linkText("Groceries");
	By grcsList = By.xpath("//li[@class='header-nav-l2-item']");
	By difCatList = By.xpath("//li[@class='header-nav-l3-item']");
	By freshVeglink = By.linkText("Fresh Vegetables");
	By freVegImg = By.xpath("//img[@class='banner-image']"); 
	By capChckBox = By.xpath("//span[text()='Capsicum']");
	By cap = By.xpath("//div[text()=' Green Capsicum 500 g ']");
	By grnCap = By.xpath("//div[@id='pdp_product_name']");
	By addoffers = By.xpath("//div[text()='ADDITIONAL OFFERS']");
	By addOffCloseBtn = By.xpath("(//button[@class='jm-btn tertiary jm-icon medium CX-close'])[1]");
	By addtoCartBtn = By.xpath("//div[@class='product-image-cta-item jm-mr-s cart-btn-holder prodpage ']");
	By addedToCartMsg = By.xpath("//div[text()='Added to Cart']");
	By serchbar = By.xpath("//input[@placeholder='Search JioMart']");
	By pasDrpDwn = By.xpath("//span[text()='pasta']");
	By pasAndMacChkBox = By.xpath("//span[text()='Pasta & Macaroni']");
	By otheBrnds = By.xpath("//button[@class='jm-btn tertiary small jm-body-s-link']");
	By otheBrndsPag = By.xpath("//div[text()='Select Brand']");
	By maggieChkBox = By.xpath("(//input[@value='Maggi']//following::span)[1]");
	By appliyBtn = By.xpath("//button[@id='filter_popup_apply']");
	By pasAndMacPasta = By.xpath("//div[text()=' Maggi Pazzta Cheese Macaroni 75 g ']");
	By pasHeading = By.xpath("//div[@id='pdp_product_name']");
	By luvSym = By.xpath("//div[@id='wishlist_490642340']");
	By addWishListfMsg = By.xpath("//div[text()='Added to Wishlist']");
	By electronics = By.xpath("//a[text()='Electronics']");
	By elecPagHead = By.xpath("(//a[text()='Electronics'])[2]");
	By mblAndTab = By.xpath("(//div[@class='jm-list-content-title']//span)[1]");
	By smrtPhns = By.xpath("(//div[@class='jm-list-content-title']//a)[1]");
	By smrtPhnsPagHead = By.xpath("(//a[text()='Smartphones'])[2]");
	By popDrpDwn = By.xpath("//span[text()='Popularity']");
	By highToLow = By.xpath("(//div[@role='radio'])[2]");
	By aplChkBox = By.xpath("//span[text()='Apple']");
	By edgeChkBox = By.xpath("//span[text()='EDGE']");
	By simChkBox = By.xpath("//span[text()='Dual SIM']");
	By iphone = By.xpath("(//div[@class='plp-card-details-container'])[1]");
	By iphonePageHead = By.xpath("(//div[text()=' Apple iPhone 13 512 GB, Red '])[1]");
	By listOfViews= By.xpath("//div[@style='height: 84px; margin-bottom: 12px;']");
	By accProBtn = By.xpath("//span[@id='sign_in_text']");
	By accPagHead = By.xpath("//h5[@class='j-heading sp--m pd--vertical j-text-heading-xs ng-star-inserted']");
	By deliveryAddBtn = By.xpath("//span[text()='Delivery Addresses']");
	By addNewAddBtn = By.xpath("//div[text()=' Add New Address ']");
	By addAddPagHead = By.xpath("(//span[@class='j-text j-text-heading-xs ng-star-inserted'])[1]");
	By typeYourAdd = By.xpath("(//div[@class='j-text j-text-body-s-bold ng-star-inserted'])[2]");
	By pincodeInput= By.xpath("//input[@id='m_pin']");
	By landmarkInput = By.xpath("//input[@id='m_areaname']");
	By saveAddBtn = By.xpath("//button[@aria-label='button Save Address']");
	By saveErrMsg = By.xpath("//div[text()=' Please enter a valid address* ']");
	By menuIcon = By.xpath("//button[@id='btn_ham_menu']");
	By faqBtn = By.xpath("//span[text()='FAQs/Need Help']");
	By faqQue = By.xpath("//h5[text()='Can I call and place an order?']");
	By faqPagHead = By.xpath("//h3[text()='FAQs']");
	By faqAns = By.xpath("//div[text()='No, currently this service is not available.']");
	By abtUsBtn = By.xpath("//span[text()='About Us']");
	By abtUsPagHead = By.xpath("//strong[text()='About JioMart']");
	By srchList = By.xpath("//span[@id='btn_search_list']");
	By srchListModal = By.xpath("//div[text()='Shopping List']");
	By schLstInput = By.xpath("//textarea[@id='rel_search_val']");
	By srchAll = By.xpath("//button[text()=' Search All ']");
	By noProdMsg = By.xpath("//div[@class='dplp-coming-soon-title jm-heading-xs jm-mb-s']");
	By cartBox = By.id("btn_minicart");
//	By prcdToCrtBtn = By.xpath("//button[@aria-label='button Proceed to Cart']");
	By cartPage = By.xpath("//h1[text()='My Cart']");
	By account = By.xpath("//div[@class='col loginlinkbox order-5 ng-star-inserted']");
	By sgnOut = By.xpath("(//span[text()='Sign Out'])[1]");
	By signOutBtn = By.xpath("(//div[text()=' Sign Out '])[1]");
	
 	WebActions action = new WebActions();
	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	public void url() {
		driver.get("https://www.jiomart.com/?gclid=CjwKCAiA1fqrBhA1EiwAMU5m_3_wUqKT_6PWOtJbrG4bEx6qmGzEsPPKIULQX0l9bV477aPb4BNONhoCBTQQAvD_BwE");
	}
	public void clicksOnSignIn() {
		action.Click(signInBtn, "Sign In Button");
	}
	public void seeSignInPage(String expectedTxt) {
		String actualTxt = action.getElmText(signInTxt);
		Assert.assertEquals(actualTxt,expectedTxt );
	}
	public void entInvalidMblNum(String string) throws InterruptedException {
		Thread.sleep(5000);
		action.Click(signInInput, "Sign In Input ");
		action.sendKeys(signInInput, string);
	}
	public void verifyDisabledSendOTPbutton() {
		WebElement sndOtpBtn = driver.findElement(sendOTPBtn);
		if(!sndOtpBtn.isEnabled()) {
			System.out.println("Please enter the valid mobile number");
		}
	}
	public void entValidMblNum(String string) {
		action.sendKeys(signInInput, string);
	}
	public void clicksOnGetOTP() {
		action.Click(sendOTPBtn, "Send OTP Button");
	}
	
	public void entInvalidOTP() {
		action.sendKeys(inputOtp0, "0");
		action.sendKeys(inputOtp1, "2");
		action.sendKeys(inputOtp2, "9");
		action.sendKeys(inputOtp3, "6");
	}
	public void verifyDisabledVrfyBtn() {
		WebElement VerifyButton = driver.findElement(verifyBtn);
		if(!VerifyButton.isEnabled()) {
			System.out.println("Please enter the valid OTP");
		}
	}
	public void entValidOTP() throws InterruptedException {
		Thread.sleep(12000);
//		action.sendKeys(inputOtp0, "");
	}
	public void clicksOnVerifyBtn() throws InterruptedException {
		Thread.sleep(3000);
		action.Click(verifyBtn, "Verify Otp Button");
	}
	public void verifyNameInMyAccPage() throws InterruptedException {
		Thread.sleep(1000);
		action.Click(proceedBtn, "Procedd Button");
		String expName = "Vishnurp..";
		String actName = driver.findElement(nameTxt).getText();
		Assert.assertEquals(actName, expName);
//		cookie =DriverFactory.getInstance().getWebDriver().manage().getCookies();
		
		
	}

	public void mouseHvrsGroceries() throws Exception {
		 action.mouseHover(groceries);
	}
	public void mousehvrsOnEvyItemOfGRCSList() {
		Actions act = new Actions(driver);
		List<WebElement> grcList = driver.findElements(grcsList);
		 for(int i = 10 ; i>=0 ; i-- ) {
			 WebElement element = grcList.get(i);
			 act.moveToElement(element).build().perform();
		 }
	}
	public void ableToSeeDifCatListFFV() {
		List<WebElement> difcateList = driver.findElements(difCatList);
		for(int i = 0; i <=4 ; i++) {
			WebElement ele = difcateList.get(i);
			System.out.println(ele.getText());
		}
	}
	public void clickOnFreshVeg() {
		action.Click(freshVeglink, "Fresh Vegetables ");
	}
	public void freshVegPage() {
		WebElement  img = driver.findElement(freVegImg);
		if(img.isDisplayed()) {
			System.out.println("User successfully abled to see the fresh vegetables page");
		}
	}
	public void scrollUpAndDownFVP() throws InterruptedException {
		action.scrollDownUsingJS();
		jsExecutor.executeScript("window.scrollBy(0, -1300)");
//		Thread.sleep(1000);
	}
	public void clicksOnCapChkBox() {
		action.Click(capChckBox, "Capsicum Check Box");
	}
	public void clicksOnCapsicum() {
		jsExecutor.executeScript("window.scrollBy(0, -300)");
		action.Click(cap, "  Green Capsicum 500 g  ");
	}
	public void ableToSeeGrnCapPage(String string) {
		String actualText = action.getElmText(grnCap);
		Assert.assertEquals(actualText, string);
	}
	public void addOffersofCap() {
		action.Click(addoffers, "Addtional Offers Of Capsicum");
	}
	public void addoofersOfCloseBtnOfCap() {
		action.Click(addOffCloseBtn, "Close Button Of Addtional Offers in Capsicum");
	}
	public void clicksOnAddToCart() throws InterruptedException {
//		Thread.sleep(1000);
		action.Click(addtoCartBtn, " Add To Cart ");
	}
	public void ableToSeeAddedT0CartMsg(String string) {
//		String actTxt = action.getElmText(addedToCartMsg);
//		Assert.assertEquals(actTxt, string);
		System.out.println("added");
	}
    public void clicksOnSearchBar() {
    	action.Click(serchbar, "Search Bar");
    }
    public void typesPasta(String string) {
    	action.sendKeys(serchbar, string);
    }
    public void clksPasFromDropDown() {
    	action.Click(pasDrpDwn, "Pasta from the drop down");
    }
	public void clicksCHkBoxPM() {
		action.Click(pasAndMacChkBox, "Pasta and Macroni");
	}
	public void CksOtherBrands() throws InterruptedException {
		Thread.sleep(1000);
		action.Click(otheBrnds, "73 other brands");
	}
    public void ableToSeeSelectBrandPage(String string) {
		String actualTxt = action.getElmText(otheBrndsPag);
		Assert.assertEquals(actualTxt, string);
	}
    public void clicksOnMaggieChkBOx() {
    	action.Click(maggieChkBox, "Maggi check Box");
    }
    public void clicksOnApplyBtn() {
		action.Click(appliyBtn, "Apply Button");
	}
  
    public void clicksOnMaggiePastaMac() {
    	action.Click(pasAndMacPasta, "Maggi Pazzta Cheese Macaroni ");
    }
    public void ableToSeeMagPasMacPage(String string) {
    	String actualTxt = action.getElmText(pasHeading);
		Assert.assertEquals(actualTxt, string);
    }
    public void clicksOnElectronics() {
    	action.Click(electronics, "Electronics");
    }
    public void ableToSeeElecPages(String string) {
    	String actualTxt = action.getElmText(elecPagHead);
		Assert.assertEquals(actualTxt, string);
    }
    public void clicksOnMblAndTabs() {
    	action.Click(mblAndTab, "Mobiles And Tablets");
    }
    public void clicksOnSmrtPhns() {
    	action.Click(smrtPhns, "SmartPhones");
    }
    public void ableToSeeSmrtPhnPage(String string) {
    	String actualTxt = action.getElmText(smrtPhnsPagHead);
		Assert.assertEquals(actualTxt, string);
    }
    public void srtByPop() {
    	action.Click(popDrpDwn, "Sort By Popularity");
    }
    public void highToLoww() {
    	action.Click(highToLow, "High to Low");
    }
    public void ClicksOnAplChkBox() {
    	action.Click(aplChkBox, "Apple check box");
    }
    public void ClicksOnEdgeChkBox() {
    	action.Click(edgeChkBox, "Edge Check Box");
    }
    public void ClicksOnSimChkBox() {
    	action.Click(simChkBox, "Dual SIM Check Box");
    }
    public void iphoneRed() throws InterruptedException {
    	jsExecutor.executeScript("window.scrollBy(0, -1000)");
    	action.Click(iphone, "Apple Iphone Red");
    }
    public void ableToSeeIphoneRedPage(String string) {
    	String actualTxt = action.getElmText(iphonePageHead);
		Assert.assertEquals(actualTxt, string);
    }
    public void viewAllSidesOfPhn() {
    	List<WebElement> list = driver.findElements(listOfViews);
		for(int i = 0; i <=3 ; i++) {
			WebElement ele =list.get(i);
			ele.click();
		}
    }
    public void loggedIn() throws InterruptedException {
    	action.Click(signInBtn, "Sign In Button");
    	action.sendKeys(signInInput, "9381282113");
    	action.Click(sendOTPBtn, "Send OTP Button");
    	Thread.sleep(20000);
    	action.Click(verifyBtn, "Verify Otp Button");
    	Thread.sleep(1000);
		action.Click(proceedBtn, "Procedd Button");
//    	Iterator<Cookie> iterator= cookie.iterator();
//		while(iterator.hasNext()) {
//			System.out.println(iterator.next());
//			DriverFactory.getInstance().getWebDriver().manage().addCookie(iterator.next());
//		}
//		driver.get("https://www.jiomart.com/?gclid=CjwKCAiA1fqrBhA1EiwAMU5m_3_wUqKT_6PWOtJbrG4bEx6qmGzEsPPKIULQX0l9bV477aPb4BNONhoCBTQQAvD_BwE");
    	
    }
    public void clicksOnAccPro() {
    	action.Click(accProBtn, "Account Profile Button");
    }
    public void ableToSeeAccPag(String string) {
    	String actualTxt = action.getElmText(accPagHead);
		Assert.assertEquals(actualTxt, string);
    }
    public void clksDeliveryAdd() {
    	action.Click(deliveryAddBtn, "Delivery Addresses");
    }
    public void ClksOnAddNewAddress() {
    	action.Click(addNewAddBtn, "Add New Address");
    }
    public void ableToSeeAddAddressPag(String string) {
    	String actualTxt = action.getElmText(addAddPagHead);
		Assert.assertEquals(actualTxt, string);
    }
    public void typeYourAddBtn() {
    	action.Click(typeYourAdd, "Type Your Address");
    }
    public void entersIncomDetails(DataTable dataTable) {
    	List<Map<String, String>> data= dataTable.asMaps();
		String pincode=data.get(0).get("pincode");
		String landmark=data.get(0).get("pincode");
		action.Click(pincodeInput, "landmark");
		action.sendKeys(pincodeInput, pincode);
		action.Click(landmarkInput, "landmark");
		action.sendKeys(landmarkInput, landmark);
    }
    public void clksOnSaveAddressBtn() {
    	action.Click(saveAddBtn, "Save Address Button");
    }
    public void saveAddressMsg(String string) {
    	String actualTxt = action.getElmText(saveErrMsg);
		Assert.assertEquals(actualTxt, string);
    }
    public void clicksOnMenuIcon() {
    	action.Click(menuIcon, "Menu Icon");
    }
    public void clicksOnFaqs() {
    	action.Click(faqBtn, "FAQ/NEED HELP");
    }
    public void ableToSeeFAQPagHead(String string) {
    	String actualTxt = action.getElmText(faqPagHead);
		Assert.assertEquals(actualTxt, string);
    }
    public void clicksOnQues() {
    	action.Click(faqQue, "FAQ");
    }
    public void ableToSeeAns() {
    	WebElement ans = driver.findElement(faqAns);
    	System.out.println(ans);
    }
    public void scrollFaqPage() {
    	action.scrollDownUsingJS();
    }
    public void clicksOnAbtUsBtn() {
    	action.Click(abtUsBtn, "About Us");
    }
    public void ableToSeeAboutUsPage(String string) {
    	String actualTxt = action.getElmText(abtUsPagHead);
		Assert.assertEquals(actualTxt, string);
    }
    public void cliksOnSearchList() {
    	action.Click(srchList, "search list button");
    }
    public void ableToSeeSrchLstModal(String string) {
    	String actualTxt = action.getElmText(srchListModal);
		Assert.assertEquals(actualTxt, string);
    }
    public void searchListInput(String string) {
    	action.Click(schLstInput,"search list Input");
    	action.sendKeys(schLstInput, string);
    }
    public void clicksOnSearchAll() {
    	action.Click(srchAll, "Search All Button");
    }
    public void noProductsFound(String string) {
    	String actualTxt = action.getElmText(noProdMsg);
		Assert.assertEquals(actualTxt, string);
    }
    public void clicksOnCartIcon() {
    	action.Click(cartBox, "Proceed To Cart");
    }
    public void cartPage() {
    	String crt = action.getElmText(cartPage);
    	System.out.println(crt);
    }
    public void clicksonAcc() {
    	action.Click(account, "Account");
    }
    public void singout() {
    	action.Click(sgnOut, "Singout");
    }
    public void clicksOnSingout() {
    	action.Click(signOutBtn, "Sign Out Button");
    }
    public void loggedOut() {
//    	System.out.println("User logged out successfully");
    	WebElement txt = driver.findElement(signInTxt);
    	if(txt.isDisplayed()) {
    		System.out.println("User logged out successfully");
    	}
    }
    
    
    
    
    

	
	
	

	
}
