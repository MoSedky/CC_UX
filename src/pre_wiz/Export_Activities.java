package pre_wiz;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


public class Export_Activities {
	
	private static final String FILE_NAME = "C:\\Users\\mmostafa\\eclipse-workspace\\Pre_Wizard\\PreWizard.xlsx";
	private static final String FILE_NAME_HELP_ME = "C:\\Users\\mmostafa\\eclipse-workspace\\Pre_Wizard\\HelpMe.xlsx";
    /*
	public void  print_Acts(List <WebElement> Acts)
    {
    	
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Datatypes in Java");
       

        int rowNum = 0;
        System.out.println("Creating excel");

        for (int i=0;i<Acts.size();i++) 
        {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
           
            Cell cell = row.createCell(colNum++);
                
            cell.setCellValue((String) Acts.get(i).getText());
                
                 
        }
        

        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }
    */
	
    XSSFWorkbook workbook = new XSSFWorkbook();
   
    
    @SuppressWarnings("deprecation")
	public void  print_results_PreWizard(String[] Acts, String[] actual_results, String[] expected_results,int rowNum, String Company_Name,String usertype, String CapitalName,String ContractID) throws Exception
    {
    	
    	 XSSFSheet sheet=workbook.createSheet("PreWizard Results"+rowNum);
    	 
    	 XSSFCellStyle style = workbook.createCellStyle();
    	
    	 XSSFFont font = workbook.createFont();
    	 font.setFontHeightInPoints((short) 15);
    	 font.setBold(true);
    	 style.setFont(font);                 
       //  sheet = workbook.createSheet("PreWizard Results"+rowNum);
        if(sheet.getLastRowNum()==0)
        {
        	rowNum=0;
        }
        else
        {
        	rowNum=sheet.getLastRowNum();
        }
       

        
        System.out.println("Creating excel");

        for (int it_Acts=0;it_Acts<Acts.length;it_Acts++) 
        {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
           
            Cell cell = row.createCell(colNum++);
                
            cell.setCellValue(Acts[it_Acts]);   
        }
        
        
        
        rowNum=Acts.length;
        for (int it_act_results=0;it_act_results<actual_results.length;it_act_results++) 
        {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
           
            Cell cell = row.createCell(colNum++); 
           
            	try
            	{
            		cell.setCellValue(Double.parseDouble(actual_results[it_act_results]));
                    cell.setCellType(CellType.NUMERIC);
            	}catch(NumberFormatException c)
            	{
            		cell.setCellValue(actual_results[it_act_results]);
                    
            	}
            	
            
            
            
        }
        
        rowNum=actual_results.length+Acts.length;
        for (int it_exp_results=0;it_exp_results<expected_results.length;it_exp_results++) 
        {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
           
            Cell cell = row.createCell(colNum++);
            
            try
            {
            	
            	cell.setCellValue(Double.parseDouble(expected_results[it_exp_results])); 
                cell.setCellType(CellType.NUMERIC);
            }catch (Exception c)
        	{
            	cell.setCellValue(expected_results[it_exp_results]); 
                
        	}
            
            
        }
         
         
        Row row_cmp = sheet.createRow(30);
        Cell cell_cmp = row_cmp.createCell(0);
        Cell cell_user = row_cmp.createCell(1);
        Cell cell_cptam = row_cmp.createCell(2);
        Cell cell_cont_ID = row_cmp.createCell(3);
        
        cell_cmp.setCellValue(Company_Name);   
        cell_user.setCellValue(usertype); 
        cell_cptam.setCellValue(CapitalName); 
        cell_cont_ID.setCellValue(ContractID);
        
        cell_cmp.setCellStyle(style);
        cell_user.setCellStyle(style);
        cell_cptam.setCellStyle(style);
        cell_cont_ID.setCellStyle(style);

        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
           // workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }

    
    public void  print_results_HelpMe(String[] Help_Me_Res,int rowNum) throws Exception
    {
    	
    	 XSSFSheet sheet=workbook.createSheet("Help Me Results"+rowNum);
    	 
    	 XSSFCellStyle style = workbook.createCellStyle();
    	
    	 XSSFFont font = workbook.createFont();
    	 font.setFontHeightInPoints((short) 15);
    	 font.setBold(true);
    	 style.setFont(font);                 
       //  sheet = workbook.createSheet("PreWizard Results"+rowNum);
        if(sheet.getLastRowNum()==0)
        {
        	rowNum=0;
        }
        else
        {
        	rowNum=sheet.getLastRowNum();
        }
       

        
        System.out.println("Creating excel");

        for (int it_Acts=0;it_Acts<Help_Me_Res.length;it_Acts++) 
        {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
           
            Cell cell = row.createCell(colNum++);
                
            cell.setCellValue(Help_Me_Res[it_Acts]);   
        }
        
        
        
        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME_HELP_ME);
            workbook.write(outputStream);
           // workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }
}
