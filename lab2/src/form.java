import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class form extends JFrame {
    private javax.swing.JPanel JPanel;
    private JTextField usernameInput;
    private JPasswordField passwordInput;
    private JLabel passwordLabel;
    private JLabel usernameLabel;
    private JButton loginButton;
    private JLabel resultLabel;
    private JRadioButton linuxRadioButton;
    private JRadioButton macRadioButton;
    private JRadioButton windowsRadioButton;
    private JButton okButton;
    private JLabel imgLabel;

    //wczytywanie plików
    private ImageIcon iconLinux = new ImageIcon(getClass().getResource("linux.png"));
    private ImageIcon iconWin = new ImageIcon(getClass().getResource("windows.png"));
    private ImageIcon iconMac = new ImageIcon(getClass().getResource("mac.png"));

    public static ImageIcon resize(ImageIcon src, int width, int height){
        return new ImageIcon(src.getImage().getScaledInstance(width,height, Image.SCALE_SMOOTH));
    }

    public static void main(String[] args) {
        form testForm = new form();
        testForm.setVisible(true);
    }

    public form(){
        super("testForm");
        this.setContentPane(JPanel);
        this.setSize(550, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameInput.getText();
                String password = new String(passwordInput.getPassword());

                resultLabel.setText("username: " + username + " " + "password: " + password);
            }
        });
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectOption="Windows";

                if(linuxRadioButton.isSelected()){
                    selectOption="Linux";
                }else if(macRadioButton.isSelected()){
                    selectOption="Mac";
                }

                JOptionPane.showMessageDialog(null, selectOption);
            }
        });
        linuxRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(linuxRadioButton.isSelected()){
                    imgLabel.setIcon(resize(iconLinux, 120, 120));
                }
            }
        });
        macRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(macRadioButton.isSelected()){
                    imgLabel.setIcon(resize(iconMac, 120, 120));
                }
            }
        });
        windowsRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(windowsRadioButton.isSelected()){
                    imgLabel.setIcon(resize(iconWin, 120, 120));
                }
            }
        });
    }
}
