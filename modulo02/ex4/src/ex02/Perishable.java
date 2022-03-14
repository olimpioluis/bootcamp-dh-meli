package ex02;

public class Perishable extends Product {
    private int daysToDueDate;

    public Perishable(String name, double price, int daysToDueDate) {
        super(name, price);
        this.daysToDueDate = daysToDueDate;
    }

    public int getDaysToDueDate() {
        return daysToDueDate;
    }

    public void setDaysToDueDate(int daysToDueDate) {
        this.daysToDueDate = daysToDueDate;
    }

    @Override
    public String toString() {
        return "Perishable{" +
                "daysToDueDate=" + daysToDueDate +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public double calculate(int productAmount) {
        double discount = 0;

        switch (daysToDueDate) {
            case 1:
                discount /= 4;
                break;
            case 2:
                discount /= 3;
                break;
            case 3:
                discount /= 2;
                break;
        }

        return super.calculate(productAmount) - discount;
    }
}
