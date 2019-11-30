import javax.swing.*;

public class BuyingState implements MachineState {
    public double cost;
    public double balance;
    public String product;
    public BuyingState(double cost, double balance, String product) {
        this.cost = cost;
        this.balance = balance;
        this.product = product;
    }
    public void HandleState(Machine machine) {
        // TODO: change the state
        System.out.println("inside buying state");
        JOptionPane.showMessageDialog(null, "Ürün: "+product+"\nÖdenen Tutar: "+this.balance+"\nToplam: "+this.cost+"\nPara Üstü: "+(this.balance-this.cost));
        machine.setState(new ExitState(this.balance-this.cost));
    }

}
