package ch.juventus.sorting;

import ch.juventus.object.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingExercise {

    static void main() {
        List<Person> people = new ArrayList<>(List.of(
                new Person("Muster", "Hans"),
                new Person("Keller", "Peter"),
                new Person("Kuster", "Peter"),
                new Person("Muster", "Lisa")
        ));

        Collections.sort(people);

        people.forEach(System.out::println);
    }

}
