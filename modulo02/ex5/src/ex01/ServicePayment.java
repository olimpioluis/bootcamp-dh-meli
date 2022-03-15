package ex01;

public class ServicePayment implements Transaction{
    public String servicePayment(Client client) {
        if (client.equals(Client.BASIC)) return transactionOk();
        return transactionNoOk();
    };

    @Override
    public String transactionOk() {
        return "Realizando pagamento de servico...";
    }

    @Override
    public String transactionNoOk() {
        return "Nao eh possivel realizar um pagamento de servico com esse cliente";
    }
}
