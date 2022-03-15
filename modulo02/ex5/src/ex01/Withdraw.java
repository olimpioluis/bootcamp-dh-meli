package ex01;

public class Withdraw implements Transaction {
    public String withdraw(Client client) {
        if (client.equals(Client.BASIC) || client.equals(Client.COLLECTORS)) return transactionOk();
        return transactionNoOk();
    };

    @Override
    public String transactionOk() {
        return "Realizando saque...";
    }

    @Override
    public String transactionNoOk() {
        return "Nao eh possivel realizar um saque com esse tipo de cliente ";
    }
}
