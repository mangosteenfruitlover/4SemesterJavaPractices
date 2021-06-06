package main;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
    @JsonProperty("firstName")
    public String firstName;

    @JsonProperty("middleName")
    public String middleName;

    @JsonProperty("lastName")
    public String lastName;

    public Student() {}

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Student(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", middleName=" + middleName +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
