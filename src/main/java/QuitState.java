import javax.swing.*;

public class QuitState implements MachineState {

    public double balance;
    public QuitState(double balance) {
        this.balance = balance;
    }
    @Override
    public void HandleState(Machine machine) {
        System.out.println("inside quit state");
        int a = JOptionPane.showConfirmDialog(null,"İşlemi iptal etmek istediğinizden emin misiniz?"," ",JOptionPane.YES_NO_OPTION);
        if(a==JOptionPane.NO_OPTION){
            //go back to waiting state
            machine.setState(new InitialState(this.balance));
        }
        else{
            JOptionPane.showMessageDialog(null, "Para iadeniz yapılıyor...\n"+machine.coins.findChange(balance));
            machine.balance = 0;
            //go back to initial state
            machine.setState(new InitialState());
        }


    }
}
