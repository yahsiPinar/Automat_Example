import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutomatDemo extends JFrame implements ActionListener {

    TextField inputTx;
    JLabel title, input, total, totallbl;
    JRadioButton coke, fanta, soda;
    JButton addMoney, buy, quit, exit;
    public AutomatDemo(){

        title = new JLabel("Hoşgeldiniz! Sadece 0.50 Krş, 1 TL, 5 TL, 10 TL girişi yapınız!");
        title.setBounds(50,50,500,20);
        input = new JLabel("Para Girişi: ");
        input.setBounds(50,100,70,20);
        inputTx = new TextField();
        inputTx.setBounds(120,100,50,20);
        addMoney = new JButton("Ekle");
        addMoney.setBounds(200,100,70,20);
        addMoney.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        total = new JLabel("Bakiye: ");
        total.setBounds(50,150,50,20);
        // TODO: get total money and print

        totallbl = new JLabel("xxxx");
        totallbl.setBounds(120,150,50,20);

        coke = new JRadioButton("Kola 15.00 tl");
        fanta = new JRadioButton("Fanta 20.00 tl");
        soda = new JRadioButton("Gazoz 30.00 tl");

        coke.setBounds(50,200,100,20);
        fanta.setBounds(150,200,100,20);
        soda.setBounds(250,200,110,20);

        buy = new JButton("Satın Al");
        quit = new JButton("İptal Et");
        exit = new JButton("Tamamla");

        buy.setBounds(50,300,100,20);
        quit.setBounds(200,300,100,20);
        exit.setBounds(350,300,100,20);

        add(inputTx);
        add(totallbl);
        add(title);
        add(input);
        add(total);
        add(coke);
        add(fanta);
        add(soda);
        add(addMoney);
        add(buy);
        add(quit);
        add(exit);
        setSize(500,500);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==exit)
        {
            //do something
        }
        else if (e.getSource()==addMoney)
        {
            //do something
        }
        else if (e.getSource()==buy)
        {
            //do something
        }
        else if (e.getSource()==quit)
        {
            //do something
        }
    }
    public static void main(String[] args){
        new AutomatDemo();
    }
}
