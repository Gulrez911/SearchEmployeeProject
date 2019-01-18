package com.kgate.controller;

import java.util.List;
import java.util.Map;

import javax.persistence.criteria.Join;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.kgate.model.Employee;
import com.kgate.model.Skill;
import com.kgate.model.TaskDTO;

public class EmployeeReportBuilder extends AbstractITextPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*doc.add(new Paragraph("Details of Employee"));*/
		
		Paragraph p2=new Paragraph("Details of Employee:");
		p2.setSpacingAfter(20f);
		p2.setAlignment(Element.ALIGN_CENTER);
			
		doc.add(p2);
		
		int delay=0;
		Employee e = (Employee) model.get("e");
	List<TaskDTO> td = (List<TaskDTO>) model.get("tdo");
	List<String> ls=(List<String>) model.get("lskill");
	
	 Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		PdfPTable table = new PdfPTable(2);
		table.getDefaultCell().setBorder(0);
		table.addCell("Name:");
		table.addCell(e.getName());
		table.addCell("Email:");
		table.addCell(e.getEmail());
		table.addCell("Address:");
		table.addCell(e.getAddress());
		
table.addCell("Telephone No:");
table.addCell(e.getTelephone());
table.addCell("Skills:");
System.out.println("skanil"+ls);
String as="";
for(String s1:ls)
{
as=as+s1+" ";	
}
table.addCell(as);
table.addCell("Adhar No:");
table.addCell(e.getAadhar());	
table.addCell("Pan No:");
table.addCell(e.getPan());

		doc.add(table);
		doc.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------"));
		
		Paragraph p1=new Paragraph("Employee Project Details:");
		p1.setSpacingAfter(20f);
		p1.setAlignment(Element.ALIGN_CENTER);
		
		doc.add(p1);
		
		
		PdfPTable table1 = new PdfPTable(4);
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.ORANGE);
		cell.setPadding(5);
		cell.setPhrase(new Phrase("Project Name",font));
		table1.addCell(cell);
		cell.setPhrase(new Phrase("Task Duration",font));
		table1.addCell(cell);
		cell.setPhrase(new Phrase("Task Completion",font));
		table1.addCell(cell);
		cell.setPhrase(new Phrase("Task Deviation",font));
		table1.addCell(cell);
		for(TaskDTO t:td)
		{
			table1.addCell(t.getProject_Name());
			table1.addCell(t.getEstimateDays()+" days");
			table1.addCell(t.getActualDays()+" days");
			table1.addCell(t.getDelayDays()+" days");
			
			String j=t.getDelayDays().toString();
			int j1=Integer.parseInt(j);
			delay=delay+j1;
			
		}
		
		doc.add(table1);
		Paragraph p=new Paragraph("Performance Status:");
		p.setSpacingAfter(20f);
		p.setAlignment(Element.ALIGN_CENTER);
		doc.add(p);
		if(delay>15)
		{
			PdfPTable tabl = new PdfPTable(1);
			PdfPCell cell1 = new PdfPCell();
			cell1.setBackgroundColor(BaseColor.RED);
			cell1.setPadding(5);
			/*tabl.addCell(new Paragraph("Room for Improvement"),Font.BOLD,BaseColor.RED);*/
			cell1.setPhrase(new Phrase("Need for Improvement"));
			tabl.addCell(cell1);
			doc.add(tabl);
		}else if(delay>0 && delay<15)
		{
			PdfPTable tabl = new PdfPTable(1);
			/*tabl.addCell(new Paragraph("Acceptable"));*/
			PdfPCell cell1 = new PdfPCell();
			cell1.setBackgroundColor(BaseColor.GREEN);
			cell1.setPadding(5);
		    cell1.setPhrase(new Phrase("Acceptable"));
			tabl.addCell(cell1);
			doc.add(tabl);
		}else if(delay<-1)
		{
			PdfPTable tabl = new PdfPTable(1);
			/*tabl.addCell(new Paragraph("Exceptional"));*/
			PdfPCell cell1 = new PdfPCell();
			cell1.setBackgroundColor(BaseColor.YELLOW);
			cell1.setPadding(5);
			cell1.setPhrase(new Phrase("Exceptional"));
			tabl.addCell(cell1);
			doc.add(tabl);
			
		}
		Rectangle rect= new Rectangle(577,825,18,15); // you can resize rectangle 
	     rect.enableBorderSide(1);
	     rect.enableBorderSide(2);
	     rect.enableBorderSide(4);
	     rect.enableBorderSide(8);
	     rect.setBorderColor(BaseColor.BLACK);
	     rect.setBorderWidth(1);
	     doc.add(rect);
		
		
		
	}

}
