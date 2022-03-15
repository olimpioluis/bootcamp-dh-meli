package ex02.entities;

import ex02.interfaces.Printable;

public class PDFBookFile implements Printable {
    private int pagesNumber;
    private String author;
    private String title;
    private String genre;


    @Override
    public void print() {
        System.out.println("Imprimindo livro em PDF...");
    }
}
