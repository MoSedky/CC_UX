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

public class Activities_cmp {
	
	public void Select_Acts_Main(WebDriver driver,WebDriverWait wait) throws InterruptedException, ClassNotFoundException, SQLException
	{
		
	}
	
	public void Select_Acts_second(WebDriver driver,WebDriverWait wait) throws InterruptedException, ClassNotFoundException, SQLException
	{
		
	}
	
	public void Finish_selecting_Acts(WebDriver driver,WebDriverWait wait) throws InterruptedException, ClassNotFoundException, SQLException
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebElement next_btn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'التالي')]")));
		jse.executeScript("scroll(0, 7500)");
		next_btn.click();
	}
	

	
	

}
