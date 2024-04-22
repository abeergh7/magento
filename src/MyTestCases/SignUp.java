package MyTestCases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUp extends parameters{
	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void mySetUp() {

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	@Test()
	public void myFirstTest() {

		driver.get("https://magento.softwaretestingboard.com/");
		driver.findElement(By.linkText("Create an Account")).click();

		WebElement firstName = driver.findElement(By.id("firstname"));
		WebElement lastName = driver.findElement(By.id("lastname"));
		WebElement Email = driver.findElement(By.id("email_address"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement confirmPassword = driver.findElement(By.id("password-confirmation"));
		WebElement creatAccountButtonElement = driver.findElement(By.cssSelector("button[title='Create an Account']"));
		//creatAccountButtonElement.click();

		firstName.sendKeys(firstNames[randomIndex]);
		lastName.sendKeys(lastNames[randomIndex]);
		Email.sendKeys(emailId);
		password.sendKeys(commonpassword);
		confirmPassword.sendKeys(commonpassword);
				creatAccountButtonElement.click();

		String welcomeMsg=driver.findElement(By.className("message-success")).getText();
		

		assertEquals (welcomeMsg, "Thank you for registering with Main Website Store.");
	}

}
