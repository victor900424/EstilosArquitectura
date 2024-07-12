package soa;

public class RemittanceService implements Service {
    private String account;
    private double amount;

    public RemittanceService(String account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        System.out.println("Procesando remesa...");
        System.out.println("Cuenta: " + account);
        System.out.println("Monto: " + amount);
    }
}
