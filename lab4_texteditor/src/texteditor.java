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
    boolean isBold = false;
    boolean isItalic = false;

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
        bButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isBold =!isBold;
                if(isBold){
                    Font font = new Font("Arial", Font.BOLD, 12);
                    textArea1.setFont(font);
                    bButton.setBackground(Color.cyan);
                }else{
                    Font font = new Font("Arial", Font.PLAIN, 12);
                    textArea1.setFont(font);
                    bButton.setBackground(new Color(60,63,65));
                }
            }
        });
        iButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isItalic =!isItalic;
                if(isItalic){
                    Font font = new Font("Arial", Font.ITALIC, 12);
                    textArea1.setFont(font);
                    iButton.setBackground(Color.cyan);
                }else{
                    Font font = new Font("Arial", Font.PLAIN, 12);
                    textArea1.setFont(font);
                }
            }
        });
    }
}
