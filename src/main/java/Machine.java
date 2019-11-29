import java.util.ArrayList;
import java.util.List;

public class Machine {

    private MachineState state;
    ArrayList<Product> products = new ArrayList<Product>();

    public Machine() {
        products.add(new Product("Kola",15));
        products.add(new Product("Fanta",20));
        products.add(new Product("Gazoz",30));

        // initial state

    }
    public MachineState getState() {
        return state;
    }
    public void setState(MachineState state) {
        this.state = state;
    }
    public void RequestProduct(String product, double money){
        // change state

    }



}
