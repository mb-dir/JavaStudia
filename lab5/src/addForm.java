import javax.swing.*;

public class addForm extends JFrame{

    private JPanel panel1;
    private JTextField titleField;
    private JComboBox PriortyBox;
    private JButton addButton;

    public static void main(String[] args) {
        addForm example = new addForm();
        example.setVisible(true);
    }

    public addForm(){
        super("Kox okienko");
        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700,500);
    }
}
