package MyTestCases;

import java.util.Random;

import org.openqa.selenium.WebElement;

public class parameters {
	Random rand = new Random();
	String[] firstNames = { "Mohammed", "Ahmed", "Ali", "Fatima", "Amina", "Aisha", "Khalil", "Zainab", "Noor",
			"Abdullah" };
	String[] lastNames = { "AlMahmoud", "AlAli", "AlKhalil", "AlZein", "AlOmari", "AlMasri", "AlHussaini",
			"AlJaber", "AlAbbas", "AlSalamah" };
	String commonpassword = "Asd123!@#";

	int randomIndex=rand.nextInt(10);
	int randomEmail=rand.nextInt(999);
	String emailId=(firstNames[randomIndex]+lastNames[randomIndex]+randomEmail+"@gmail.com");

}
