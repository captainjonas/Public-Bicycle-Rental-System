package com.aowin.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.aowin.model.Station;

public class ExcelUtil {

	public static void writeExcel(String filePath, Map<Integer,String[]> map,List<Station> lists) throws IOException{
		int rowIndex=0;
		OutputStream os=new FileOutputStream(filePath);
		HSSFWorkbook xls=new HSSFWorkbook();
		HSSFSheet sheet=xls.createSheet();
		for(int j=0;j<map.size();j++){
			HSSFRow row=sheet.createRow(rowIndex++);
			String[] titles=map.get(j);
			for(int i=0;i<titles.length;i++){
				row.createCell(i).setCellValue(titles[i]);
			}
		}
		for(Station s:lists){
			HSSFRow rowT=sheet.createRow(rowIndex++);
			rowT.createCell(0).setCellValue(s.getStation_id());
			rowT.createCell(1).setCellValue(s.getStation_code());
			rowT.createCell(2).setCellValue(s.getStation_name());
			rowT.createCell(3).setCellValue(s.getLongitude());
			rowT.createCell(4).setCellValue(s.getLatitude());
			rowT.createCell(5).setCellValue(s.getBicycle_pile_num());
			rowT.createCell(6).setCellValue(s.getAddress());
			rowT.createCell(7).setCellValue(s.getBuild_time());
			rowT.createCell(8).setCellValue(s.getRun_time());
			rowT.createCell(9).setCellValue(s.getPile_id());
			rowT.createCell(10).setCellValue(s.getPile_code());
			rowT.createCell(11).setCellValue(s.getInstall_time());
		}
		xls.write(os);
		os.flush();
		os.close();
		xls.close();
	}
	

	public ExcelUtil() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
