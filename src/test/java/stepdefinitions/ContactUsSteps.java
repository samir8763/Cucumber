package stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import com.pages.ContactUsPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsSteps {
	private ContactUsPage contactusPage=new ContactUsPage(DriverFactory.getDriver());
	
	
	@Given("user navigates to contact us page")
	public void user_navigates_to_contact_us_page() {
		DriverFactory.getDriver()
		.get("http://automationpractice.com/index.php?controller=contact");   
	}

	@When("user fills the form from given sheetname {string} and rownumber {int}")
	public void user_fills_the_form_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException 
	{
	   ExcelReader reader=new ExcelReader();
	   List<Map<String , String> >testdata=
			   reader.getData("C:\\Users\\usgr\\Desktop\\LatestCucumber6WithPOM-master\\automation.xlsx", sheetName);
	String heading=testdata.get(rowNumber).get("subjectheading");
	String email=testdata.get(rowNumber).get("email");
	String orderRef=testdata.get(rowNumber).get("orderref");
	String Message=testdata.get(rowNumber).get("message");
	contactusPage.fillContactUsForm(heading, email, orderRef, Message);
	}

	@When("user clicks on send button")
	public void user_clicks_on_send_button() {
	   contactusPage.clickSend();
	}

	@Then("it shows a successful message {string}")
	public void it_shows_a_successful_message(String expSuccMsg) {
	  String actualSuccMsg=contactusPage.getSuccessMessg();
	  Assert.assertEquals(actualSuccMsg, expSuccMsg );
	}

}
