package pre_wiz;

import java.sql.SQLException;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Financial_shares {
	WebElement financial_cash;
	WebElement financial_materials;
	WebElement shares;
	
	public void insert_fin_shares(WebDriver driver,WebDriverWait wait) throws InterruptedException, ClassNotFoundException, SQLException
	{
		financial_cash=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'رأس المال النقدي')]/../input")));
		financial_materials=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'رأس المال العيني')]/../input")));
		shares=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'عدد الحصص')]/../input")));
		
		financial_cash.sendKeys("1000");
		//financial_materials.sendKeys("");
		shares.sendKeys("2");
		
	}
	
	public void Finish_insert_shares(WebDriver driver,WebDriverWait wait) throws InterruptedException, ClassNotFoundException, SQLException
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebElement next_btn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'التالي')]")));
		jse.executeScript("scroll(0, 7500)");
		next_btn.click();
	}

}
