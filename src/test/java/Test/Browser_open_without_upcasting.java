package Test;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser_open_without_upcasting {
public static void main(String[] args) {
	
	WebDriver driver=WebDriverManager.chromedriver().create(); 
	//browser open pn honar ani automaticaly close pn honar 
	
	driver.get("https://www.nseindia.com/");
}
}
