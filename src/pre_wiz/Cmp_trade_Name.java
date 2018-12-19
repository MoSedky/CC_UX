package pre_wiz;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cmp_trade_Name {
	WebElement pre_reservd_name_rad_btn;
	WebElement quick_TM_rad_btn;
	WebElement resrvd_name_id;
	Select CR_Type_DDL;
	WebElement TName_txt;
	Select Activity_Type_DDL;
	WebElement Verify_Name_btn;
	WebElement conditions_chkbox;
	Random rand = new Random();
	
	
	
	
	public void Select_TM_Quick(WebDriver driver,WebDriverWait wait) throws InterruptedException, ClassNotFoundException, SQLException
	{
		pre_reservd_name_rad_btn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'الحجز الفوري')]")));
		pre_reservd_name_rad_btn.click();
		
		CR_Type_DDL=new Select (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'نوع السجل التجارى')]/../select"))));
		CR_Type_DDL.selectByIndex(1);
		
		TName_txt=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'الاسم التجارى')]/../input")));
		TName_txt.sendKeys("العلماء");
		
		Thread.sleep(4000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 7500)");
		
		Activity_Type_DDL=new Select (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'نوع النشاط التجاري')]/../select"))));
		Activity_Type_DDL.selectByIndex(rand.nextInt(417));
		
		Verify_Name_btn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'تحقق')]")));
		Verify_Name_btn.click();
		
		Thread.sleep(5000);
		try
		{
			conditions_chkbox=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'التعهد')]/..//label[@class='checkbox-inline']")));
			
		}catch(Exception E)
		{
			Activity_Type_DDL.selectByIndex(rand.nextInt(55));
			
			conditions_chkbox=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'التعهد')]/..//label[@class='checkbox-inline']")));
		}
		
		conditions_chkbox.click();
		
	}
	
	public void Select_TM_pre(WebDriver driver,WebDriverWait wait,String rs_name_id) throws InterruptedException, ClassNotFoundException, SQLException
	{
		quick_TM_rad_btn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'اسم محجوز مسبقا')]")));
		quick_TM_rad_btn.click();
		
		resrvd_name_id=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@name,'ReservedNameId')]")));
		resrvd_name_id.sendKeys(rs_name_id);
		
		Verify_Name_btn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'تحقق')]")));
		Verify_Name_btn.click();
		
	}
	
	public void Finish_selecting_names(WebDriver driver,WebDriverWait wait) throws InterruptedException, ClassNotFoundException, SQLException
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebElement next_btn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'التالي')]")));
		jse.executeScript("scroll(0, 7500)");
		next_btn.click();
	}

}
