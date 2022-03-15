package ex01;

public class Deposit implements Transaction {
    public String deposit(Client client) {
        if (client.equals(Client.EXECUTIVE)) return transactionOk();
        return transactionNoOk();
    };

    @Override
    public String transactionOk() {
        return "Realizando deposito...";
    }

    @Override
    public String transactionNoOk() {
        return "Nao eh possivel depositar com esse tipo de cliente";
    }
}
