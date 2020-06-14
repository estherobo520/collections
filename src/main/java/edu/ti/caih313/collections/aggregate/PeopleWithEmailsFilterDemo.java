package edu.ti.caih313.collections.aggregate;

import edu.ti.caih313.collections.dataobj.EmailAddress;
import edu.ti.caih313.collections.dataobj.Name;
import edu.ti.caih313.collections.dataobj.Person;
import edu.ti.caih313.collections.dataobj.PersonSortable;

import java.util.Arrays;

public class PeopleWithEmailsFilterDemo {

    public static void main(String... args) {
        PersonSortable joeDoe = new PersonSortable(new Name("Joe", "Doe"), Person.Gender.MALE, 20);
        joeDoe.setEmailAddress(EmailAddress.EmailType.SCHOOL, "joedoe@ti.htc.edu");
        joeDoe.setEmailAddress(EmailAddress.EmailType.HOME, "joedoe@gmail.com");
        joeDoe.setEmailAddress(EmailAddress.EmailType.WORK, "joedoe@work.com");

        PersonSortable joeDoe2 = new PersonSortable(new Name("Joe2", "Doe2"), Person.Gender.MALE, 40);
        joeDoe2.setEmailAddress(EmailAddress.EmailType.SCHOOL, "joedoe2@ti.htc.edu");
        joeDoe2.setEmailAddress(EmailAddress.EmailType.HOME, "joedoe2@gmail.com");
        joeDoe2.setEmailAddress(EmailAddress.EmailType.WORK, "joedoe2@work.com");

        PersonSortable joeDoe3 = new PersonSortable(new Name("Joe3", "Doe3"), Person.Gender.MALE, 60);
        joeDoe3.setEmailAddress(EmailAddress.EmailType.SCHOOL, "joedoe3@ti.htc.edu");
        joeDoe3.setEmailAddress(EmailAddress.EmailType.HOME, "joedoe3@gmail.com");
        joeDoe3.setEmailAddress(EmailAddress.EmailType.WORK, "joedoe3@work.com");

        PersonSortable personArray[] = {joeDoe, joeDoe2, joeDoe3};

        PeopleWithEmailsFilterDemo.printAllSchoolEmails(personArray);
        PeopleWithEmailsFilterDemo.printAllEmailsOverAgeX(personArray, 20);
    }

        public static void printAllSchoolEmails(Person [] personArray)
    {
        System.out.println("All school email address:");
        Arrays.stream(personArray)
                .forEach(e -> System.out.println(e.getEmailMap().get(EmailAddress.EmailType.SCHOOL)));
    }


    public static void printAllEmailsOverAgeX(Person [] personArray, int age)
    {
        System.out.println("All emails over " + age + " years old.");
        Arrays.stream(personArray)
                .filter(p -> p.getAge() > age)
                .forEach(e -> System.out.println(e.getName().getFirstName() + e.getName().getLastName() +
                        "'s email addresses are: " + e.getEmailMap().values()));
   }
}
