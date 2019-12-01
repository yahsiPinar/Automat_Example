import javax.swing.*;
import java.util.ArrayList;

public class Machine {

    private MachineState state;
    public double balance;
    ArrayList<Product> products = new ArrayList<Product>();
    Coins coins = new Coins();

    Machine() {
        products.add(new Coke());
        products.add(new Fanta());
        products.add(new Soda());
        setState(new InitialState());
    }
    public void setState(MachineState state) {
        this.state = state;
        state.HandleState(this);
    }

    public void RequestProduct(String product, double money){
        int pr =0;
        for(int i=0; i<products.size();i++){
            if (products.get(i).Name.equals(product)){
                pr = i;
                break;
            }
        }
        if (products.get(pr).Price<=money){
            setState(new BuyingState(products.get(pr).Price,this.balance,products.get(pr).Name));
        }
        else{
            JOptionPane.showMessageDialog(null,"Bakiyeniz yetersiz :("," ",JOptionPane.INFORMATION_MESSAGE);
            setState(new InitialState(money));
        }
    }
}
