import javax.swing.*;
import java.util.ArrayList;

public class Machine {

    public MachineState state;
    public double balance;
    ArrayList<Product> products = new ArrayList<Product>();
    Coins coins = new Coins();

    public Machine() {
        products.add(new Product("Kola",15));
        products.add(new Product("Fanta",20));
        products.add(new Product("Gazoz",30));

        setState(new InitialState());

    }
    public MachineState getState() {
        return state;
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
            System.out.println("inside request product");
            setState(new BuyingState(products.get(pr).Price,this.balance,products.get(pr).Name));
        }
        else{
            JOptionPane.showMessageDialog(null,"Bakiyeniz yetersiz :("," ",JOptionPane.INFORMATION_MESSAGE);
            setState(new InitialState(money));
        }
    }
}
