import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class lab1 extends JFrame {
    //drugi sposób wyświetlania - wyrzucamy dziedziczenie -> tworzymy obiekt klasy Frame(przekazujemy do konstruktoea title i co tam trzeba) -> nie odwołujemy się przez this. tylko przez obiekt
    private JPanel JPanel1;
    private JTextField textField1;
    private JLabel labelA;
    private JTextField textField2;
    private JLabel labelB;
    private JButton sumaButton;
    private JButton różnicaButton;
    private JButton OKButton;
    private JButton closeButton;
    private JLabel labelWynik;
    private JLabel labelData;

    double a,b,wynik;

    public static void main(String[] args) {
        lab1 example = new lab1();
        example.setVisible(true);
    }

    public lab1(){
        super("Kox okienko");
        this.setContentPane(this.JPanel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,300);
//        OKButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                JOptionPane.showMessageDialog(null, new Date());
//                labelData.setText(new Date().toString());
//            }
//        });
//        closeButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                dispose();
//            }
//        });
        sumaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                a=Double.parseDouble(textField1.getText());
                b=Double.parseDouble(textField2.getText());

                wynik = a+b;

                labelWynik.setText("Suma: " + wynik);
            }
        });

        różnicaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a=Double.parseDouble(textField1.getText());
                b=Double.parseDouble(textField2.getText());

                wynik = a-b;

                labelWynik.setText("Rożnica: " + wynik);
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

}
