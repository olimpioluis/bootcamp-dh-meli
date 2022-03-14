package ex02;

import java.util.ArrayList;

public class Distributor {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        double totalSold = 0;

        Product perishable1 = new Perishable("Figado", 100.00, 7);
        Product perishable2 = new Perishable("Ovo", 200.00, 7);
        Product perishable3 = new Perishable("Leite", 300.00, 7);
        Product perishable4 = new Perishable("Carne", 400.00, 7);
        Product perishable5 = new Perishable("Banana", 500.00, 7);

        Product nonPerishable1 = new NonPerishable("Keychron", 2500.00, "Teclado");
        Product nonPerishable2 = new NonPerishable("Geladeira", 500.00, "Eletrodomestico");
        Product nonPerishable3 = new NonPerishable("IPhone 12", 1500.00, "Celular");
        Product nonPerishable4 = new NonPerishable("MacBook", 2000.00, "Notebook");
        Product nonPerishable5 = new NonPerishable("Fone", 50.00, "Fone");

        products.add(perishable1);
        products.add(perishable2);
        products.add(perishable3);
        products.add(perishable4);
        products.add(perishable5);

        products.add(nonPerishable1);
        products.add(nonPerishable2);
        products.add(nonPerishable3);
        products.add(nonPerishable4);
        products.add(nonPerishable5);



        for(Product product: products) {
            totalSold += product.calculate(1);
        }

        System.out.println(totalSold);
    }
}
