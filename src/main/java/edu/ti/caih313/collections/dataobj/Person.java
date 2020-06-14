package edu.ti.caih313.collections.dataobj;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Person {
    private Name name;
    private Gender gender;
    private double age;
    private EmailAddress emailAddress;
    private LocalDate birthDate;
    public enum Gender {MALE, FEMALE}

    public Person(Name name, Gender gender, LocalDate birthDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
    }
    public Person(Name name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public double getAge() {
        Period ageNow = Period.between(birthDate, LocalDate.now());
        return ageNow.getYears();
    }

    public HashMap<EmailAddress.EmailType, String> getEmailMap() { return emailAddress.emailAddressHashMap; }

    public void setAge(double age) {
        this.age = age;
    }

    public EmailAddress getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(EmailAddress.EmailType emailType, String setEmailAddress) {

        if(emailAddress == null){
            emailAddress = new EmailAddress(setEmailAddress, emailType);
        }
        this.emailAddress.emailMap.put(emailType, setEmailAddress);
    }

    @Override
    public String toString() {
        String emailAddressString;
        if(emailAddress == null) {
            emailAddressString = "no email address available";
        }
        else {
            emailAddressString = emailAddress.getEmailAddress();
        }
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d, yyyy 'C.E.'");
        String birthDateString = birthDate.format(format);
        return "Person{" +
                "name=" + name +
                ", gender=" + gender +
                ", age=" + age +
                ", emailAddress='" + emailAddressString + '\'' +
                ", birth date='" + birthDateString + '\'' +
                '}';
    }
}
