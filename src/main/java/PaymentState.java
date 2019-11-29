public class PaymentState implements MachineState {
    public double money;
    public PaymentState(double money) {
        this.money = money;
    }

    public void HandleState(Machine machine) {
        machine.balance= machine.getBalance()+money;
        // TODO: change the state
    }

}
