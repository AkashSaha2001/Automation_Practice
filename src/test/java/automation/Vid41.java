package automation;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;


//Excel File >> WorkBook >> Sheets >> row >> cell

//FileInputStream -- reading
//FileOutputStream -- write
// XSSFWorkbook -- workbook
// XSSFSheet -- Sheet
// XSSFRow -- row
//XSSFCell -- cell
public class Vid41 {
    public static void main(String args[]) throws IOException {
/*
        // read the data from Excel file
        FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\testdata\\data.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook(file);
        XSSFSheet sheet=workbook.getSheet("Student");

        if (sheet == null) {
            System.out.println("Sheet not found. Check sheet name.");
            return;
        }
        int rows=sheet.getLastRowNum();
        int cell=sheet.getRow(1).getLastCellNum();

        System.out.println("Total no of row is : "+ rows); // 4, but it is 5
        System.out.println("Total no of cell per row : "+cell);// 5, it is 5

        for(int i=0;i<=rows;i++){
            XSSFRow currentRow=sheet.getRow(i);
            for(int j=0;j<cell;j++){
                XSSFCell currentcell=currentRow.getCell(j);
                System.out.print(currentcell+"\t");
            }
            System.out.println();

        }

 */

        // Write the data into Excel file
        FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\data1.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet =workbook.createSheet("Student");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of row");
        int row=sc.nextInt();
        System.out.println("Enter no of cell of row");
        int cell= sc.nextInt();

        for(int i=0;i<=row;i++){
            XSSFRow currentrow=sheet.createRow(i);
            for(int j=0;j<cell;j++){
                XSSFCell currentcell=currentrow.createCell(j);
                currentcell.setCellValue(sc.next());
            }
        }

        workbook.write(file);
        workbook.close();
        file.close();


    }
}
