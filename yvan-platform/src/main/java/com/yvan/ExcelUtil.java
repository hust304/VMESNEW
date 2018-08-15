package com.yvan;

import java.io.*;
import java.util.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yvan.template.ExcelAjaxTemplate;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;


public class ExcelUtil{
	public static Logger logger = Logger.getLogger(ExcelUtil.class.getName());
	public final static String SHEET_NAME = "sheet1";


	public static void excelExportByDataList(HttpServletResponse response,
	                                         String fileName,
	                                         List<LinkedHashMap<String, String>> dataMapList) throws Exception {
		ServletOutputStream outputStream = null;

		try {
			response.setContentType("octets/stream;charset=utf-8");
			response.addHeader("Content-disposition", "attachment;filename=" + fileName + ".xls");
			outputStream = response.getOutputStream();

			//1. 生成Excel文件对象<HSSFWorkbook>: 业务查询数据结构体-Excel对象
			HSSFWorkbook hssfWorkbook = loadExcelByDataList(dataMapList);
			hssfWorkbook.write(outputStream);
		} catch (Exception e) {

		} finally {
			if (outputStream != null) {
				outputStream.flush();
				outputStream.close();
			}
		}

	}

	/**
	 * 业务查询数据结构体-生成Excel对象
	 * 1. 第一行: 栏位编码Map<栏位编码, 栏位编码>
	 * 2. 第二行: 栏位名称Map<栏位编码, 栏位名称>
	 * 3. 第三行: 栏位值Map<栏位编码, 栏位值>
	 *
	 * @param dataMapList  业务查询数据结构体
	 * @return
	 */
	public static HSSFWorkbook loadExcelByDataList(List<LinkedHashMap<String, String>> dataMapList) {
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
		HSSFSheet sheet = hssfWorkbook.createSheet(SHEET_NAME);
		if (dataMapList == null || dataMapList.size() == 0) {return hssfWorkbook;}

		//设置列表样式(第一行,第二行)
		CellStyle titleStyle0 = getTitleStyle(hssfWorkbook);
		HSSFCell cell = null;
		for (int i = 0; i < dataMapList.size(); i++) {
			HSSFRow row = sheet.createRow(i);

			//设置Excel行高度
			row.setHeight((short) 350);
			if (i == 0) {
				row.setZeroHeight(true);
			} else if (i == 1) {
				row.setHeight((short) 450);
			}

			//获取Excel导入列数据
			LinkedHashMap columnMap = dataMapList.get(i);
			int indexMap = 0;
			for (Iterator iterator = columnMap.keySet().iterator(); iterator.hasNext();) {
				String columnCode = iterator.next().toString().trim();
				String columnValue = columnMap.get(columnCode).toString();

				//栏位编码_hide: 该列为隐藏列
				if (columnCode.indexOf("_hide") != -1) {
					sheet.setColumnHidden(indexMap, true);
				}

				//创建Excel单元格
				cell = row.createCell(indexMap);
				//数据行
				cell.setCellValue(columnValue);
				//(第一行,第二行)
				if (i == 0 || i == 1) {
					RichTextString text = new HSSFRichTextString(columnValue);
					cell.setCellValue(text);
					cell.setCellStyle(titleStyle0);
					sheet.setColumnWidth(indexMap, 5000);
				} else if (i > 1 && i % 2 == 0) {
					//数据行样式
					cell.setCellStyle(getTwoStyle(hssfWorkbook));
				} else if (i > 1 && i % 2 != 0) {
					cell.setCellStyle(getOneStyle(hssfWorkbook));
				}

				indexMap = indexMap + 1;
			}
		}

		return hssfWorkbook;
	}




	/**
	 * @param fi //文件流
	 * @param startrow //开始行号
	 * @param startcol //开始列号
	 * @param sheetnum //sheet
	 * @return list
	 */
	public static List<Object> readExcel(InputStream fi, int startrow, int startcol, int sheetnum) {
		List<Object> varList = new ArrayList<Object>();

		return varList;
	}

	/**
	 * @param target //文件
	 * @param startrow //开始行号
	 * @param startcol //开始列号
	 * @param sheetnum //sheet
	 * @return list
	 */
//	public static List<Object> readExcel(File target, int startrow, int startcol, int sheetnum) {
//		List<Object> varList = new ArrayList<Object>();
//
//		try {
//			FileInputStream fi = new FileInputStream(target);
//			varList = readExcel(fi,startrow,startcol,sheetnum);
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//
//		return varList;
//	}

	
	
	/**
	 * @param filepath //文件路径
	 * @param filename //文件名
	 * @param startrow //开始行号
	 * @param startcol //开始列号
	 * @param sheetnum //sheet
	 * @return list
	 */
//	public static List<Object> readExcel(String filepath, String filename, int startrow, int startcol, int sheetnum) {
//		List<Object> varList = new ArrayList<Object>();
//		File target = new File(filepath, filename);
//		varList = readExcel(target,startrow,startcol,sheetnum);
//		return varList;
//	}

	
	
