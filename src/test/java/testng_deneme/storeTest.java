package testng_deneme;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


public class storeTest {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	@Parameters({"browser"})
	public void Setup(String browser) {
		System.out.println("Sistem Açılıyor");
		if(browser.equals("edge")) {
			System.setProperty("web.edge.driver", "drivers/msedgedriver.exe");
			driver = new EdgeDriver();		
		}else if(browser.equals("firefox")) {
			System.setProperty("web.gecko.driver", "drivers/gecko.exe");
			driver = new FirefoxDriver();
		}
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://www.automationpractice.pl/index.php");
		
		
	}
	
	@Test
	public void Test1() throws InterruptedException {
		System.out.println("Test başlıyor");
		Actions actions = new Actions(driver);
		
		actions.moveToElement(driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[3]/div/div/div[6]/ul/li[1]/a"))).perform();
		
		WebElement casualDresses = driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[3]/div/div/div[6]/ul/li[1]/ul/li[2]/ul/li[1]/a"));
		wait.until(ExpectedConditions.visibilityOf(casualDresses));
		
		casualDresses.click();
		
		WebElement listButton = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[1]/ul/li[3]/a/i"));
		wait.until(ExpectedConditions.visibilityOf(listButton));
		listButton.click();
		WebElement moreButton = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[2]/ul/li/div/div/div[3]/div/div[2]/a[2]/span"));
		wait.until(ExpectedConditions.visibilityOf(moreButton));
		moreButton.click();
		List<WebElement> images = driver.findElements(By.cssSelector("#thumbs_list_frame>li"));
		wait.until(ExpectedConditions.visibilityOfAllElements(images));
		for(int i = 0 ; i<images.size();i++) {
			actions.moveToElement(images.get(i)).perform();
			Thread.sleep(1000);
		}
		WebElement sendButton = driver.findElement(By.xpath("//*[@id=\"send_friend_button\"]"));
		wait.until(ExpectedConditions.visibilityOf(sendButton));
		sendButton.click();
		WebElement text = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div/div[1]/div/p[2]"));
		wait.until(ExpectedConditions.visibilityOf(text));
		Assert.assertEquals(text.getText(), "100% cotton double printed dress. Black and white striped top and orange high waisted skater skirt bottom.");
		System.out.println(text.getText());
		System.out.println("Test bitiyor");
		
	}
	@AfterClass
	public void exit() throws InterruptedException {
		System.out.println("Sistem Kapatılıyor");
		Thread.sleep(2000);
		
		driver.quit();
	}
	
}
