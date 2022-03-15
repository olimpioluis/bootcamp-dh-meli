package ex02.app;

import ex02.entities.*;

public class Main {
    public static void main(String[] args) {
        // Criando impressora
        Printer printer = new Printer();

        // Criando arquivos
        PDFBookFile book = new PDFBookFile();
        ReportFile report = new ReportFile();
        ResumeFile resume = new ResumeFile(new Person("Luis", "123-456-789-04", 22));

        // Imprimindo arquivos
        System.out.println("-----------------------------------");
        System.out.println("IMPRIMINDO");
        printer.startPrint(book);
        printer.startPrint(report);
        printer.startPrint(resume);
    }
}
