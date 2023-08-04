	package ui;
	
	import javax.swing.JOptionPane;
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.Thread;
import java.time.Duration;
import java.util.Scanner;

import io.github.bonigarcia.wdm.WebDriverManager;
	
	public class test {
		
		public static void upload(ChromeDriver driver) throws InterruptedException {
			 
			WebElement smartFolderButt= driver.findElement(By.xpath("//*[@id=\"a_menu_3\"]"));
			smartFolderButt.click();
			WebElement toToyo= driver.findElement(By.xpath("//*[@id=\"row1grdFavSmartFolder\"]/div[3]/div/span[2]"));
			toToyo.click();
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("liMore")));
			WebElement ele = driver.findElement(By.id("liMore"));

			//Creating object of an Actions class
			Actions threeDots = new Actions(driver);

			//Performing the mouse hover action on the target element.
			threeDots.moveToElement(ele).perform();
			WebElement el = driver.findElement(By.id("148"));

			//Creating object of an Actions class
			Actions addDocument = new Actions(driver);

			//Performing the mouse hover action on the target element.
			addDocument.moveToElement(el).perform();
			
			WebElement single= driver.findElement(By.id("149"));
			single.click();
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement element1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("DOC_NO")));
			WebElement documentNumber = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("DOC_NO")));
	        documentNumber.sendKeys("122453");
	        WebElement sheetNumber = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("SHEET_NO")));
	        sheetNumber.sendKeys("someNu12");
	        WebElement docDescri = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("DOC_DESCRIPTION")));
	        docDescri.sendKeys("the eternal sunshine of the spotless mind");
	        // to upload the file 
//	        WebElement selectFile= driver.findElement(By.id("btnBrowseFile"));
//			selectFile.click();
//			Thread.sleep(10000);
	        
			WebElement chooseFile = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"file\"]")));
			chooseFile.sendKeys("Path to file");
			Thread.sleep(4500);
			WebElement add= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnAdd")));
			add.click();
		}
		
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
	        login(driver,"RITESHT","RT@sch00l");
	        upload(driver);
		}
	}
	
