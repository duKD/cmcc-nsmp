package com.ultrapower.controller;

import com.sun.tools.javac.jvm.Items;
import com.ultrapower.dao.AmAssetMapper;
import com.ultrapower.pojo.AmAsset;
import com.ultrapower.pojo.AmAssetType;
import com.ultrapower.util.PkUtils;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.util.List;
import java.util.UUID;

@Controller
public class excelController {
    @Autowired
    AmAssetMapper amAssetMapper;
    @RequestMapping(value = "/test03",method = RequestMethod.POST)
    public ModelAndView test03(@RequestParam MultipartFile excel) throws IOException {
        InputStream inputStream = excel.getInputStream();
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheetAt = workbook.getSheetAt(0);
        int rows = sheetAt.getPhysicalNumberOfRows();
        for(int i=1;i<rows;i++){
            XSSFRow row = sheetAt.getRow(i);
            AmAsset amAsset = creatAmAsset(row);
            amAssetMapper.insert(amAsset);
        }
        return null;
    }

    public AmAsset creatAmAsset(XSSFRow row){
        AmAsset amAsset = new AmAsset();
        amAsset.setPkAsset(PkUtils.getUUID());
        amAsset.setProvCode(row.getCell(0).getStringCellValue());
        amAsset.setAssetName(row.getCell(1).getStringCellValue());
        amAsset.setAssetCode(row.getCell(2).getStringCellValue());
        amAsset.setAssetIp(row.getCell(3).getStringCellValue());
        amAsset.setAssetDesc(row.getCell(4).getStringCellValue());
        return amAsset;
    }

    //返回一个ResponseEntity类型
    @RequestMapping("/test04")
       public void poiDownloadTest() throws Exception {
        List<AmAsset> list = amAssetMapper.selectByExample(null);

        //创建一个excel并写入测试内容
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet();

        //省份编码	资产名称	资产编码	资产ip
        XSSFRow row = sheet.createRow(0);//表头
        row.createCell(0).setCellValue("省份编码");
        row.createCell(1).setCellValue("资产名称");
        row.createCell(2).setCellValue("资产编码");
        row.createCell(3).setCellValue("资产ip");
        for(int i = 1 ; i<list.size()+1;i++){
            XSSFRow rowAsset = sheet.createRow(i);//表头
            rowAsset.createCell(0).setCellValue(list.get(i-1).getProvCode());
            rowAsset.createCell(1).setCellValue(list.get(i-1).getAssetName());
            rowAsset.createCell(2).setCellValue(list.get(i-1).getAssetCode());
            rowAsset.createCell(3).setCellValue(list.get(i-1).getAssetIp());
        }
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\2.xlsx");
        workbook.write(fileOutputStream);
        workbook.close();
    }
}
