package org.sgk.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.sgk.domain.Member;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class ExcelMemberSummary extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		List<Member> members = (List<Member>) model.get("members");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		HSSFSheet sheet = workbook.createSheet();
		
		HSSFRow header = sheet.createRow(0);
		header.createCell(0).setCellValue("Name");
		header.createCell(1).setCellValue("Phone");
		header.createCell(2).setCellValue("Email");
		
		int rowNum=1;
		for(Member member : members)
		{
			HSSFRow row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(member.getName());
			row.createCell(1).setCellValue(member.getPhone());
			row.createCell(2).setCellValue(member.getEmail());
		}
	}

}
