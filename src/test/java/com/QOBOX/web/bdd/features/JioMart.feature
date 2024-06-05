@jiomart
Feature: Verify and Validate Jio Mart web application

Background: 
Given User is in jiomart web application


@invalidMblNum
Scenario Outline: <TC_RC> Verify login functionality with invalid mobile number
When User clicks on Sign In
Then User should able to see "Sign in to JioMart" in Sign In page
When User enters an invalid mobile number as "<mobileNumber>"
Then User should able to see Get OTP button is not enabled

Examples:
| TC_RC | mobileNumber |
| TC_RC_001 | 938128211 |
| TC_RC_001.2 | 000000000 |
| TC_RC_001.3 | #$@$%@^^@& |
| TC_RC_001.4 | 987 |

@loginJioMart
Scenario: TC_RC_002 Verify login functionality with invalid otp 
When User clicks on Sign In
Then User should able to see "Sign in to JioMart" in Sign In page
When User enters as valid mobile number as "6302276471" 
And User clicks on Get OTP button
And User enters invalid otp in the field 
Then User should able to see Verify button is not enabled

@ValidLogin
Scenario: TC_RC_003 Verify login functionality with valid credentials
When User clicks on Sign In
Then User should able to see "Sign in to JioMart" in Sign In page
When User enters as valid mobile number as "9381282113" 
And User clicks on Get OTP button
And User enters valid otp in the field 
And User clicks on Verify button
Then User should able to see the their name in My Account page

@groceries
Scenario: TC_RC_004 Verify Groceries functionality 
When User mouse hovers on the Groceries 
And User mouse hovers on every item of the groceries list 
Then User should able to stop at Fruits and Vegetable and see the different categories of it 
When user clicks on Fresh Vegetables 
Then User should able to see Fresh Vegetables Page
When User scroll down and up to verify scroll action
And User click on the Capsicum check box
When User clicks on Capsicum
Then User should able to see "Green Capsicum 500 g"
When User clicks on Additional Offers 
And User clicks on close button of Additonal Offers 
And User clicks on Add To Cart button
Then User should able to see a flash msg as "Added to Smart Bazaar Cart"

@searchPositive
Scenario: TC_RC_005 Verify the search functionality 
When User clicks on Search bar 
And User types the "pasta" in the bar 
And clicks on the pasta from the drop down
When User clicks the checkbox of Pasta & Macaroni under sub Categories 
And User clicks on other brands under brand
Then User should able to see brands "Select Brand" page
When User clicks on Maggie check box 
And User clicks Apply button 
When User Clicks on  Maggi Pazzta Cheese Macaroni 75 g 
Then User should able to see maggie "Maggi Pazzta Cheese Macaroni 75 g"  page 
And User clicks on Add To Cart button
Then User should able to see a flash msg as "Added to Cart"

@electronics
Scenario: TC_RC_006 Verify Electronics functionality 
When User clicks on the Electronics
Then User should able to see the "Electronics" page
When User clicks on Mobiles & Tablets drop down
And User clicks on Smartphones 
Then User should able to see "Smartphones" page 
When User clicks on sort by Popularity
And User selects the Price: High to Low radio button
And User clicks on Apple checkbox under the brand
And User clicks on EDGE under the phone network
And User clicks on Dual SIM under the sim type
And User clicks on Apple iPhone 13 512 GB, Red
Then User should able to see the "Apple iPhone 13 512 GB, Red" page on the screen
When User clicks small pic to view all sides of the iphone
And User clicks on Add To Cart button 
Then User should able to see a flash msg as "Added to Cart"

@addressnegative
Scenario: TC_RC_007 Verify add address functionality with imcomplete details
Given User logged in to jio mart web application
When User clicks on account profile  
Then User able to see MyAccount page "My Account"
When User clicks on Delivery Addresses
And User clicks on Add New Address button
Then User able to see the "Add Address" page on the right side
When User clicks on Type your Address button
And user enters the insufficent data 
| pincode | landmark |
| 524132 | Bhashyam |
And User clicks on Save Address button
Then User should able to see the "Please enter a valid address*" error message 

@menu
Scenario: TC_RC_008 Verify menu icon functionality
When User clicks on menu icon 
And User clicks on FAQs/Need Help
Then User should able to see FAQs/Need Help page with heading as  "FAQs"
When User clicks on the Can I call and place an order question
Then User should able to see the answer of the above question
When User scrolls the page to all the avaible questions
And User clicks on menu icon
And User clicks on About Us
Then User should able to see "About JioMart"  page
 
@searchlistnegative
Scenario:TC_RC_009 Verify search list functionality with invalid data
When User clicks on search menu icon 
Then User able to "Shopping List" search modal
When User enters special characters in the field "$$$$$$"
And User clicks on Search All button 
Then User should able to see the  "Sorry! No product found" page 

@cart
Scenario: TC_RC_010 Verify cart functionality
Given User logged in to jio mart web application
When User clicks on cart icon
Then User should able to see all the cart items in cart 
When User click on account
And User clicks on Sign Out 
Then User should able to log out 















  
