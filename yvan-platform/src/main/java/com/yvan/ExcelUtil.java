package com.yvan;

import java.io.*;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yvan.template.ExcelAjaxTemplate;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;


public class ExcelUtil{
	public static Logger logger = Logger.getLogger(ExcelUtil.class.getName());



	/**
	 * @param fi //文件流
	 * @param startrow //开始行号
	 * @param startcol //开始列号
	 * @param sheetnum //sheet
	 * @return list
	 */
	public static List<Object> readExcel(InputStream fi, int startrow, int startcol, int sheetnum) {
		List<Object> varList = new ArrayList<Object>();
		try {
			HSSFWorkbook wb = new HSSFWorkbook(fi);
			HSSFSheet sheet = wb.getSheetAt(sheetnum); 					//sheet 从0开始
			int rowNum = sheet.getLastRowNum() + 1; 					//取得最后一行的行号

			for (int i = startrow; i < rowNum; i++) {					//行循环开始

				Map varpd = new HashMap();
				HSSFRow row = sheet.getRow(i); 							//行
				int cellNum = row.getLastCellNum(); 					//每行的最后一个单元格位置

				for (int j = startcol; j < cellNum; j++) {				//列循环开始

					HSSFCell cell = row.getCell(Short.parseShort(j + ""));
					String cellValue = null;
					if (null != cell) {
						switch (cell.getCellType()) { 					// 判断excel单元格内容的格式，并对其进行转换，以便插入数据库
							case 0:
								cellValue = String.valueOf((int) cell.getNumericCellValue());
								break;
							case 1:
								cellValue = cell.getStringCellValue();
								break;
							case 2:
								cellValue = cell.getNumericCellValue() + "";
								// cellValue = String.valueOf(cell.getDateCellValue());
								break;
							case 3:
								cellValue = "";
								break;
							case 4:
								cellValue = String.valueOf(cell.getBooleanCellValue());
								break;
							case 5:
								cellValue = String.valueOf(cell.getErrorCellValue());
								break;
						}
					} else {
						cellValue = "";
					}

					varpd.put("var"+j, cellValue);

				}
				varList.add(varpd);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return varList;
	}

	/**
	 * @param target //文件
	 * @param startrow //开始行号
	 * @param startcol //开始列号
	 * @param sheetnum //sheet
	 * @return list
	 */
	public static List<Object> readExcel(File target, int startrow, int startcol, int sheetnum) {
		List<Object> varList = new ArrayList<Object>();

		try {
			FileInputStream fi = new FileInputStream(target);
			varList = readExcel(fi,startrow,startcol,sheetnum);
		} catch (Exception e) {
			System.out.println(e);
		}

		return varList;
	}

	
	
	/**
	 * @param filepath //文件路径
	 * @param filename //文件名
	 * @param startrow //开始行号
	 * @param startcol //开始列号
	 * @param sheetnum //sheet
	 * @return list
	 */
	public static List<Object> readExcel(String filepath, String filename, int startrow, int startcol, int sheetnum) {
		List<Object> varList = new ArrayList<Object>();
		File target = new File(filepath, filename);
		varList = readExcel(target,startrow,startcol,sheetnum);
		return varList;
	}

	
	
	/**
	 * 读取到字节数组2
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public static byte[] toByteArray(String filePath) throws IOException {
		File f = new File(filePath);
		if (!f.exists()) {
			throw new FileNotFoundException(filePath);
		}
		FileChannel channel = null;
		FileInputStream fs = null;
		try {
			fs = new FileInputStream(f);
			channel = fs.getChannel();
			ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
			while ((channel.read(byteBuffer)) > 0) {
				// do nothing
				// System.out.println("reading");
			}
			return byteBuffer.array();
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				channel.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fs.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * @param response 
	 * @param filePath		//文件完整路径(包括文件名和扩展名)
	 * @param fileName		//下载后看到的文件名
	 * @return  文件名
	 */
	public static void excelDownload(final HttpServletResponse response, String filePath, String fileName) throws Exception{  
		   
		byte[] data = toByteArray(filePath);  
	    fileName = URLEncoder.encode(fileName, "UTF-8");  
	    response.reset();  
	    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");  
	    response.addHeader("Content-Length", "" + data.length);  
	    response.setContentType("application/octet-stream;charset=UTF-8");  
	    OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());  
	    outputStream.write(data);  
	    outputStream.flush();  
	    outputStream.close();
	    response.flushBuffer();
	    
	}    
	    
	    
	public static void buildExcelDocument( HttpServletRequest request,HttpServletResponse response,ExcelAjaxTemplate callBack) throws Exception {
			// TODO Auto-generated method stub
    	ServletOutputStream out = response.getOutputStream();
    	try{			
			HSSFWorkbook workbook = new HSSFWorkbook();
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment;filename=" + new SimpleDateFormat("yyyyMMddHH:mm:ss").format(new Date()) + ".xls");
			response.setContentType("text/html;charset=ISO-8859-1");	
			
			callBack.execute(request,workbook);
					
			workbook.write(out);
	    } catch (Exception e) {  
        	e.printStackTrace();
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			logger.error(sw.toString()); 
        }finally {
        	out.flush();
			out.close();
        }
			
	}
	    
	    
	    
	public static void buildDefaultExcelDocument( HttpServletRequest request,HttpServletResponse response,ExcelAjaxTemplate callBack) throws Exception {
		// TODO Auto-generated method stub
	ServletOutputStream out = response.getOutputStream();
	try{			
		HSSFWorkbook workbook = new HSSFWorkbook();
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename=" + new SimpleDateFormat("yyyyMMddHH:mm:ss").format(new Date()) + ".xls");
		response.setContentType("text/html;charset=ISO-8859-1");	
		
		
		
		callBack.execute(request,workbook);
		
		
		// TODO Auto-generated method stub
		LinkedHashMap titles = new LinkedHashMap();
		List<Map> varList = new ArrayList<Map>();
		if(request.getAttribute("titles")!=null) {
			titles = (LinkedHashMap)request.getAttribute("titles");
		}
		if(request.getAttribute("varList")!=null) {
			varList = (List<Map>)request.getAttribute("varList");
		}
		
		
		//添加页签
		HSSFSheet sheet  = workbook.createSheet("sheet1");
		
		//标题样式
		HSSFCellStyle headerStyle = workbook.createCellStyle(); 
		headerStyle.setAlignment(HorizontalAlignment.CENTER);
		headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		//标题字体
		HSSFFont headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short)11);
		headerStyle.setFont(headerFont);
		short width = 20,height=25*20;
		sheet.setDefaultColumnWidth(width);
		
		
		

		
		
		Set values = titles.entrySet();
		int i=0;
		for(Object entry: values){
			Entry e = (Entry)entry;
            if(e.getValue()!=null) {
				String title = e.getValue().toString();
				HSSFCell cell = ExcelUtil.getCell(sheet, 0, i);
				cell.setCellStyle(headerStyle);
				ExcelUtil.setText(cell,title);
				i++;
            }
        }
		sheet.getRow(0).setHeight(height);
		
		//内容样式
		HSSFCellStyle contentStyle = workbook.createCellStyle(); 
		contentStyle.setAlignment(HorizontalAlignment.CENTER);
		
		for(int j=0; j<varList.size(); j++){
			Map vpd = varList.get(j);
			
			Set keys = titles.keySet();
			int k=0;
			for(Object value: keys){
	            if(value!=null) {
	            	String varstr = vpd.get(value.toString()) != null ? vpd.get(value.toString()).toString() : "";
					HSSFCell cell = ExcelUtil.getCell(sheet, j+1, k);
					cell.setCellStyle(contentStyle);
					ExcelUtil.setText(cell,varstr);
					k++;
	            }
	            
	        }
			
			
		}
		
				
		workbook.write(out);
    } catch (Exception e) {  
    	e.printStackTrace();
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		logger.error(sw.toString()); 
    }finally {
    	out.flush();
		out.close();
    }
		
}    
	    
	    
	    
	    
	    
	    
	    
	    
	public static HSSFCell getCell(HSSFSheet sheet, int row, int col)
   {
     HSSFRow sheetRow = sheet.getRow(row);
     if (sheetRow == null) {
       sheetRow = sheet.createRow(row);
     }
     HSSFCell cell = sheetRow.getCell(col);
     if (cell == null) {
       cell = sheetRow.createCell(col);
     }
     return cell;
   }
  

	public static void setText(HSSFCell cell, String text)
   {
     cell.setCellType(1);
     cell.setCellValue(text);
   }
 
	    
	    
	    
	    
	    
	    

	    
	    
}
