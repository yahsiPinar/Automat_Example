public class InitialState implements MachineState{
    public double balance;
    public InitialState() {
        this.balance = 0.00;
    }
    public InitialState(double balance) {
        this.balance = balance;
    }
    public void HandleState(Machine machine) {
        machine.balance = balance;
        System.out.println("initial state");
    }
}
