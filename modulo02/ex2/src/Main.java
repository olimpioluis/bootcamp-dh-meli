import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Criando alguns participantes
        Participant participant1 = new Participant("123456","Joao", "Gomes",40,"(55)9999999", "(55)99999999", "A+");
        Participant participant2 = new Participant("123457","Luis", "Goncalves",47,"(55)9999999", "(55)99999999", "A+");
        Participant participant3 = new Participant("123458","Pedro", "Teixeira",14,"(55)9999999", "(55)99999999", "A+");
        Participant participant4 = new Participant("123459","Vitoria", "Lima",10,"(55)9999999", "(55)99999999", "A+");

        //Criando os 3 circuitos
        final Circuit smallCircuit = new Circuit(Category.SMALL, 2);
        final Circuit mediumCircuit = new Circuit(Category.MEDIUM, 5);
        final Circuit advancedCircuit = new Circuit(Category.ADVANCED, 10);

        //Preenchendo Inscrições
        Subscription subscription1 = new Subscription(participant1, Category.SMALL);
        Subscription subscription2 = new Subscription(participant2, Category.SMALL);
        Subscription subscription3 = new Subscription(participant3, Category.SMALL);
        Subscription subscription4 = new Subscription(participant4, Category.SMALL);

        Subscription subscription5 = new Subscription(participant1, Category.MEDIUM);
        Subscription subscription6 = new Subscription(participant2, Category.MEDIUM);
        Subscription subscription7 = new Subscription(participant3, Category.MEDIUM);
        Subscription subscription8 = new Subscription(participant4, Category.MEDIUM);

        Subscription subscription9 = new Subscription(participant1, Category.ADVANCED);
        Subscription subscription10 = new Subscription(participant4, Category.ADVANCED);
        Subscription subscription11 = new Subscription(participant2, Category.ADVANCED);


        //Adicionando participants aos circuitos;
        smallCircuit.addSubscription(subscription1);
        smallCircuit.addSubscription(subscription2);
        smallCircuit.addSubscription(subscription3);
        smallCircuit.addSubscription(subscription4);

        System.out.println("*********************************");
        mediumCircuit.addSubscription(subscription5);
        mediumCircuit.addSubscription(subscription6);
        mediumCircuit.addSubscription(subscription7);
        mediumCircuit.addSubscription(subscription8);
        System.out.println("*********************************");

        advancedCircuit.addSubscription(subscription9);
        advancedCircuit.addSubscription(subscription10);
        advancedCircuit.addSubscription(subscription11);

        System.out.println("*********************************");
        //Tentando adicionar um participante 2x na mesma circuito
        smallCircuit.addSubscription(subscription1);
        System.out.println(advancedCircuit.toString());

        System.out.println("*********************************");
        //removendo um participante de um circuito
        advancedCircuit.removerSubscription("Luis");

        System.out.println("*********************************");

        //Exibindo as listas de inscritos por categoria
        System.out.println("***********Inscritos na Categoria PEQUENO**********************");
        System.out.println(smallCircuit.toString());

        System.out.println("***********Inscritos na Categoria MEDIO**********************");
        System.out.println(mediumCircuit.toString());

        System.out.println("***********Inscritos na Categoria AVANCADO**********************");
        System.out.println(advancedCircuit.toString());

        //Adicionando a lista de circuitos a Corrida na Selva
        ArrayList<Circuit> circuitsList = new ArrayList<>();
        circuitsList.add(smallCircuit);
        circuitsList.add(mediumCircuit);
        circuitsList.add(advancedCircuit);
        JungleRun race = new JungleRun(circuitsList);
        System.out.println(race.toString());

    }
}
