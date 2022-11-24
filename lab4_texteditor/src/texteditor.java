import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class texteditor extends JFrame{
    private javax.swing.JPanel JPanel;
    private JComboBox comboBox1;
    private JButton bButton;
    private JButton zButton;
    private JButton iButton;
    private JButton pButton;
    private JTextArea textArea1;

    public static void main(String[] args) {
        texteditor Editor = new texteditor();
        Editor.setVisible(true);
    }
    public texteditor(){
        super("texteditor");
        this.setContentPane(JPanel);
        this.setSize(550, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedColor = (String) comboBox1.getItemAt(comboBox1.getSelectedIndex());
                if(selectedColor == "Czarny") textArea1.setForeground(Color.black);
                if(selectedColor == "Czerwony") textArea1.setForeground(Color.red);
                if(selectedColor == "Niebieski") textArea1.setForeground(Color.blue);
                if(selectedColor == "Zielony") textArea1.setForeground(Color.green);
                if(selectedColor == "Fioletowy") textArea1.setForeground(Color.magenta);
                if(selectedColor == "Szary") textArea1.setForeground(Color.gray);
            }
        });
    }
}
