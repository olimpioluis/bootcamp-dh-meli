package ex02.entities;

import ex02.interfaces.Printable;

public class ReportFile implements Printable {
    private String reportText;
    private int pagesNumber;
    private String author;
    private String reviewer;

    @Override
    public void print() {
        System.out.println("Imprimindo relatorio...");
    }
}
