import javax.naming.InitialContext;
import javax.swing.*;

public class ExitState implements MachineState {

    public double balance,cost;
    public ExitState(double balance) {
        this.balance = balance;
    }
    @Override
    public void HandleState(Machine machine) {

        System.out.println("inside exit state");
        int a = JOptionPane.showConfirmDialog(null,"Alışverişe devam etmek istiyor musunuz?"," ",JOptionPane.YES_NO_OPTION);
        if(a==JOptionPane.YES_OPTION){
            //TODO: go back to waiting state
            machine.setState(new InitialState(this.balance));
        }
        else{
            machine.balance = 0;
            JOptionPane.showMessageDialog(null, "İşlem tamamlandı...");
            //TODO: go back to initial state
            machine.setState(new InitialState());
        }

    }
}
