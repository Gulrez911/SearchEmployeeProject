package com.kgate.controller;

import java.awt.Graphics2D;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.criteria.Join;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import com.itextpdf.awt.DefaultFontMapper;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import com.kgate.model.Employee;
import com.kgate.model.Skill;
import com.kgate.model.TaskDTO;

public class EmployeeReportBuilder extends AbstractITextPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*doc.add(new Paragraph("Details of Employee"));*/
		Image i=Image.getInstance("emp.png");
		
		i.setAbsolutePosition(-50,680);
		doc.add(i);
		Paragraph p2=new Paragraph("Details of Employee:");
		p2.setSpacingAfter(20f);
		p2.setAlignment(Element.ALIGN_CENTER);
			
		doc.add(p2);
		
		int delay=0;
		Employee e = (Employee) model.get("e");
	List<TaskDTO> td = (List<TaskDTO>) model.get("tdo");
	List<String> ls=(List<String>) model.get("lskill");
	List<Entry<String,Integer>> list=(List<Entry<String, Integer>>) model.get("list");
	
	
	 Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		PdfPTable table = new PdfPTable(2);
		/*table.getDefaultCell().setBorder(0);*/
		table.addCell("Name:");
		table.addCell(e.getName());
		
		PdfPTable table12 = new PdfPTable(2);
		table12.addCell("Email:");
		table12.addCell(e.getEmail());
		table12.addCell("Address:");
		table12.addCell(e.getAddress());
table12.addCell("Telephone No:");
table12.addCell(e.getTelephone());


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
table.addCell("Contact:");
table.addCell(table12);

		doc.add(table);
		doc.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------"));
		
		doc.add(Chunk.NEWLINE);
	    
	     
		Paragraph p1=new Paragraph("Employee Project Details:");
		p1.setSpacingAfter(15f);
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
		
		doc.add(Chunk.NEWLINE);
	    
	     
		Paragraph p=new Paragraph("Performance Status:");
		p.setSpacingAfter(15f);
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
	     
	     doc.add(Chunk.NEWLINE);
	     
	     
	     Paragraph p11=new Paragraph("Most delayed tasks:");
			p11.setSpacingAfter(15f);
			p11.setAlignment(Element.ALIGN_CENTER);
			doc.add(p11);
			
			PdfPTable t1=new PdfPTable(2);
			PdfPCell c=new PdfPCell();
			c.setBackgroundColor(BaseColor.YELLOW);
            c.setPadding(5);
            c.setPhrase(new Phrase("Task Name",font));
            t1.addCell(c);
            c.setPhrase(new Phrase("Delay Days",font));
            t1.addCell(c);
            int size=list.size();
            DefaultPieDataset defaultCategoryDataset = new DefaultPieDataset();
            if(size>=5)
            {
            	 /*for(Map.Entry<String, Integer> entry:list){
                     t1.addCell(entry.getKey());
                     t1.addCell(entry.getValue().toString());
                     System.out.println("sorted pdf "+entry.getKey()+" ==== "+entry.getValue());
                      
             	 }*/
            	 for(int ij=0;ij<3;ij++)
            	 {
            		 t1.addCell(list.get(ij).getKey());
                 	t1.addCell(list.get(ij).getValue().toString());
                 	 
                 	 
            		 
            	 }
            	
            }else
            {
            	t1.addCell(list.get(0).getKey());
            	t1.addCell(list.get(0).getValue().toString());
            }
           
            doc.add(t1);
            
            for(int i1=0;i1<size;i1++)
            {
            	 defaultCategoryDataset.setValue(list.get(i1).getKey(), list.get(i1).getValue());
            }
            
            JFreeChart jFreeChart = ChartFactory.createPieChart(
                    "All Tasks ",  //pie chart title
                    defaultCategoryDataset, //pie chart dataset
                    false, false, false);  //pie chart> legend, tooltips and
            
            PdfContentByte pdfContentByte = writer.getDirectContent();
            int width = 350; //width of PieChart
            int height = 150; //height of pieChart
            PdfTemplate pdfTemplate = pdfContentByte.createTemplate(width, height);
            
            //create graphics
            @SuppressWarnings("deprecation")
			Graphics2D graphics2d = pdfTemplate.createGraphics(width, height,
                         new DefaultFontMapper());
            
            //create rectangle
            java.awt.geom.Rectangle2D rectangle2d = new java.awt.geom.Rectangle2D.Double(
                         0, 0, width, height);
  
            jFreeChart.draw(graphics2d, rectangle2d);
            graphics2d.dispose();
            pdfContentByte.addTemplate(pdfTemplate, 60, 50); //0, 0 will draw PIE chart on bottom left of page
	}

}
