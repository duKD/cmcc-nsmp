import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.*;

public class Exceltest {
    @Test
    public void test01() throws Exception {
        //创建工作文档簿
        XSSFWorkbook workbook = new XSSFWorkbook();
        //新建工作表
        XSSFSheet sheet = workbook.createSheet("测试表");
        XSSFRow row = sheet.createRow(1);
        XSSFCell cell = row.createCell(2);
        cell.setCellValue("测试数据");
        //保存工作表
        OutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\1..xlsx");
        workbook.write(fileOutputStream);
        workbook.close();
    }
    @Test
    public void test02() throws Exception {
        // 1、创建FileInputStream
        FileInputStream filein = new FileInputStream("C:\\Users\\Administrator\\Desktop\\1..xlsx");
        // 2、基于流来创建Excel工作簿
        XSSFWorkbook workbook = new XSSFWorkbook(filein);
        //获取工作表
        XSSFSheet sheet = workbook.getSheetAt(0);
        //读取数据,先获取总行数
        int rows = sheet.getPhysicalNumberOfRows();
        for(int i=0;i<rows;i++){
            XSSFRow row = sheet.getRow(i);
            int cells = row.getPhysicalNumberOfCells();
            for(int j=0;j<cells;j++){
                XSSFCell cell = row.getCell(j);
                cell.setCellType(CellType.STRING);
                String stringCellValue = cell.getStringCellValue();
                System.out.print(stringCellValue+"   ");
            }
            System.out.println();
        }
    }
    @Test
    public void test04(){
        //导出excel表格

    }
}
