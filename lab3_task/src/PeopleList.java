import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
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

        for(int i = 0; i <= 5; i++){
            Person p = new Person("jan" + i, "paweł" + i,"2137", "watykan", new Date("February 09, 2004"));
            listOfPeople.add(p);
        }

        String peopleData[] = new String[6];
        peopleData[0]="";

        for(int i = 1; i <= 5; i++){
            String personData = listOfPeople.get(i).name + " " + listOfPeople.get(i).surname;
            peopleData[i] = personData;
        }

        comboBox1.setModel(new DefaultComboBoxModel(peopleData));


        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data = ""+comboBox1.getItemAt(comboBox1.getSelectedIndex());
                String name = data.split(" ")[0];

                Person selectedPerson = null;

                for(Person p : listOfPeople) {
                    if (p.name.equals(name)) {
                        selectedPerson = p;
                    }
                }

                if(selectedPerson != null){
                    nameInput.setText(selectedPerson.name);
                    surnameInput.setText(selectedPerson.surname);
                    phoneInput.setText(selectedPerson.phoneNumber);
                    addressInput.setText(selectedPerson.address);
                    DoFInput.setText(selectedPerson.dateOfBirth.toString());
                }else{
                    nameInput.setText("");
                    surnameInput.setText("");
                    phoneInput.setText("");
                    addressInput.setText("");
                    DoFInput.setText("");
                }
            }
        });

    }
}
