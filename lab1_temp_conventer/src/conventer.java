import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class conventer extends JFrame {
    private JLabel celLabel;
    private JTextField celInput;
    private JButton convertBtn;
    private javax.swing.JPanel JPanel;

    double cel, result;

    public static void main(String[] args) {
        conventer conv = new conventer();
        conv.setVisible(true);
    }

    public conventer(){
        super("Conventer");
        this.setContentPane(JPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(350,200);
        convertBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    cel = Double.parseDouble(celInput.getText());
                    double far = ((cel*9)/5) + 32;
                    JOptionPane.showMessageDialog(null, "Temperatura w farenhaitach to: " + far);
                }catch(NumberFormatException ev){
                    JOptionPane.showMessageDialog(null, "Podaj temperature");
                }
            }
        });
    }
}
