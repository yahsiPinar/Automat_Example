import javax.naming.InitialContext;
import javax.swing.*;
import java.util.HashMap;

public class ExitState implements MachineState {

    private double change;
    ExitState(double change) {
        this.change = change;
    }
    @Override
    public void HandleState(Machine machine) {
        int a = JOptionPane.showConfirmDialog(null,"Alışverişe devam etmek istiyor musunuz?"," ",JOptionPane.YES_NO_OPTION);
        if(a==JOptionPane.YES_OPTION){
            //go back to waiting state
            JOptionPane.showMessageDialog(null, "Mevcut Bakiye: \n\t"+machine.coins.findChange(change));
            machine.setState(new InitialState(this.change));
        }
        else{
            JOptionPane.showMessageDialog(null, "İşlem tamamlandı...\nİade Tutarı: \n\t"+machine.coins.findChange(change));
            //go back to initial state
            machine.setState(new InitialState());
        }

    }
}
