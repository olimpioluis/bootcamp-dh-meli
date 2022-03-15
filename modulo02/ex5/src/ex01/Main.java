package ex01;

public class Main {
    public static void main(String[] args) {
        // Criando clientes
        Executive executive = new Executive();
        Basic basic = new Basic();
        Collector collector = new Collector();

        // Criando transacoes
        CheckBalance balance = new CheckBalance();
        Deposit deposit = new Deposit();
        ServicePayment servicePayment = new ServicePayment();
        Transfer transfer = new Transfer();
        Withdraw withdraw = new Withdraw();

        // Realizando transacoes

        System.out.println("-----------------------------------");
        System.out.println("BASICO");
        System.out.println(deposit.deposit(executive.getType()));
        System.out.println(transfer.transfer(executive.getType()));

        System.out.println("-----------------------------------");
        System.out.println("COBRADOR");
        System.out.println(balance.checkBalance(basic.getType()));
        System.out.println(servicePayment.servicePayment(basic.getType()));
        System.out.println(withdraw.withdraw(basic.getType()));

        System.out.println("-----------------------------------");
        System.out.println("EXECUTIVO");
        System.out.println(withdraw.withdraw(collector.getType()));
        System.out.println(balance.checkBalance(collector.getType()));

        // Tentando realizar transacoes nao permitidas
        System.out.println("-----------------------------------");
        System.out.println("TESTANDO ERROS");
        System.out.println(withdraw.withdraw(executive.getType()));
        System.out.println(balance.checkBalance(executive.getType()));

    }
}
