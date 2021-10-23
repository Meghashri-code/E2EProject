package stepDefinitions;

import java.io.IOException;

import Academy.base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class stepDefinition extends base{







@Given("Initialize the browser with chrome")
public void initialize_the_browser_with_chrome() throws IOException {
    // Write code here that turns the phrase above into concrete actions	
	driver = initializeDriver();
}

@Given("^Navigate to \"([^\"]*)\" site$")
public void navigate_to_site(String string) {
    // Write code here that turns the phrase above into concrete actions
	  driver.get(string);
	  
	  
	  
}

@Given("^click on login link in home page to land on secure sign in page$")
public void click_on_login_link_in_home_page_to_land_on_secure_sign_in_page() {
    // Write code here that turns the phrase above into concrete actions
	 LandingPage lp = new LandingPage(driver);
		lp.Login().click();
}


@When("^user enters (.+)and (.+) logs in$")
public void user_enters_and_and_logs_in(String uname, String pswd) {
    // Write code here that turns the phrase above into concrete actions
	LoginPage pg = new LoginPage(driver);
	pg.Email().sendKeys(uname);
	pg.Password().sendKeys(pswd);
	pg.submit().click();	
	
}





@Then("verify that user is successfully not logged in")
public void verify_that_user_is_successfully_logged_in() {
    // Write code here that turns the phrase above into concrete actions
	LoginPage pg = new LoginPage(driver);
	System.out.println(pg.errormsg().getText());
	driver.close();
}


}