	/**
	 * 读取到字节数组2
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
//	public static byte[] toByteArray(String filePath) throws IOException {
//		File f = new File(filePath);
//		if (!f.exists()) {
//			throw new FileNotFoundException(filePath);
//		}
//		FileChannel channel = null;
//		FileInputStream fs = null;
//		try {
//			fs = new FileInputStream(f);
//			channel = fs.getChannel();
//			ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
//			while ((channel.read(byteBuffer)) > 0) {
//				// do nothing
//				// System.out.println("reading");
//			}
//			return byteBuffer.array();
//		} catch (IOException e) {
//			e.printStackTrace();
//			throw e;
//		} finally {
//			try {
//				channel.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			try {
//				fs.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}
	
	/**
	 * @param response 
	 * @param 		//文件完整路径(包括文件名和扩展名)
	 * @param 		//下载后看到的文件名
	 * @return  文件名
	 */
//	public static void excelDownload(final HttpServletResponse response, String filePath, String fileName) throws Exception{
//
//		byte[] data = toByteArray(filePath);
//	    fileName = URLEncoder.encode(fileName, "UTF-8");
//	    response.reset();
//	    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
//	    response.addHeader("Content-Length", "" + data.length);
//	    response.setContentType("application/octet-stream;charset=UTF-8");
//	    OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
//	    outputStream.write(data);
//	    outputStream.flush();
//	    outputStream.close();
//	    response.flushBuffer();
//
//	}
	    
	    
//	public static void buildExcelDocument( HttpServletRequest request,HttpServletResponse response,ExcelAjaxTemplate callBack) throws Exception {
//			// TODO Auto-generated method stub
//    	ServletOutputStream out = response.getOutputStream();
//    	try{
//			HSSFWorkbook workbook = new HSSFWorkbook();
//			response.setContentType("application/octet-stream");
//			response.setHeader("Content-Disposition", "attachment;filename=" + new SimpleDateFormat("yyyyMMddHH:mm:ss").format(new Date()) + ".xls");
//			response.setContentType("text/html;charset=ISO-8859-1");
//
//			callBack.execute(request,workbook);
//
//			workbook.write(out);
//	    } catch (Exception e) {
//        	e.printStackTrace();
//			StringWriter sw = new StringWriter();
//			e.printStackTrace(new PrintWriter(sw));
//			logger.error(sw.toString());
//        }finally {
//        	out.flush();
//			out.close();
//        }
//
//	}


	public static void buildDefaultExcelDocument( HttpServletRequest request,HttpServletResponse response,ExcelAjaxTemplate callBack) throws Exception {

	}
	    
	    
	    
	    
	    
	    
	    
	    
//	public static HSSFCell getCell(HSSFSheet sheet, int row, int col)
//   {
//     HSSFRow sheetRow = sheet.getRow(row);
//     if (sheetRow == null) {
//       sheetRow = sheet.createRow(row);
//     }
//     HSSFCell cell = sheetRow.getCell(col);
//     if (cell == null) {
//       cell = sheetRow.createCell(col);
//     }
//     return cell;
//   }
  

//	public static void setText(HSSFCell cell, String text)
//   {
//     cell.setCellType(1);
//     cell.setCellValue(text);
//   }

	///////////////////////////////////////////////////////////////////////////////////////////////////
	private static HSSFCellStyle getTitleStyle(HSSFWorkbook workbook) {
		// 产生Excel表头
		HSSFCellStyle titleStyle = workbook.createCellStyle();
		titleStyle.setBorderBottom(BorderStyle.DOUBLE); // 设置边框样式

		titleStyle.setBorderLeft(BorderStyle.MEDIUM); // 左边框
		titleStyle.setBorderRight(BorderStyle.MEDIUM); // 右边框
		titleStyle.setBorderTop(BorderStyle.MEDIUM); // 上边框
		titleStyle.setBorderBottom(BorderStyle.MEDIUM); // 下边框

		titleStyle.setBorderTop(BorderStyle.DOUBLE); // 顶边框
		titleStyle.setAlignment(HorizontalAlignment.CENTER);

		titleStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND); // 填充图案
		titleStyle.setFillForegroundColor(HSSFColor.SKY_BLUE.index); // 填充的背景颜色

		return titleStyle;
	}

	private static HSSFCellStyle getOneStyle(HSSFWorkbook workbook) {
		// 产生Excel表头
		// 产生Excel表头
		HSSFCellStyle style = workbook.createCellStyle();
		style.setBorderLeft(BorderStyle.THIN); // 左边框
		style.setBorderRight(BorderStyle.THIN); // 右边框
		style.setBorderBottom(BorderStyle.THIN);
		style.setBorderTop(BorderStyle.THIN);
		return style;
	}

	private static HSSFCellStyle getTwoStyle(HSSFWorkbook workbook) {
		// 产生Excel表头
		// 产生Excel表头
		HSSFCellStyle style = workbook.createCellStyle();
		style.setBorderLeft(BorderStyle.THIN);
		style.setBorderRight(BorderStyle.THIN);
		style.setBorderBottom(BorderStyle.THIN);
		style.setBorderTop(BorderStyle.THIN);

		style.setFillPattern(FillPatternType.SOLID_FOREGROUND); // 填充图案
		style.setFillForegroundColor(HSSFColor.LIGHT_TURQUOISE.index); // 填充的背景颜色
		return style;
	}
 
	    
	    
	    
	    
	    
	    

	    
	    
}
