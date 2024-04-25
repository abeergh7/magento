package MyTestCases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUp extends parameters {
	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void mySetUp() {

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	@Test(enabled = false)
	public void myFirstTest() {

		driver.get("https://magento.softwaretestingboard.com/");
		driver.findElement(By.linkText("Create an Account")).click();

		WebElement firstName = driver.findElement(By.id("firstname"));
		WebElement lastName = driver.findElement(By.id("lastname"));
		WebElement Email = driver.findElement(By.id("email_address"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement confirmPassword = driver.findElement(By.id("password-confirmation"));
		WebElement creatAccountButtonElement = driver.findElement(By.cssSelector("button[title='Create an Account']"));
		// creatAccountButtonElement.click();

		firstName.sendKeys(firstNames[randomIndex]);
		lastName.sendKeys(lastNames[randomIndex]);
		Email.sendKeys(emailId);
		password.sendKeys(commonpassword);
		confirmPassword.sendKeys(commonpassword);
		creatAccountButtonElement.click();

		String welcomeMsg = driver.findElement(By.className("message-success")).getText();

		assertEquals(welcomeMsg, "Thank you for registering with Main Website Store.");
	}

	@Test(priority = 2, enabled = false)
	public void logoutTest() {

		driver.get("https://magento.softwaretestingboard.com/customer/account/logout/\"");

		assertEquals(driver.getCurrentUrl().contains("logoutSuccess"), true);

	}

	@Test(priority = 3, enabled = false)
	public void loginProcess() throws InterruptedException {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys(emailId);
		;
		driver.findElement(By.id("pass")).sendKeys(commonpassword);
		;
		driver.findElement(By.id("send2")).click();

		Thread.sleep(3000);
		String welcomeMessage = driver.findElement(By.cssSelector(".greet.welcome")).getText();
		assertEquals(welcomeMessage.contains("Welcome"), true);

	}

	@Test(priority = 4, enabled = true)
	public void addRandomItem() throws InterruptedException {

		driver.get("https://magento.softwaretestingboard.com/");
//		WebElement footer= driver.findElement(By.cssSelector(".footer.content"));
//		int theNumberOfATag=footer.findElements(By.tagName("a")).size();
//		System.out.println(	theNumberOfATag);
//		int theNumberOfH1Tag=driver.findElements(By.tagName("h1")).size();
//		System.out.println(	theNumberOfH1Tag);
//=================================================================
		WebElement itemcontainer = driver.findElement(By.cssSelector(".product-items.widget-product-grid"));// orderlist
		int numberofItems = itemcontainer.findElements(By.tagName("li")).size();
		int randomItemToSelect = rand.nextInt(4);
		System.out.println(randomItemToSelect);
		itemcontainer.findElements(By.tagName("li")).get(randomItemToSelect).click();
		Thread.sleep(2000);

		WebElement sizeContainer = driver.findElement(By.cssSelector(".swatch-attribute.size"));
		int theSizes = sizeContainer.findElements(By.cssSelector(".swatch-option")).size();
		sizeContainer.findElements(By.cssSelector(".swatch-option")).get(rand.nextInt(theSizes)).click();
		Thread.sleep(3000);

		WebElement colorContainer = driver.findElement(By.cssSelector(".swatch-attribute.color"));
		int theColor = colorContainer.findElements(By.cssSelector(".swatch-option")).size();
		colorContainer.findElements(By.cssSelector(".swatch-option")).get(rand.nextInt(theColor)).click();
		Thread.sleep(3000);
		driver.findElement(By.id("product-addtocart-button")).click();
		Thread.sleep(3000);

		String ActualMsg = driver.findElement(By.className("messages")).getText();
		assertEquals(ActualMsg.contains("You added"), true);
		
	}
}
