import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class password extends JFrame {
    private JButton OKButton;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private javax.swing.JPanel JPanel;

    String password = "codejava";

    public static void main(String[] args) {
        password passwordInstance = new password();
        passwordInstance.setVisible(true);
    }

    public password(){
        super("Password task");
        this.setContentPane(JPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450, 300);
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstPassword = new String(passwordField1.getPassword());
                String secondPassword = new String(passwordField2.getPassword());

                System.out.println(firstPassword + " " + secondPassword);

                if(!firstPassword.equals(secondPassword)){
                    JOptionPane.showMessageDialog(null, "Passwords are not matched");
                    return;
                }
                if(firstPassword.equals(secondPassword) && !firstPassword.equals(password)){
                    JOptionPane.showMessageDialog(null, "Wrong password!");
                    return;
                }
                if(firstPassword.equals(secondPassword) && firstPassword.equals(password)){
                    JOptionPane.showMessageDialog(null, "OK");
                    return;
                }
            }
        });
    }
}
