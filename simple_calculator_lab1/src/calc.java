import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calc extends JFrame{
    private JLabel labelA;
    private JTextField fieldA;
    private JLabel labelB;
    private JTextField fieldB;
    private JButton add;
    private JButton sub;
    private JLabel resultLabel;
    private javax.swing.JPanel JPanel;

    int a,b,result;

    public static void main(String[] args) {
        calc calculator = new calc();
        calculator.setVisible(true);
    }

    public calc() {
        super("My simple calculator");
        this.setContentPane(JPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700,500);

        sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a = Integer.parseInt(fieldA.getText());
                b = Integer.parseInt(fieldB.getText());

                result = a-b;

                resultLabel.setText("Wynik to: " + result);
            }
        });

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a = Integer.parseInt(fieldA.getText());
                b = Integer.parseInt(fieldB.getText());

                result = a+b;

                resultLabel.setText("Wynik to: " + result);
            }
        });
    }
}
