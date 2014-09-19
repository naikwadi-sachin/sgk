package org.sgk.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sgk.domain.Member;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

public class PdfMemberSummary extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		List<Member> members = (List<Member>) model.get("members");
		
		Table table = new Table(3);
		table.addCell("Name");
		table.addCell("Phone");
		table.addCell("Email");
		
		for(Member member : members)
		{
			table.addCell(member.getName());
			table.addCell(member.getPhone());
			table.addCell(member.getEmail());
		}
		
		document.add(table);
		
	}

}
