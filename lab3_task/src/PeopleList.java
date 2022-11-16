import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;

public class PeopleList extends JFrame {
    private javax.swing.JPanel JPanel;
    private JTextField nameInput;
    private JTextField surnameInput;
    private JTextField phoneInput;
    private JTextField addressInput;
    private JTextField DoBInput;
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

        //Create ArrayList of sample people and push it to combobox
        ArrayList<Person> listOfPeople = new ArrayList<Person>();
        for(int i = 0; i <= 5; i++){
            Person p = new Person("John" + i, "Paoulo" + i,"20103070", "Papieska/Aleja "+i, LocalDate.of(2010+i, Month.FEBRUARY, 10+i));
            listOfPeople.add(p);
        }

        String peopleData[] = new String[listOfPeople.size()];
        peopleData[0]="";

        for(int i = 1; i < listOfPeople.size(); i++){
            String personData = listOfPeople.get(i).name + " " + listOfPeople.get(i).surname;
            peopleData[i] = personData;
        }
        comboBox1.setModel(new DefaultComboBoxModel(peopleData));

        //Handle clicking on combobox - show info about person in inputs
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data = ""+comboBox1.getItemAt(comboBox1.getSelectedIndex());
                //Treat name as id to find suitable object(person) in array list
                String name = data.split(" ")[0];

                Person selectedPerson = null;

                for(Person p : listOfPeople) {
                    if (p.name.equals(name)) {
                        selectedPerson = p;
                    }
                }

                if(selectedPerson != null){
                    //enable saveExistingButton - user can edit selected person
                    saveExistingButton.setEnabled(true);

                    nameInput.setText(selectedPerson.name);
                    surnameInput.setText(selectedPerson.surname);
                    phoneInput.setText(selectedPerson.phoneNumber);
                    addressInput.setText(selectedPerson.address);
                    DoBInput.setText(selectedPerson.dateOfBirth.toString());

                    //calculate the age
                    LocalDate DoB = LocalDate.parse(selectedPerson.dateOfBirth.toString());
                    LocalDate curDate = LocalDate.now();
                    if (DoB != null){
                        ageLabel.setText("Age: " + Period.between(DoB, curDate).getYears() + " years");
                    }
                }else{
                    saveExistingButton.setEnabled(false);
                    nameInput.setText("");
                    surnameInput.setText("");
                    phoneInput.setText("");
                    addressInput.setText("");
                    DoBInput.setText("");
                    ageLabel.setText("Age: 0 years");
                }
            }
        });

        //Handling adding new person - create new Person based on data form inputs, add it to array list and rerender combobox
        saveNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Person p = new Person(nameInput.getText(), surnameInput.getText(), phoneInput.getText(), addressInput.getText(), LocalDate.parse(DoBInput.getText()));
                listOfPeople.add(p);
                String peopleData[] = new String[listOfPeople.size()];
                peopleData[0]="";

                for(int i = 1; i < listOfPeople.size(); i++){
                    String personData = listOfPeople.get(i).name + " " + listOfPeople.get(i).surname;
                    peopleData[i] = personData;
                }

                comboBox1.setModel(new DefaultComboBoxModel(peopleData));

                //reset inputs values after adding new person
                nameInput.setText("");
                surnameInput.setText("");
                phoneInput.setText("");
                addressInput.setText("");
                DoBInput.setText("");
                ageLabel.setText("Age: 0 years");
                saveExistingButton.setEnabled(false);
            }
        });

        //Edit existing person
        saveExistingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Person p = new Person(nameInput.getText(), surnameInput.getText(), phoneInput.getText(), addressInput.getText(), LocalDate.parse(DoBInput.getText()));
                listOfPeople.set(comboBox1.getSelectedIndex(), p);

                String peopleData[] = new String[listOfPeople.size()];
                peopleData[0]="";

                for(int i = 1; i < listOfPeople.size(); i++){
                    String personData = listOfPeople.get(i).name + " " + listOfPeople.get(i).surname;
                    peopleData[i] = personData;
                }

                comboBox1.setModel(new DefaultComboBoxModel(peopleData));

                //reset inputs values after editing
                nameInput.setText("");
                surnameInput.setText("");
                phoneInput.setText("");
                addressInput.setText("");
                DoBInput.setText("");
                ageLabel.setText("Age: 0 years");

                saveExistingButton.setEnabled(false);
            }
        });
    }
}
