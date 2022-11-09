import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lab3 extends JFrame {
    private JComboBox comboBox1;
    private JPanel JPanel;
    private JLabel label;
    private JList list1;
    private JTable table1;


    public static void main(String[] args) {
        lab3 example = new lab3();
        example.setVisible(true);
    }

    public lab3() {
        super("Kox okienko");
        this.setContentPane(this.JPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);

        //mozna ręcznie
        createItems();
        createTable();
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data = "wybrano: " + comboBox1.getItemAt(comboBox1.getSelectedIndex());

                label.setText(data);
            }
        });
    }

    private void createItems(){
        comboBox1.setModel(new DefaultComboBoxModel(new String[]{"", "Jan", "ruter", "Trzeci", "łączy", "małe", "sieci"}));
    }

    private void createTable(){
        Object[][] data = {
                {"film 2", 2022, 2137, 987},
                {"film 1", 2022, 2137, 987},
                {"film 3", 2137, 2137, 987},
                {"film 7", 2022, 2137, 987}
        };
        table1.setModel(new DefaultTableModel(data, new String[]{"Nazwa", "Rok", "Ocena", "Ilość komentujących"}));
    }
}