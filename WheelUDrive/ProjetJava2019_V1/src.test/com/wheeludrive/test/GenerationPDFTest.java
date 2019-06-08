package com.wheeludrive.test;

import java.io.FileOutputStream;

import org.junit.Test;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GenerationPDFTest {

	@Test
	public void testCreatePDF() {
		try {
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream("D:\\test.pdf"));
			document.open();
			document.add(new Paragraph("Test création pdf"));
			document.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
