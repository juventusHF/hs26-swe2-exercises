package ch.juventus.object;

import java.io.Serializable;
import java.time.Month;
import java.util.Objects;

public class Person implements Serializable, Comparable<Person> {

    private final String firstName;
    private final String lastName;
    private final Address address;
    private final int age;
    private final boolean hasPet;
    private final Month favoriteMonth;

    public Person(String firstName, String lastName, Address address, int age, boolean hasPet) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.age = age;
        this.hasPet = hasPet;
        this.favoriteMonth = Month.APRIL;
    }

    public Person(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = null;
        this.age = 0;
        this.hasPet = false;
        this.favoriteMonth = Month.JULY;
    }

    public Person(String lastName, String firstName, int age, Month favoriteMonth) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = null;
        this.age = age;
        this.hasPet = false;
        this.favoriteMonth = favoriteMonth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public boolean isHasPet() {
        return hasPet;
    }

    public Month getFavoriteMonth() {
        return favoriteMonth;
    }

    @Override
    public int compareTo(Person o) {
        int firstNameCompare = firstName.compareTo(o.firstName);
        if(firstNameCompare == 0) {
            return lastName.compareTo(o.lastName);
        }
        return firstNameCompare;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", age=" + age +
                ", hasPet=" + hasPet +
                ", favoriteMonth=" + favoriteMonth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && hasPet == person.hasPet && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(address, person.address) && favoriteMonth == person.favoriteMonth;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, address, age, hasPet, favoriteMonth);
    }
}
