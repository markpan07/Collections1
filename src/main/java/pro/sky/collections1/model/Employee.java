package pro.sky.collections1.model;

import java.util.Objects;

public class Employee {
    final private String firstName;
    final private String lastName;



    public Employee(String lastName, String firstName) {
        this.firstName = firstName;
        this.lastName = lastName;


    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }


    @Override
    public String toString() {
        return "---" + "\n" +
                "Last Name : " + this.lastName + " \n" +
                "Name : " + this.firstName + " \n" +

                "---";

    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Employee e = (Employee) o;
        return this.firstName.equals(e.getFirstName()) && this.lastName.equals(e.getLastName());

    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
