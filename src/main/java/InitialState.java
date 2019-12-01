public class InitialState implements MachineState{
    private double balance;

    InitialState() {
        this.balance = 0.00;
    }

    InitialState(double balance) {
        this.balance = balance;
    }

    public void HandleState(Machine machine) {
        machine.balance = balance;
        System.out.println("initial state");
    }
}
