import javax.naming.InitialContext;
import javax.swing.*;
import java.util.HashMap;

public class ExitState implements MachineState {

    public double change;
    public ExitState(double change) {
        this.change = change;
    }
    @Override
    public void HandleState(Machine machine) {

        System.out.println("inside exit state");
        int a = JOptionPane.showConfirmDialog(null,"Alışverişe devam etmek istiyor musunuz?"," ",JOptionPane.YES_NO_OPTION);
        if(a==JOptionPane.YES_OPTION){
            //go back to waiting state
            machine.setState(new InitialState(this.change));
        }
        else{
            JOptionPane.showMessageDialog(null, "İşlem tamamlandı...\n"+machine.coins.findChange(change));
            //go back to initial state
            machine.setState(new InitialState());
        }

    }
}
