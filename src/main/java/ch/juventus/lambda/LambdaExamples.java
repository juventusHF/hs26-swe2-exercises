package ch.juventus.lambda;

import ch.juventus.object.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class LambdaExamples {

    static void main() {

        Function<LocalDate, String> datePrinter = date -> "Jetzt ist " + date;
        String text = datePrinter.apply(LocalDate.now());
        System.out.println(text);

        //---------------------------------------------------------------

        MathOperation addition = (a, b) -> a + b;
        MathOperation subtraction = (a, b) -> a - b;
        MathOperation multiplication = (a, b) -> a * b;
        MathOperation division = (a, b) -> a / b;

        int result1 = operate(5, 10, addition);
        int result2 = operate(20, 2, subtraction);
        int result3 = operate(12, 5, multiplication);
        int result4 = operate(12, 3, division);

        System.out.println("Result 1: " + result1);
        System.out.println("Result 2: " + result2);
        System.out.println("Result 3: " + result3);
        System.out.println("Result 4: " + result4);

        //---------------------------------------------------------------

        List<List<Integer>> numberList = new ArrayList<>();
        numberList.add(List.of(1, 2, 3));
        numberList.add(List.of(4, 5, 6));
        numberList.add(List.of(7, 8, 9));

        List<Integer> numbersOutput = numberList.stream()
                .flatMap(List::stream)
                .map(n -> n * 2)
                .distinct()
                .sorted()
                .toList();

        System.out.println(numbersOutput);

        //---------------------------------------------------------------

        List<Person> personList = List.of(
                new Person("Anna", "Muster", null, 50, false),
                new Person("Bob", "Meier", null, 25, false),
                new Person("Carla", "Maler", null, 18, true),
                new Person("Daniel", "Müller", null, 16, true)
        );

        boolean result = personList.stream()
                .filter(person -> !person.getFirstName().startsWith("A"))
                .map(person -> person.getAge())
                .allMatch(age -> age >= 18);

        System.out.println(result);

    }

    private static int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operate(a, b);
    }

}
