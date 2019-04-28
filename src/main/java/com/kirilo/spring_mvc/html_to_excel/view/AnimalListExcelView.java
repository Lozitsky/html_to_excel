package com.kirilo.spring_mvc.html_to_excel.view;

import com.kirilo.spring_mvc.html_to_excel.model.Animal;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

//https://javapapers.com/spring/excel-export-in-spring-mvc/
//https://stackoverflow.com/questions/37983946/abstractexcelview-is-deprecated-in-spring-based-application
public class AnimalListExcelView extends AbstractXlsView {
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"my-xls-file.xls\"");


        // create excel xls sheet
        Sheet excelSheet = workbook.createSheet("Animal List");
        // create header row
        setExcelHeader(excelSheet);

        List<Animal> animalList = (List<Animal>) map.get("animalList");
        setExcelRows(excelSheet,animalList);
    }

    public void setExcelHeader(Sheet excelSheet) {
//        HSSFRow excelHeader =
        Row excelHeader = excelSheet.createRow(0);
        excelHeader.createCell(0).setCellValue("Id");
        excelHeader.createCell(1).setCellValue("Name");
        excelHeader.createCell(2).setCellValue("Type");
        excelHeader.createCell(3).setCellValue("Aggressive");
        excelHeader.createCell(4).setCellValue("Weight");
    }

    public void setExcelRows(Sheet excelSheet, List<Animal> animalList){
        int record = 1;
        for (Animal animal : animalList) {
//            HSSFRow excelRow =
            Row excelRow = excelSheet.createRow(record++);
            excelRow.createCell(0).setCellValue(animal.getId());
            excelRow.createCell(1).setCellValue(animal.getAnimalName());
            excelRow.createCell(2).setCellValue(animal.getAnimalType());
            excelRow.createCell(3).setCellValue(animal.getAggressive());
            excelRow.createCell(4).setCellValue(animal.getWeight());
        }
    }
}
