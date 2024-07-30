// FactoryMethodPatternDemo.java
public class FactoryMethodPatternDemo {
    public static void main(String[] args) {
        // Create factory instances
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        // Create documents using factories
        Document wordDoc = wordFactory.createDocument();
        Document pdfDoc = pdfFactory.createDocument();
        Document excelDoc = excelFactory.createDocument();

        // Open documents
        wordDoc.open();
        pdfDoc.open();
        excelDoc.open();
    }
}
