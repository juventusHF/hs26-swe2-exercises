package ch.juventus.object;

public class Application {

    public static void main(String[] args) {

        Person linda = new Person(
                "linda",
                "krueger",
                new Address("zuercherstrasse", 42, 8903, "birmensdorf"),
                34,
                false
        );
        System.out.println(linda);

        Person lindaCopy = new Person(
                "linda",
                "krueger",
                new Address("zuercherstrasse", 42, 8903, "birmensdorf"),
                34,
                false
        );
        System.out.println(lindaCopy);

        System.out.println(linda.equals(lindaCopy));
    }

}
