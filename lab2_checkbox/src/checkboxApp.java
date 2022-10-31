import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class checkboxApp extends JFrame {
    private JCheckBox java200złCheckBox;
    private JCheckBox c2137złCheckBox;
    private JCheckBox c0złCheckBox;
    private JCheckBox python111złCheckBox;
    private javax.swing.JPanel JPanel;
    private JButton OKButton;
    ;

    public static void main(String[] args) {
        checkboxApp checkboxAppInstance = new checkboxApp();
        checkboxAppInstance.setVisible(true);
    }

    public checkboxApp(){
        super("Checkbox App");
        this.setContentPane(JPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 300);
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int price = 0;
                String summary = "";
                if(java200złCheckBox.isSelected()){
                    price += 200;
                    summary+="Java\n";
                }
                if(c2137złCheckBox.isSelected()){
                    price += 2137;
                    summary+="C++\n";
                }
                if(c0złCheckBox.isSelected()){
                    price += 0;
                    summary+="C\n";
                }
                if(python111złCheckBox.isSelected()){
                    price += 111;
                    summary+="Python\n";
                }

                JOptionPane.showMessageDialog(null, "Podsumowamie\n" + summary + "-------\n" + "Łączna cena: " + price);

            }
        });
    }
}
