//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.common;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class ExcelView extends AbstractExcelView {
    private String excelName;
    private String sheetName;
    private LinkedHashMap<String, String> title;
    private List<Map<String, Object>>[] contents;

    @SafeVarargs
    public ExcelView(String excelName, String sheetName, LinkedHashMap<String, String> title, List... contents) {
        this.excelName = excelName;
        this.sheetName = sheetName;
        this.title = title;
        this.contents = contents;
    }

    protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setHeader("content-disposition", "attachment; filename=" + new String(this.excelName.getBytes("UTF-8"), "ISO-8859-1"));
        POI.write(workbook, this.sheetName, this.title, this.contents);
    }
}
