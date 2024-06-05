package com.QOBOX.web.bdd.stepdefinations;

import com.QOBOX.web.bdd.screens.JioMartPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class JioMartSteps {
	JioMartPage pagObj = new JioMartPage();
	@Given("User is in jiomart web application")
	public void user_is_in_jiomart_web_application() {
		pagObj.url();
	}

	@When("User clicks on Sign In")
	public void user_clicks_on_sign_in() {
		pagObj.clicksOnSignIn();
	}

	@Then("User should able to see {string} in Sign In page")
	public void user_should_able_to_see_sign_in_page(String string) {
		pagObj.seeSignInPage(string);
	}

	@When("User enters an invalid mobile number as {string}")
	public void user_enters_an_invalid_mobile_number_as(String string) throws InterruptedException {
		pagObj.entInvalidMblNum(string);
	}

	@Then("User should able to see Get OTP button is not enabled")
	public void user_should_able_to_see_get_otp_button_is_not_enabled() {
		pagObj.verifyDisabledSendOTPbutton();
	}

	@When("User enters as valid mobile number as {string}")
	public void user_enters_as_valid_mobile_number_as(String string) {
		pagObj.entValidMblNum(string);
	}

	@When("User clicks on Get OTP button")
	public void user_clicks_on_get_otp_button() {
		pagObj.clicksOnGetOTP();
	}

	@When("User enters invalid otp in the field")
	public void user_enters_invalid_otp_in_the_field() {
		pagObj.entInvalidOTP();
	}

	@Then("User should able to see Verify button is not enabled")
	public void user_should_able_to_see_get_started_button_is_not_enabled() {
		pagObj.verifyDisabledVrfyBtn();
	}

	@When("User enters valid otp in the field")
	public void user_enters_valid_otp_in_the_field() throws InterruptedException {
		pagObj.entValidOTP();
	}

	@When("User clicks on Verify button")
	public void user_clicks_on_verify_button() throws InterruptedException {
		pagObj.clicksOnVerifyBtn();
	}

	@Then("User should able to see the their name in My Account page")
	public void user_should_able_to_see_the_their_name_in_my_account_page() throws InterruptedException {
		pagObj.verifyNameInMyAccPage();
	}

	@When("User mouse hovers on the Groceries")
	public void user_mouse_hovers_on_the_groceries() throws Exception {
		pagObj.mouseHvrsGroceries();
	}

	@When("User mouse hovers on every item of the groceries list")
	public void user_mouse_hovers_on_every_item_of_the_groceries_list() {
		pagObj.mousehvrsOnEvyItemOfGRCSList();
	}

	@Then("User should able to stop at Fruits and Vegetable and see the different categories of it")
	public void user_should_able_to_stop_at_fruits_and_vegetable_and_see_the_different_of_it() {
		pagObj.ableToSeeDifCatListFFV();
	}

	@When("user clicks on Fresh Vegetables")
	public void user_clicks_on_fresh_vegetables() {
		pagObj.clickOnFreshVeg();
	}

	@Then("User should able to see Fresh Vegetables Page")
	public void user_should_able_to_see_fresh_vegetables_page() {
		pagObj.freshVegPage();
	}

	@When("User scroll down and up to verify scroll action")
	public void user_scroll_down_and_up_to_verify_scroll_action() throws InterruptedException {
		pagObj.scrollUpAndDownFVP();
	}

	@When("User click on the Capsicum check box")
	public void user_click_on_the_capsicum_check_box() {
		pagObj.clicksOnCapChkBox();
	}

	@When("User clicks on Capsicum")
	public void user_clicks_on_capsicum() {
		pagObj.clicksOnCapsicum();
	}

	@Then("User should able to see {string}")
	public void user_should_able_to_see_string(String string) {
		pagObj.ableToSeeGrnCapPage(string);
	}

	@When("User clicks on Additional Offers")
	public void user_clicks_on_additional_offers() {
		pagObj.addOffersofCap();
	}

	@When("User clicks on close button of Additonal Offers")
	public void user_clicks_on_close_button_of_additonal_offers() {
		pagObj.addoofersOfCloseBtnOfCap();
	}

	@When("User clicks on Add To Cart button")
	public void user_clicks_on_add_to_cart_button() throws InterruptedException {
		pagObj.clicksOnAddToCart();
	}

	@Then("User should able to see a flash msg as {string}")
	public void user_should_able_to_see_a_flash_msg_as_string(String string) {
		pagObj.ableToSeeAddedT0CartMsg(string);
	}

	@When("User clicks on Search bar")
	public void user_clicks_on_search_bar() {
		pagObj.clicksOnSearchBar();
	}

	@When("User types the {string} in the bar")
	public void user_types_the_in_the_bar_and_clicks_on_the_pasta(String string) {
		pagObj.typesPasta(string);
	}

	@When("clicks on the pasta from the drop down")
	public void clicks_on_the_pasta_from_the_drop_down() {
		pagObj.clksPasFromDropDown();
	}

	@When("User clicks the checkbox of Pasta & Macaroni under sub Categories")
	public void user_clicks_the_checkbox_of_pasta_macaroni_under_sub_categories() {
		pagObj.clicksCHkBoxPM();
	}

	@When("User clicks on other brands under brand")
	public void user_clicks_on_other_brands_under_brand() throws InterruptedException {
		pagObj.CksOtherBrands();
	}

	@Then("User should able to see brands {string} page")
	public void user_should_able_to_see_page(String string) {
		pagObj.ableToSeeSelectBrandPage(string);
	}

	@When("User clicks on Maggie check box")
	public void user_clicks_on_maggie_check_box() {
		pagObj.clicksOnMaggieChkBOx();
	}

	@When("User clicks Apply button")
	public void user_clicks_apply_button() {
		pagObj.clicksOnApplyBtn();
	}

	@When("User Clicks on  Maggi Pazzta Cheese Macaroni {int} g")
	public void user_clicks_on_maggi_pazzta_cheese_macaroni_g(Integer int1) {
		pagObj.clicksOnMaggiePastaMac();
	}

	@Then("User should able to see maggie {string}  page")
	public void user_should_able_to_see_maggie_page(String string) {
		pagObj.ableToSeeMagPasMacPage(string);
	}

	@When("User clicks on the Electronics")
	public void user_clicks_on_the_electronics() {
		pagObj.clicksOnElectronics();
	}

	@Then("User should able to see the {string} page")
	public void user_should_able_to_see_the_page(String string) {
		pagObj.ableToSeeElecPages(string);
	}

	@When("User clicks on Mobiles & Tablets drop down")
	public void user_clicks_on_mobiles_tablets_drop_down() {
		pagObj.clicksOnMblAndTabs();
	}

	@When("User clicks on Smartphones")
	public void user_clicks_on_smartphones() {
		pagObj.clicksOnSmrtPhns();
	}

	@Then("User should able to see {string} page")
	public void user_should_able_to_see_smart_Phn_page(String string) {
		pagObj.ableToSeeSmrtPhnPage(string);
	}

	@When("User clicks on sort by Popularity")
	public void user_clicks_on_sort_by_popularity() {
		pagObj.srtByPop();
	}

	@When("User selects the Price: High to Low radio button")
	public void user_selects_the_price_high_to_low_radio_button() {
		pagObj.highToLoww();
	}

	@When("User clicks on Apple checkbox under the brand")
	public void user_clicks_on_apple_checkbox_under_the_brand() {
		pagObj.ClicksOnAplChkBox();
	}

	@When("User clicks on EDGE under the phone network")
	public void user_clicks_on_edge_under_the_phone_network() {
		pagObj.ClicksOnEdgeChkBox();
	}

	@When("User clicks on Dual SIM under the sim type")
	public void user_clicks_on_dual_sim_under_the_sim_type() {
		pagObj.ClicksOnSimChkBox();
	}

	@When("User clicks on Apple iPhone {int} {int} GB, Red")
	public void user_clicks_on_apple_i_phone_gb_red(Integer int1, Integer int2) throws InterruptedException {
		pagObj.iphoneRed();
	}

	@Then("User should able to see the {string} page on the screen")
	public void user_should_able_to_see_the_page_on_the_screen(String string) {
		pagObj.ableToSeeIphoneRedPage(string);
	}

	@When("User clicks small pic to view all sides of the iphone")
	public void user_clicks_small_pic_to_view_all_sides_of_the_iphone() {
		pagObj.viewAllSidesOfPhn();
	}

	@Given("User logged in to jio mart web application")
	public void user_logged_in_to_jio_mart_web_application() throws InterruptedException {
		pagObj.loggedIn();
	}

	@When("User clicks on account profile")
	public void user_clicks_on_account_profile() {
		pagObj.clicksOnAccPro();
	}

	@Then("User able to see MyAccount page {string}")
	public void user_able_to_see_my_account_page(String string) {
		pagObj.ableToSeeAccPag(string);
	}

	@When("User clicks on Delivery Addresses")
	public void user_clicks_on_delivery_addresses() {
		pagObj.clksDeliveryAdd();
	}

	@When("User clicks on Add New Address button")
	public void user_clicks_on_add_new_address_button() {
		pagObj.ClksOnAddNewAddress();
	}

	@Then("User able to see the {string} page on the right side")
	public void user_able_to_see_the_page_on_the_right_side(String string) {
		pagObj.ableToSeeAddAddressPag(string);
	}

	@When("User clicks on Type your Address button")
	public void user_clicks_on_type_your_address_button() {
		pagObj.typeYourAddBtn();
	}

	@When("user enters the insufficent data")
	public void user_enters_the_insufficent_data(DataTable dataTable) {
		pagObj.entersIncomDetails(dataTable);
	}
	@When("User clicks on Save Address button")
	public void user_clicks_on_sve_address_button() {
		pagObj.clksOnSaveAddressBtn();
	}

	@Then("User should able to see the {string} error message")
	public void user_should_able_to_see_the_error_message(String string) {
		pagObj.saveAddressMsg(string);
	}
	@When("User clicks on menu icon")
	public void user_clicks_on_menu_icon() {
		pagObj.clicksOnMenuIcon();
	}

	@When("User clicks on FAQs\\/Need Help")
	public void user_clicks_on_fa_qs_need_help() {
		pagObj.clicksOnFaqs();
	}

	@Then("User should able to see FAQs\\/Need Help page with heading as  {string}")
	public void user_should_able_to_see_fa_qs_need_help_page_with_heading_as(String string) {
		pagObj.ableToSeeFAQPagHead(string);
	}

	@When("User clicks on the Can I call and place an order question")
	public void user_clicks_on_the_can_i_call_and_place_an_order_question() {
		pagObj.clicksOnQues();
	}

	@Then("User should able to see the answer of the above question")
	public void user_should_able_to_see_the_answer_of_the_above_question() {
		pagObj.ableToSeeAns();
	}

	@When("User scrolls the page to all the avaible questions")
	public void user_scrolls_the_page_to_all_the_avaible_questions() {
		pagObj.scrollFaqPage();
	}

	@When("User clicks on About Us")
	public void user_clicks_on_about_us() {
		pagObj.clicksOnAbtUsBtn();
	}

	@Then("User should able to see {string}  page")
	public void user_should_able_to__see_page(String string) {
		pagObj.ableToSeeAboutUsPage(string);
	}
	@When("User clicks on search menu icon")
	public void user_clicks_on_search_menu_icon() {
	    pagObj.cliksOnSearchList();
	}

	@Then("User able to {string} search modal")
	public void user_able_to_string_search_modal(String string) {
	    pagObj.ableToSeeSrchLstModal(string);
	}

	@When("User enters special characters in the field {string}")
	public void user_enters_special_characters_in_the_field(String string) {
	    pagObj.searchListInput(string);
	}
	
	@When("User clicks on Search All button")
	public void user_clicks_on_search_all_button() {
	   pagObj.clicksOnSearchAll();
	}

	@Then("User should able to see the  {string} page")
	public void user_should_able_to_see_the__page(String string) {
	    pagObj.noProductsFound(string);
	}
	@When("User clicks on cart icon")
	public void user_clicks_on_cart_icon() {
	    pagObj.clicksOnCartIcon();
	}

	@Then("User should able to see all the cart items in cart")
	public void user_should_able_to_see_all_the_cart_items_in_cart() {
	    pagObj.cartPage();
	}

	@When("User click on account")
	public void user_click_on_account() {
	    pagObj.clicksonAcc();
	}

	@When("User clicks on Sign Out")
	public void user_clicks_on_sign_out() {
	    pagObj.singout();
	    pagObj.clicksOnSingout();
	}

	@Then("User should able to log out")
	public void user_should_able_to_log_out() {
	    pagObj.loggedOut();
	}




}
