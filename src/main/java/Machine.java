import java.util.ArrayList;
import java.util.List;

public class Machine {

    public MachineState state;
    public double balance;
    ArrayList<Product> products = new ArrayList<Product>();

    public Machine() {
        products.add(new Product("Coke",15));
        products.add(new Product("Fanta",20));
        products.add(new Product("Soda",30));

        // initial state

    }
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //    public MachineState getState() {
//        return state;
//    }
//    public void setState(MachineState state) {
//        this.state = state;
//    }
    public void RequestProduct(String product, double money){
        // change state

    }



}
