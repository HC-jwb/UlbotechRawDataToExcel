package demo.excelExport;

import java.io.ByteArrayInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

import demo.model.Data;

public class ExportToXls {
	private static String[] cloumnNames = {"IMEI","TIME","LBS","GPS","STT","MGR","FUL","ADC","OBD","HDB","EVT","VIN"};
	LocalDateTime ldt = LocalDateTime.now();
	
	private static String TITLE_OF_EXCEL_FILE = String.format("Report_%s", DateTimeFormatter.ofPattern("YYYY-MM-dd_kk:mm", Locale.KOREAN).format(ldt));
	public ByteArrayInputStream exportToExcel(ArrayList<Data> list) {
		
		Workbook xlsxWb = new XSSFWorkbook();
		final int firstColumnOffset = 1;
		
	}
	
	
	

}
