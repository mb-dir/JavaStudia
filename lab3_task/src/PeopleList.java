import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;

public class PeopleList extends JFrame {
    private javax.swing.JPanel JPanel;
    private JList list1;
    private JTextField nameInput;
    private JTextField surnameInput;
    private JTextField phoneInput;
    private JTextField addressInput;
    private JTextField DoFInput;
    private JLabel ageLabel;
    private JButton saveNewButton;
    private JButton saveExistingButton;
    private JComboBox comboBox1;

    public static void main(String[] args) {
        PeopleList list = new PeopleList();
        list.setVisible(true);
    }

    public PeopleList() {
        super("People list");
        this.setContentPane(JPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 400);

        ArrayList<Person> listOfPeople = new ArrayList<Person>();

        for(int i = 0; i < 5; i++){
            Person p = new Person("jan", "paweł","2137", "watykan", new Date("February 09, 2004"));
            listOfPeople.add(p);
        }

        String peopleData[] = new String[5];

        for(int i = 0; i < 5; i++){
            String personData = listOfPeople.get(i).name + " " + listOfPeople.get(i).surname + (i+1);
            peopleData[i] = personData;
        }
        list1.setModel(new DefaultComboBoxModel(peopleData));

    }
}
