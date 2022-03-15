package ex01;

public class Transfer implements Transaction {
    public String transfer(Client client) {
        if (client.equals(Client.EXECUTIVE)) return transactionOk();
        return transactionNoOk();
    };

    @Override
    public String transactionOk() {
        return "Realizando transferencia...";
    }

    @Override
    public String transactionNoOk() {
        return "Nao eh possivel realizar uma transferencia com esse tipo de cliente";
    }
}
