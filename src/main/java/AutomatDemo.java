import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutomatDemo extends JFrame implements ActionListener {

    private Machine machine;


    private double money;
    private TextField inputTx;
    private JLabel title, input, total, totalMoneylbl;
    private JRadioButton coke, fanta, soda, selected;
    private JButton addMoney, buy, quit, exit;
    private ButtonGroup group;

    private AutomatDemo(){

        machine = new Machine();

        selected = new JRadioButton();
        title = new JLabel("Hoşgeldiniz! Sadece 0.50 Krş, 1 TL, 5 TL, 10 TL girişi yapınız!");
        title.setBounds(50,50,500,20);
        input = new JLabel("Para Girişi: ");
        input.setBounds(50,100,90,20);
        inputTx = new TextField();
        inputTx.setBounds(140,100,50,20);
        addMoney = new JButton("Ekle");
        addMoney.setBounds(220,100,70,20);
        total = new JLabel("Bakiye: ");
        total.setBounds(50,150,90,20);
        totalMoneylbl = new JLabel("00.00 TL");
        totalMoneylbl.setBounds(140,150,90,20);

        coke = new JRadioButton("Kola 15.00 tl");
        coke.setActionCommand("Kola");
        fanta = new JRadioButton("Fanta 20.00 tl");
        fanta.setActionCommand("Fanta");
        soda = new JRadioButton("Gazoz 30.00 tl");
        soda.setActionCommand("Gazoz");

        group = new ButtonGroup();
        group.add(coke);
        group.add(fanta);
        group.add(soda);

        coke.setBounds(50,200,100,20);
        fanta.setBounds(150,200,100,20);
        soda.setBounds(250,200,110,20);

        buy = new JButton("Satın Al");
        quit = new JButton("İptal Et");
        exit = new JButton("Tamamla");

        buy.setBounds(50,300,100,20);
        quit.setBounds(200,300,100,20);

        add(inputTx);add(totalMoneylbl);add(title);add(input);add(total);add(coke);add(fanta);add(soda);add(addMoney);add(buy);add(quit);

        addMoney.addActionListener(this);
        buy.addActionListener(this);
        quit.addActionListener(this);

        setSize(500,500);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==addMoney)
        {
            money = Double.parseDouble(inputTx.getText());
            if (money == 0.50 || money == 1 || money == 5 || money == 10) {
                machine.balance += money;
                machine.coins.increaseCoinValue(money);
                totalMoneylbl.setText(String.valueOf(machine.balance)+" TL");
                inputTx.setText(null);
            }
            else {
                JOptionPane.showMessageDialog(null, "Lütfen geçerli bir giriş yapın!");
            }
        }
        else if (e.getSource()==buy)
        {
            //check balance and selected item
            if(CheckRequestIsValid()) {
                System.out.println("inside buy button");
                machine.RequestProduct(group.getSelection().getActionCommand(),machine.balance);
                clearScreen();
            }
            else{
                JOptionPane.showMessageDialog(null, "Lütfen geçerli bir giriş yapın!");
            }
        }

        else if (e.getSource()==quit)
        {
            clearScreen();
            machine.setState(new QuitState(machine.balance));
        }
    }
    private boolean CheckRequestIsValid(){

        return group.getSelection() != null && machine.balance > 0;
    }

    public static void main(String[] args){
        new AutomatDemo();
    }

    private void clearScreen(){
        group.clearSelection();
        totalMoneylbl.setText(String.valueOf(machine.balance)+" TL");
    }
}
