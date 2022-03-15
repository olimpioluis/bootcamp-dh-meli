package ex02.entities;

import ex02.interfaces.Printable;

public class Printer {
    public void startPrint(Printable file) {
        file.print();
    }
}
