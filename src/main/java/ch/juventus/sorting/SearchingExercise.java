package ch.juventus.sorting;

import ch.juventus.object.Person;

import java.util.HashMap;
import java.util.Map;

public class SearchingExercise {

    static void main() {
        Map<Person, String> phonebook = new HashMap<>();
        phonebook.put(new Person("Muster", "Hans"), "0791234567");
        phonebook.put(new Person("Keller", "Peter"), "0782345678");
        phonebook.put(new Person("Kuster", "Peter"), "0793456789");
        phonebook.put(new Person("Muster", "Lisa"), "0764567891");

        Person p1 = findByPhoneNumber(phonebook, "0782345678");
        Person p2 = findByPhoneNumber(phonebook, "0000000000");

        System.out.println(p1);
        System.out.println(p2);
    }

    private static Person findByPhoneNumber(Map<Person, String> phonebook, String phoneNumber) {
        for (Map.Entry<Person, String> entry : phonebook.entrySet()) {
            if(entry.getValue().equals(phoneNumber)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
