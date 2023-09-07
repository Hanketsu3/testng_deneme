package testng_deneme;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class trendyolDeneme {
	WebDriver driver;
	WebDriverWait wait;

	
	@BeforeClass
	public void Setup() {
		System.out.println("Sistem Açılıyor");
			System.setProperty("web.edge.driver", "drivers/msedgedriver.exe");
			driver = new EdgeDriver();		
			
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.trendyol.com/");		
	}
	@Test
	public void Test1() {
		WebElement erkek = driver.findElement(By.xpath("//span[text()='ERKEK']"));
		wait.until(ExpectedConditions.visibilityOf(erkek));
		erkek.click();
		scrollPage(0,500);
		WebElement urun = driver.findElement(By.xpath("(//div[@class='custom-stamp-box-wrapper'])[1]"));
		wait.until(ExpectedConditions.visibilityOf(urun));
		urun.click();
		WebElement anladimButton = driver.findElement(new By.ByCssSelector("div.campaign-button.bold"));
		wait.until(ExpectedConditions.visibilityOf(anladimButton));
		anladimButton.click();
		WebElement sepeteEkle = driver.findElement(By.className("add-to-basket"));
		wait.until(ExpectedConditions.visibilityOf(sepeteEkle));
		sepeteEkle.click();
		WebElement sepeteDevam = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[3]/div/div/div/div[2]/div/div/div[2]/a[2]"));
		sepeteDevam.click();
		WebElement uyeOlmadan = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div[2]/div/div[3]/div/button[1]"));
		wait.until(ExpectedConditions.visibilityOf(uyeOlmadan));
		uyeOlmadan.click();
		WebElement text = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div/div[1]/div/div[2]/div/div[1]/p"));
		wait.until(ExpectedConditions.visibilityOf(text));
		System.out.println(text.getText());
		Assert.assertEquals(text.getText(),"Kişisel verileriniz, siparişinizin teslimatının sağlanması ve yasal yükümlülüklerimizin yerine getirilmesi için gerekli olması nedeniyle işlenecek olup, tarafınıza ait bir üyelik hesabı oluşturulmayacaktır.");
		
	}
	@AfterClass
	public void exit() throws InterruptedException {
		System.out.println("Sistem Kapatılıyor");
		Thread.sleep(2000);
		driver.quit();
	}
	 private void scrollPage(int xOffset, int yOffset) {
	        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	        String script = String.format("window.scrollBy(%d, %d)", xOffset, yOffset);
	        jsExecutor.executeScript(script);
	    }
}
