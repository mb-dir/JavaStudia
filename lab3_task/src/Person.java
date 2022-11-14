import java.util.Date;

public class Person {
    String name;
    String surname;
    String phoneNumber;
    String address;
    Date dateOfBirth;

    public Person(String name, String surname, String phoneNumber, String address, Date dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }
}
