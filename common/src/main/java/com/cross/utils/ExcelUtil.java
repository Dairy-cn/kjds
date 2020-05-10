package com.cross.utils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;


/**
 * 导出excel
 * Created by LY on 2017/12/5.
 */
public class ExcelUtil {
    public static final Integer pageSize = 20000;
    private static final Logger log = LoggerFactory.getLogger(ExcelUtil.class);
    private static HSSFCellStyle cellstyle = null;

    public static void writeExcel(HttpServletResponse response, HSSFWorkbook work, String fileName) throws IOException {
        OutputStream out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/ms-excel;charset=UTF-8");
            response.setHeader("x-filename", String.valueOf(URLEncoder.encode(fileName + ".xls", "UTF-8")));
            response.setHeader("Content-Type", "application/ms-excel;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename="
                .concat(String.valueOf(URLEncoder.encode(fileName + ".xls", "UTF-8"))));
            out = response.getOutputStream();

            work.write(out);
        } catch (IOException e) {
            System.out.println("输出流错误");
            log.error("writeExcel: {}", e);
            log.error("writeExcel: {}", e);
        } finally {
            if (null != out) {
                out.close();
            }
        }
    }

    /**
     * 设置sheet页名称，表头
     *
     * @param wb
     */
    public static void writeExcelSheet(HSSFWorkbook wb, String sheetName, List<String> cellTitles, List<List<Object>> cellValues) {
        HSSFSheet sheet = wb.createSheet(sheetName);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, cellTitles.size() - 1));

        // 设置表头
        HSSFCellStyle titleStyle = wb.createCellStyle();
        titleStyle.setAlignment(HorizontalAlignment.CENTER_SELECTION);

        HSSFCell titleCell = sheet.createRow(0).createCell(0);
        titleCell.setCellValue(sheetName);
        titleCell.setCellStyle(titleStyle);

        HSSFRow row = sheet.createRow(1);
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER_SELECTION);

        for (int i = 0; i < cellTitles.size(); i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(cellTitles.get(i));
            cell.setCellStyle(style);
        }

        for (int i = 0; i < cellValues.size(); i++) {
            HSSFRow valueRow = sheet.createRow(2 + i);
            for (int j = 0; j < cellValues.get(i).size(); j++) {
                HSSFCell cell = valueRow.createCell(j);
                cell.setCellValue(cellValues.get(i).get(j).toString());
                cell.setCellStyle(style);
            }
        }
    }

    /**
     * 设置sheet页名称，表头
     *
     * @param wb
     */
    public static void writeExcelSheetOperate(HSSFWorkbook wb, String sheetName, List<String> cellTitles, List<List<Object>> cellValues, String brandAndMerchantName) {
        writeExcelSheetOperate(wb, sheetName, cellTitles, cellValues, brandAndMerchantName, null);
    }

    /**
     * 设置sheet页名称，表头
     *
     * @param wb
     */
    public static void writeExcelSheetOperate(HSSFWorkbook wb, String sheetName, List<String> cellTitles, List<List<Object>> cellValues, String brandAndMerchantName, String dayInterval) {
        sheetName = sheetName + "_" + brandAndMerchantName;
        if (null != dayInterval) {
            sheetName = sheetName + "(" + dayInterval + ")";
        }
        HSSFSheet sheet = wb.createSheet(sheetName);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, cellTitles.size() - 1));
        sheet.createFreezePane(0, 2);
        HSSFFont font = wb.createFont();
        font.setBold(true);

        // 设置表头
        HSSFCellStyle titleStyle = wb.createCellStyle();
//        titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        titleStyle.setFont(font);

        HSSFCell titleCell = sheet.createRow(0).createCell(0);
        titleCell.setCellValue(sheetName);
        titleCell.setCellStyle(titleStyle);

        HSSFRow row = sheet.createRow(1);
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER_SELECTION);
        for (int i = 0; i < cellTitles.size(); i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(cellTitles.get(i));
            cell.setCellStyle(titleStyle);
        }

        for (int i = 0; i < cellValues.size(); i++) {
            HSSFRow valueRow = sheet.createRow(2 + i);
            for (int j = 0; j < cellValues.get(i).size(); j++) {
                HSSFCell cell = valueRow.createCell(j);
                cell.setCellValue(cellValues.get(i).get(j) + "          ");
            }
        }

        try {
            for (int i = 0; i < cellTitles.size(); i++) {
                sheet.autoSizeColumn(i);
            }
        } catch (Exception e) {
            log.error("set column auto size error: ", e);
        }
    }

    private static Cell setCellStyleWithStyleAndValue(CellStyle style, Cell cell, String value) {
        cell.setCellStyle(style);
        cell.setCellValue(value);
        return cell;
    }

    private static Cell setCellStyleWithValue(Cell cell, String value) {
        cell.setCellStyle(cellstyle);
        cell.setCellValue(value);
        return cell;
    }


    private static Cell setCellStyleWithStyleAndValue(CellStyle style, Cell cell, RichTextString value) {
        cell.setCellStyle(style);
        cell.setCellValue(value);
        return cell;
    }

    private static Cell setCellStyleWithValue(Cell cell, int value) {
        cell.setCellStyle(cellstyle);
        cell.setCellValue(value);
        return cell;
    }

    private static Cell setCellStyleWithValue(Cell cell, double value) {
        cell.setCellStyle(cellstyle);
        cell.setCellValue(value);
        return cell;
    }

//    private static HSSFCellStyle createCellStyle(Workbook wb) {
//        cellstyle = (HSSFCellStyle) wb.createCellStyle();
//        cellstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//        cellstyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
//        cellstyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
//        cellstyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
//        cellstyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
//        cellstyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
//        return cellstyle;
//    }
}
