import javax.swing.*;

public class BuyingState implements MachineState {
    private double cost;
    private double balance;
    private String product;

    BuyingState(double cost, double balance, String product) {
        this.cost = cost;
        this.balance = balance;
        this.product = product;
    }
    public void HandleState(Machine machine) {
        JOptionPane.showMessageDialog(null, "Ürün: " + product + "\nÖdenen Tutar: " + this.balance + "\nToplam: " + this.cost + "\nPara Üstü: " + (this.balance - this.cost));
        if ((this.balance - this.cost) == 0) {
            JOptionPane.showMessageDialog(null, "İşlem tamamlandı...\nİade Tutarı: \n\t"+machine.coins.findChange(0));
            machine.setState(new InitialState());
        } else {
            machine.setState(new ExitState(this.balance - this.cost));
        }
    }
}
