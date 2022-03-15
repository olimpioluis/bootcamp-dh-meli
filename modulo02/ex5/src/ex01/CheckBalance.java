package ex01;

public class CheckBalance implements Transaction {
    public String checkBalance(Client client) {
        if (client.equals(Client.BASIC) || client.equals(Client.COLLECTORS)) return transactionOk();
        return transactionNoOk();
    };

    @Override
    public String transactionOk() {
        return "Realizando consulta de saldo...";
    }

    @Override
    public String transactionNoOk() {
        return "Nao eh possivel consultar o saldo com esse tipo de cliente";
    }
}
