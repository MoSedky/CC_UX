package pre_wiz;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Reserve_Trade_Name {
	WebElement reserve_name_tab;
	WebElement reserve_suggested_name;
	Select CR_Type_DDL;
	Select Activity_Type_DDL;
	Random rand=new Random();
	List<WebElement> sugg_names;
	WebElement reserve_btn;
	List<WebElement> page_btns;
	List<WebElement> resv_name_list;
	
	public String reserve_sugg_name(WebDriver driver,WebDriverWait wait) throws InterruptedException, ClassNotFoundException, SQLException
	{
		reserve_name_tab=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/ReservedName/ReserveNewTradeName']")));
		reserve_name_tab.click();
		
		reserve_suggested_name=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/ReservedName/ReserveSuggestionName']")));
		reserve_suggested_name.click();
		
		CR_Type_DDL=new Select (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'نوع السجل التجارى')]/../select"))));
		CR_Type_DDL.selectByIndex(1);
		
		Thread.sleep(4000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 7500)");
		
		Activity_Type_DDL=new Select (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'نوع النشاط التجارى')]/../select"))));
		Activity_Type_DDL.selectByIndex(rand.nextInt(417));
		
		jse.executeScript("scroll(0, 7500)");
		
		sugg_names=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//label[contains(@for,'WhiteName')]")));
		System.out.println(sugg_names.get(rand.nextInt(23)).getText());
		sugg_names.get(rand.nextInt(23)+1).click();
		
		Thread.sleep(4000);
		jse.executeScript("scroll(0, 7500)");
		
		reserve_btn=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@value,'حجز الأسم')]")));
		reserve_btn.click();
		
		Thread.sleep(4000);
		jse.executeScript("scroll(0, 7500)");
		try
		{
			page_btns=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[contains(@href,'/Contracts/GetReservedNames?page=')]")));
			page_btns.get(page_btns.size()-1).click();
		}catch(Exception E)
		{
			Thread.sleep(4000);
			jse.executeScript("scroll(0, 7500)");
			
			resv_name_list=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//label[contains(@for,'item_RequestNumber')]/../strong")));
			System.out.println(resv_name_list.get(resv_name_list.size()-1).getText());
		}
		resv_name_list=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//label[contains(@for,'item_RequestNumber')]/../strong")));
		System.out.println(resv_name_list.get(resv_name_list.size()-1).getText());
		
		return resv_name_list.get(resv_name_list.size()-1).getText();
	}

}
