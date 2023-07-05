	package ui;
	
	import javax.swing.JOptionPane;
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.Thread;
import java.time.Duration;
import java.util.Scanner;

import io.github.bonigarcia.wdm.WebDriverManager;
	
	public class test {
		
		public static void download(ChromeDriver driver) {
			WebElement DocumentList = driver.findElement(By.id("docLi"));
	        DocumentList.click();
	        String mainWindow = driver.getWindowHandle();
	        WebElement ITBDocButton = driver.findElement(By.xpath("//*[@id=\"docUl\"]/li/span"));
	        ITBDocButton.click(); 
	        for (String windowHandle : driver.getWindowHandles()) {
	            if (!windowHandle.equals(mainWindow)) {
	                driver.switchTo().window(windowHandle);
	                break;
	            }
	        }
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
	        By elementLocator = By.id("tab2"); 
	        WebElement FilesTab = wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
	        FilesTab.click();  
	        WebElement DownloadButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"at_0\"]/div/span[2]")));
	        DownloadButton.click();  
		}
		
		public static void login(ChromeDriver driver,String username,String password) {
			WebElement usernameField = driver.findElement(By.id("loginname"));
	        usernameField.sendKeys(username);
	        WebElement LoginButton = driver.findElement(By.id("buttonSignIn"));
	        LoginButton.click();
	        WebElement passwordField = driver.findElement(By.id("passwordpassword"));
	        passwordField.sendKeys(password);
	        WebElement LoginButtonPassword = driver.findElement(By.id("buttonSignIn"));
	        LoginButtonPassword.click();
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter OTP: ");  
	        String otp= sc.nextLine();  
	        WebElement OTPInput = driver.findElement(By.id("loginOTP"));
	        OTPInput.sendKeys(otp);
	        WebElement OTPSubmit = driver.findElement(By.xpath("//*[@id=\"login\"]/div[2]/div[2]/div[4]/input"));
	        OTPSubmit.click();
	        sc.close();
		}
	
		public static void main(String args[]) throws Exception {
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://edms.toyoindia.com:501/WrenchWebProduction/AccessControl/Login");
			driver.manage().window().maximize();
	        login(driver,"username","password");
	        download(driver);
		}
	}
	
