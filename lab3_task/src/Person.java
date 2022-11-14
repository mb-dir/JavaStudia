import java.time.LocalDate;
import java.time.LocalDateTime;

public class Person {
    String name;
    String surname;
    String phoneNumber;
    String address;
    LocalDate dateOfBirth;

    public Person(String name, String surname, String phoneNumber, String address, LocalDate dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }
}
