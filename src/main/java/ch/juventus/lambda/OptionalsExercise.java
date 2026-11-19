package ch.juventus.lambda;

import java.util.List;
import java.util.Optional;

public class OptionalsExercise {

    static void main() {
        List<String> letters = List.of("a", "b", "c", "d");

        Optional<String> maybeLetterB = letters.stream()
                .filter(letter -> letter.equals("b"))
                .findAny();

        System.out.println(maybeLetterB.orElse("Not found"));

        Optional<String> maybeLetterZ = letters.stream()
                .filter(letter -> letter.equals("z"))
                .findAny();

        System.out.println(maybeLetterZ.orElse("Not found"));
    }

}
