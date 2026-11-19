package ch.juventus.lambda;

import ch.juventus.object.Person;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LambdaExamples2 {

    static void main() {

        List<Person> employees = List.of(
                new Person("Meier", "Michael", 32, Month.JUNE),
                new Person("Muster", "Daniel", 26, Month.DECEMBER),
                new Person("Müller", "Lisa", 43, Month.MAY),
                new Person("Staub", "Martina", 50, Month.MAY),
                new Person("Berger", "Tom", 30, Month.DECEMBER)
        );

        List<String> names = employees.stream()
                .filter(e -> e.getAge() > 30)
                .map(employee -> employee.getFirstName())
                .toList();

        System.out.println("Employees over 30: " + names);


        double totalAge = employees.stream()
                .filter(employee -> employee.getLastName().startsWith("M"))
                .map(employee -> employee.getAge())
                .reduce(0, (a, b) -> a + b);

        System.out.println("Total age of employees starting with M: " + totalAge);


        Map<Month, List<String>> employeesByFavoriteMonth =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                employee -> employee.getFavoriteMonth(),
                                Collectors.mapping(
                                        employee -> employee.getFirstName(),
                                        Collectors.toList()
                                )
                        ));

        System.out.println("Employees by favorite month: " + employeesByFavoriteMonth);

    }
}
