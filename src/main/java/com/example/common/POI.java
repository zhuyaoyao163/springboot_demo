//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POI {
    private static Logger logger = LogManager.getLogger(POI.class);

    public POI() {
    }

    public static List<LinkedHashMap<Integer, String>> read(String file, int sheetNum, int... cellNums) {
        Object list = new ArrayList();
        FileInputStream in = null;

        try {
            in = new FileInputStream(file);
            Workbook e = WorkbookFactory.create(in);
            list = parse(e, sheetNum, cellNums);
        } catch (Exception var14) {
            logger.error(file + " | " + sheetNum, var14);
        } finally {
            try {
                in.close();
            } catch (Exception var13) {
                ;
            }

        }

        return (List)list;
    }

    public static List<LinkedHashMap<Integer, String>> read(byte[] bytes, int sheetNum, int... cellNums) {
        Object list = new ArrayList();
        ByteArrayInputStream in = null;

        try {
            in = new ByteArrayInputStream(bytes);
            Workbook e = WorkbookFactory.create(in);
            list = parse(e, sheetNum, cellNums);
        } catch (Exception var14) {
            logger.error(bytes + " | " + sheetNum, var14);
        } finally {
            try {
                in.close();
            } catch (Exception var13) {
                ;
            }

        }

        return (List)list;
    }

    public static List<LinkedHashMap<Integer, String>> read(InputStream in, int sheetNum, int... cellNums) {
        Object list = new ArrayList();

        try {
            Workbook e = WorkbookFactory.create(in);
            list = parse(e, sheetNum, cellNums);
        } catch (Exception var13) {
            logger.error(in + " | " + sheetNum, var13);
        } finally {
            try {
                in.close();
            } catch (Exception var12) {
                ;
            }

        }

        return (List)list;
    }

    @SafeVarargs
    public static boolean write(String file, String sheetName, LinkedHashMap<String, String> title, List... contents) {
        boolean result = true;
        FileOutputStream out = null;

        try {
            XSSFWorkbook e = new XSSFWorkbook();
            CellStyle titleCellStyle = defaultStyle(e);
            Font titleFont = defaultFont(e);
            titleFont.setBoldweight((short)700);
            CellStyle contentCellStyle = defaultStyle(e);
            Font contentFont = defaultFont(e);
            int n = 1;
            if(contents != null && contents.length != 0) {
                List[] var31 = contents;
                int len$ = contents.length;

                for(int i$ = 0; i$ < len$; ++i$) {
                    List list = var31[i$];
                    Sheet sheet = e.createSheet(sheetName + "." + n);
                    List titleList = setTitleRow(title, sheet.createRow(0), titleCellStyle, titleFont);
                    int i = 1;

                    for(Iterator i$1 = list.iterator(); i$1.hasNext(); ++i) {
                        Map map = (Map)i$1.next();
                        setContentRow(titleList, map, sheet.createRow(i), contentCellStyle, contentFont);
                    }

                    ++n;
                }
            } else {
                Sheet arr$ = e.createSheet(sheetName + "." + n);
                setTitleRow(title, arr$.createRow(0), titleCellStyle, titleFont);
            }

            out = new FileOutputStream(file);
            e.write(out);
        } catch (Exception var29) {
            result = false;
            logger.error(file + " | " + sheetName, var29);
        } finally {
            try {
                out.close();
            } catch (Exception var28) {
                ;
            }

        }

        return result;
    }

    @SafeVarargs
    public static byte[] write(String sheetName, LinkedHashMap<String, String> title, List... contents) {
        byte[] result = null;

        try {
            XSSFWorkbook e = new XSSFWorkbook();
            CellStyle titleCellStyle = defaultStyle(e);
            Font titleFont = defaultFont(e);
            titleFont.setBoldweight((short)700);
            CellStyle contentCellStyle = defaultStyle(e);
            Font contentFont = defaultFont(e);
            int n = 1;
            if(contents != null && contents.length != 0) {
                List[] var20 = contents;
                int len$ = contents.length;

                for(int i$ = 0; i$ < len$; ++i$) {
                    List list = var20[i$];
                    Sheet sheet = e.createSheet(sheetName + "." + n);
                    List titleList = setTitleRow(title, sheet.createRow(0), titleCellStyle, titleFont);
                    int i = 1;

                    for(Iterator i$1 = list.iterator(); i$1.hasNext(); ++i) {
                        Map map = (Map)i$1.next();
                        setContentRow(titleList, map, sheet.createRow(i), contentCellStyle, contentFont);
                    }

                    ++n;
                }
            } else {
                Sheet baos = e.createSheet(sheetName + "." + n);
                setTitleRow(title, baos.createRow(0), titleCellStyle, titleFont);
            }

            ByteArrayOutputStream var21 = new ByteArrayOutputStream();
            e.write(var21);
            result = var21.toByteArray();
        } catch (Exception var19) {
            logger.error(sheetName, var19);
        }

        return result;
    }

    @SafeVarargs
    public static HSSFWorkbook write(HSSFWorkbook workbook, String sheetName, LinkedHashMap<String, String> title, List... contents) {
        try {
            CellStyle e = defaultStyle(workbook);
            Font titleFont = defaultFont(workbook);
            titleFont.setBoldweight((short)700);
            CellStyle contentCellStyle = defaultStyle(workbook);
            Font contentFont = defaultFont(workbook);
            int n = 1;
            if(contents != null && contents.length != 0) {
                List[] var19 = contents;
                int len$ = contents.length;

                for(int i$ = 0; i$ < len$; ++i$) {
                    List list = var19[i$];
                    HSSFSheet sheet = workbook.createSheet(sheetName + "." + n);
                    List titleList = setTitleRow(title, sheet.createRow(0), e, titleFont);
                    int i = 1;

                    for(Iterator i$1 = list.iterator(); i$1.hasNext(); ++i) {
                        Map map = (Map)i$1.next();
                        setContentRow(titleList, map, sheet.createRow(i), contentCellStyle, contentFont);
                    }

                    ++n;
                }
            } else {
                HSSFSheet arr$ = workbook.createSheet(sheetName + "." + n);
                setTitleRow(title, arr$.createRow(0), e, titleFont);
            }
        } catch (Exception var18) {
            logger.error(sheetName, var18);
        }

        return workbook;
    }

    private static List<LinkedHashMap<Integer, String>> parse(Workbook workbook, int sheetNum, int... cellNums) {
        ArrayList list = new ArrayList();
        Sheet sheet = workbook.getSheetAt(sheetNum);

        for(int i = 0; i <= sheet.getLastRowNum(); ++i) {
            Row row = sheet.getRow(i);
            if(row != null) {
                LinkedHashMap map = new LinkedHashMap();

                for(int j = 0; j < cellNums.length; ++j) {
                    Cell cell = row.getCell(cellNums[j]);
                    if(cell != null) {
                        switch(cell.getCellType()) {
                            case 0:
                                map.put(Integer.valueOf(cellNums[j]), Double.toString(cell.getNumericCellValue()));
                                break;
                            case 1:
                                map.put(Integer.valueOf(cellNums[j]), Format.stringBlank(cell.getStringCellValue()));
                                break;
                            case 2:
                                map.put(Integer.valueOf(cellNums[j]), Format.stringBlank(cell.getCellFormula()));
                                break;
                            case 3:
                                map.put(Integer.valueOf(cellNums[j]), "");
                                break;
                            case 4:
                                map.put(Integer.valueOf(cellNums[j]), Boolean.toString(cell.getBooleanCellValue()));
                                break;
                            default:
                                map.put(Integer.valueOf(cellNums[j]), "");
                        }
                    }
                }

                list.add(map);
            }
        }

        return list;
    }

    private static Font defaultFont(Workbook workbook) {
        Font font = workbook.createFont();
        font.setFontName("Courier New");
        font.setFontHeightInPoints((short)10);
        return font;
    }

    private static CellStyle defaultStyle(Workbook workbook) {
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setBorderBottom((short)1);
        cellStyle.setBorderLeft((short)1);
        cellStyle.setBorderRight((short)1);
        cellStyle.setBorderTop((short)1);
        cellStyle.setAlignment((short)2);
        cellStyle.setVerticalAlignment((short)1);
        return cellStyle;
    }

    private static List<String> setTitleRow(LinkedHashMap<String, String> map, Row row, CellStyle cellStyle, Font font) {
        ArrayList list = new ArrayList();
        int n = 0;
        Set set = map.entrySet();

        for(Iterator iterator = set.iterator(); iterator.hasNext(); ++n) {
            Entry entry = (Entry)iterator.next();
            Cell cell = row.createCell(n);
            cellStyle.setFont(font);
            cell.setCellStyle(cellStyle);
            cell.setCellType(1);
            cell.setCellValue((String)entry.getValue());
            list.add(entry.getKey());
        }

        return list;
    }

    private static void setContentRow(List<String> list, Map<String, Object> map, Row row, CellStyle cellStyle, Font font) {
        int n = 0;

        for(Iterator i$ = list.iterator(); i$.hasNext(); ++n) {
            String key = (String)i$.next();
            Cell cell = row.createCell(n);
            cellStyle.setFont(font);
            cell.setCellStyle(cellStyle);
            cell.setCellType(1);
            cell.setCellValue(map.get(key).toString());
        }

    }
}
