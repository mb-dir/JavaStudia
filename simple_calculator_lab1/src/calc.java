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
    private JButton multiplyButton;
    private JButton divButton;

    double a,b,result;

    public static void main(String[] args) {
        calc calculator = new calc();
        calculator.setVisible(true);
    }

    public calc() {
        super("My simple calculator");
        this.setContentPane(JPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450,300);

        sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    a = Double.parseDouble(fieldA.getText());
                    b = Double.parseDouble(fieldB.getText());

                    result = a-b;

                    resultLabel.setText("Wynik to: " + result);
                }catch (NumberFormatException ev){
                    JOptionPane.showMessageDialog(null, "Pole nie może być puste");
                }
            }
        });

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    a = Double.parseDouble(fieldA.getText());
                    b = Double.parseDouble(fieldB.getText());

                    result = a+b;

                    resultLabel.setText("Wynik to: " + result);
                }catch (NumberFormatException ev){
                    JOptionPane.showMessageDialog(null, "Pole nie może być puste");
                }
            }
        });

        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    a = Double.parseDouble(fieldA.getText());
                    b = Double.parseDouble(fieldB.getText());

                    result = a*b;

                    resultLabel.setText("Wynik to: " + result);
                }catch (NumberFormatException ev){
                    JOptionPane.showMessageDialog(null, "Pole nie może być puste");
                }
            }
        });

        divButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    a = Double.parseDouble(fieldA.getText());
                    b = Double.parseDouble(fieldB.getText());

                    if(b!=0) {
                        result = a/b;
                        resultLabel.setText("Wynik to: " + result);
                    }else{
                        JOptionPane.showMessageDialog(null, "Nie można dzielić przez 0");
                    }

                }catch (NumberFormatException ev){
                    JOptionPane.showMessageDialog(null, "Pole nie może być puste");
                }
            }
        });
    }
}
