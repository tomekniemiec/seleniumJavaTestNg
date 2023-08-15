package utils;


import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class PdfUtils {
    private static final String PDF_FILE = "src/test/java/dataTest/file.pdf";

    public static String extractTextFromPDF(String filePath) {
        String text = "";
        try {
            PDDocument document = Loader.loadPDF(new File(filePath));
            PDFTextStripper pdfTextStripper = new PDFTextStripper();
            text = pdfTextStripper.getText(document);
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(text);
        return text;
    }

    public static void main(String[] args) {
        extractTextFromPDF(PDF_FILE);
    }
}

