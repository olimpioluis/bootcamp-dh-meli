public class Person {
    private String ID;
    private String name;
    private int age;
    private double weight;
    private double height;

    public Person() {

    }

    public Person(String ID, String name, int age) {
        this.ID = ID;
        this.name = name;
        this.age = age;
    }

    public Person(String ID, String name, int age, double weight, double height) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    public short calculateIMC() {
        double imc =  weight / Math.pow(height, 2);

        if (imc < 20) return -1;
        else if (imc >= 20 && imc <= 25) return 0;
        else return 1;
    }

    public boolean isOfAge() {
        return age >= 18;
    }

    @Override
    public String toString() {
        return "--------- Dados --------- \n" +
                "ID = " + ID + "\n" +
                "Nome = " + name + "\n" +
                "Idade = " + age + "\n" +
                "Peso = " + weight + "\n" +
                "Altura = " + height + "\n" +
                "-------------------------";
    }
}
