public class Main {
    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person("123", "Luis", 22);
        Person person3 = new Person("456", "Felipe", 25, 70.0, 1.80);

        // Person person4 = new Person("Joao", 22); Gera erro pois não encontra um construtor com esses parametros

        short imcCode = person3.calculateIMC();

        if (imcCode == -1) System.out.println("Nivel de peso: Abaixo do peso");
        else if (imcCode == 0) System.out.println("Nivel de peso: Peso saudavel ");
        else System.out.println("Nivel de peso: Sobrepeso");

        if (person3.isOfAge()) System.out.println("Nivel de idade: Maior de idade");
        else System.out.println("Nivel de idade: Menor de idade");

        System.out.println();
        System.out.println(person3.toString());
    }
}
