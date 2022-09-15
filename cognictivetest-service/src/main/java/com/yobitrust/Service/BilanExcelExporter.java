package com.yobitrust.Service;

import com.yobitrust.Models.BloodAnalyse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class BilanExcelExporter {
	
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	  static String[] HEADERs = { "Date", "Glucose", "C-Reactive protein", "D-dimer","IP-10", "Free albumin", "Leptin", "Adiponectin", "IGF-1","Resistin", "OPN", "Orexin-A", "Melatonin", "adiponectin" };
	  static String SHEET = "Tutorials";
	  public static ByteArrayInputStream tutorialsToExcel(List<BloodAnalyse> tutorials) {

		    try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
		      Sheet sheet = workbook.createSheet(SHEET);

		      // Header
		      Row headerRow = sheet.createRow(0);

		      for (int col = 0; col < HEADERs.length; col++) {
		        Cell cell = headerRow.createCell(col);
		        cell.setCellValue(HEADERs[col]);
		      }

		      int rowIdx = 1;
		      for (BloodAnalyse tutorial : tutorials) {
		        Row row = sheet.createRow(rowIdx++);
		        row.createCell(0).setCellValue(tutorial.getBloodAnalysisDate());
		        if(tutorial.getGlucose() > 0) {
		        	row.createCell(1).setCellValue(tutorial.getGlucose());
		        }
		        else row.createCell(0).setCellValue(" ");
		        
		        if (tutorial.getcReactiveProtein() > 0) {
		        	row.createCell(2).setCellValue(tutorial.getcReactiveProtein());
		        }
		        else row.createCell(0).setCellValue(" ");
		        
		        
		        row.createCell(3).setCellValue(tutorial.getdDimer());
		        row.createCell(4).setCellValue(tutorial.getIp10());
		        row.createCell(5).setCellValue(tutorial.getFreeAlbumin());
		        row.createCell(6).setCellValue(tutorial.getLeptin());
		        row.createCell(7).setCellValue(tutorial.getAdiponectin());
		        row.createCell(8).setCellValue(tutorial.getIgf1());
		        row.createCell(9).setCellValue(tutorial.getResistin());
		        row.createCell(10).setCellValue(tutorial.getOpn());
		        row.createCell(11).setCellValue(tutorial.getOrexinA());
		        row.createCell(12).setCellValue(tutorial.getMelatonin());
		        row.createCell(13).setCellValue(tutorial.getCreatinine());
	        
		      }

		      workbook.write(out);
		      return new ByteArrayInputStream(out.toByteArray());
		    } catch (IOException e) {
		      throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
		    }
		  }
	/*private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<BloodAnalyse> listBilan;
    
    public BilanExcelExporter(List<BloodAnalyse> listBilan) {
        this.listBilan = listBilan;
        workbook = new XSSFWorkbook();
    }
 
 
    private void writeHeaderLine() {
        sheet = workbook.createSheet("Bilan blood analysis");
         
        Row row = sheet.createRow(0);
         
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
         
        createCell(row, 0, "Date", style);      
        createCell(row, 1, "Glucose", style);       
        createCell(row, 2, "C-Reactive protein", style);    
        createCell(row, 3, "D-dimer", style);
        createCell(row, 4, "IP-10", style);
        createCell(row, 5, "Free albumin", style);      
        createCell(row, 7, "Leptin", style);       
        createCell(row, 8, "Adiponectin", style);    
        createCell(row, 9, "IGF-1", style);
        createCell(row, 10, "OPN", style);
        createCell(row, 11, "Orexin-A", style);   
        createCell(row, 12, "Melatonin", style);   
        createCell(row, 13, "Creatinine", style);   
         
    }
     
    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Float) {
            cell.setCellValue((Float) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
    
    private void writeDataLines() {
        int rowCount = 1;
 
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
                 
        for (BloodAnalyse bilan : listBilan) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
             
            createCell(row, columnCount++, bilan.getBloodAnalysisDate(), style);
            createCell(row, columnCount++, bilan.getGlucose(), style);
            createCell(row, columnCount++, bilan.getcReactiveProtein(), style);
            createCell(row, columnCount++, bilan.getdDimer(), style);
            createCell(row, columnCount++, bilan.getIp10(), style);
            createCell(row, columnCount++, bilan.getFreeAlbumin(), style);
            createCell(row, columnCount++, bilan.getLeptin(), style);
            createCell(row, columnCount++, bilan.getAdiponectin(), style);
            createCell(row, columnCount++, bilan.getIgf1(), style);
            createCell(row, columnCount++, bilan.getResistin(), style);
            createCell(row, columnCount++, bilan.getOpn(), style);
            createCell(row, columnCount++, bilan.getOrexinA(), style);
            createCell(row, columnCount++, bilan.getMelatonin(), style);
            createCell(row, columnCount++, bilan.getCreatinine(), style);
             
        }
    }
     
    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();
         
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
         
        outputStream.close();
         
    }*/
}
