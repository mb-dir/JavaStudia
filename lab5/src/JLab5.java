import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JLab5 extends JFrame{
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JPanel filePanel;
    private JPanel aboutPanel;
    private JList list1;
    private JList list2;
    private JList list3;
    private JButton ADDNEWTASKButton;
    private JTextField textField1;
    private JButton BACKButton;
    private JButton CLOSEButton;

    public static void main(String[] args) {
        JLab5 example = new JLab5();
        example.setVisible(true);
    }

    public JLab5(){
        super("Kox okienko");
        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700,500);
        ADDNEWTASKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                addForm t = new addForm();
                t.setVisible(true);
            }
        });
    }
}
