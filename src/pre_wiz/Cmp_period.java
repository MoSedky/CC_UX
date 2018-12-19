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

public class Cmp_period {
	Select cmp_period;
	Select month_start;
	
	public void Select_cmp_period_fiscal(WebDriver driver,WebDriverWait wait) throws InterruptedException, ClassNotFoundException, SQLException
	{
		cmp_period=new Select (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'مدة الشركة')]/../select"))));
		cmp_period.selectByIndex(5);
		
		month_start=new Select (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'شهر بداية السنة')]/../select"))));
		month_start.selectByIndex(5);
	}
	
	public void Finish_selecting_names(WebDriver driver,WebDriverWait wait) throws InterruptedException, ClassNotFoundException, SQLException
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebElement next_btn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'التالي')]")));
		jse.executeScript("scroll(0, 7500)");
		next_btn.click();
	}

}
