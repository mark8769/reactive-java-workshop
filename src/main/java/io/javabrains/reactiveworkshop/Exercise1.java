package io.javabrains.reactiveworkshop;

import java.util.Optional;

// Setting MVN path for Macbooks
// https://ankitmaheshwariin.medium.com/set-maven-path-in-mac-os-3e85634821d6
// Check shell being used...
// "ps"
// For some reason "mvn clean install" not working in IntelliJ terminal, but works in Mac Terminal
// Both using bash... (path issue?)
public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()
        // Getting warning that I am instantiating a UTILITY class...
        // E.g. Class declared as final, and only having static methods
        // StreamSources s = new StreamSources();

        // Print all numbers in the intNumbersStream stream
        // TODO: Write code here
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Print all the numbers in the intNumberStream stream");
        // Can either pass a reference of the method
        // E.g. Blindly pass value in stream to first argument in method...
        // https://stackoverflow.com/questions/31020269/what-is-the-use-of-system-outprintln-in-java-8
        StreamSources.intNumbersStream().forEach(System.out::println);
        // Or can pass a Lambda
        StreamSources.intNumbersStream().forEach(x -> System.out.println(x));
        System.out.println("---------------------------------------------------------------------");

        // Print numbers from intNumbersStream that are less than 5
        // TODO: Write code here
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Print numbers from intNumbersStream that are less than 5.");
        StreamSources.intNumbersStream()
                .filter(x -> x < 5)
                .forEach(x -> System.out.println(x));

        System.out.println("---------------------------------------------------------------------");

        // Print the second and third numbers in intNumbersStream that's greater than 5
        // TODO: Write code here
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Print the second and third numbers in intNumbersStream that's greater than 5.");

        StreamSources.intNumbersStream()
                .filter(x -> x > 5)
                .limit(3)
                .skip(1)
                .forEach(System.out::println);
        System.out.println("---------------------------------------------------------------------");

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        // TODO: Write code here
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Print the first number in intNumbersStream that's greater than 5.");

        Optional<Integer> a = StreamSources.intNumbersStream()
                .filter(x -> x > 5)
                .findFirst();

        if (a.isPresent()) {
            System.out.println(a.get());
        } else {
            System.out.println(-1);
        }

        System.out.println("---------------------------------------------------------------------");

        // Video Solution
        Integer num = StreamSources.intNumbersStream()
                .filter(x -> x > 5)
                .findFirst()
                .orElse(-1); // Default to -1 if nothing present

        System.out.println(num);

        System.out.println("---------------------------------------------------------------------");

        // Print first names of all users in userStream
        // TODO: Write code here
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Print first names of all users in usersStream.");

        StreamSources.userStream()
                .forEach(user -> System.out.println(user.getFirstName()));

        System.out.println("---------------------------------------------------------------------");
        // Video Solution
        StreamSources.userStream()
                // Replaces every user instance in Stream with user.firstName
                .map(user -> user.getFirstName())
                .forEach(firstName -> System.out.println(firstName));

        System.out.println("---------------------------------------------------------------------");

        // Print first names in userStream for users that have IDs from number stream
        // TODO: Write code here

        System.out.println("---------------------------------------------------------------------");
        System.out.println("Print first names in userStream for users that have IDs from number stream");

        StreamSources.intNumbersStream()
                // PROBLEM: This returns another stream, we want first names...
                // .map(id -> StreamSources.userStream().filter(user -> user.getId() == id))
                // SOLUTION:
                // Flatmap = Maps onto a stream, but then flattens it out.
                // E.g. Instead of mapping one stream FOR EACH id, we are getting the result from each stream.
                // Note: If right hand side of map is an actual value -> Use Map, ELSE use FlatMap to flatten stream to value.
                .flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id))
                .map(user -> user.getFirstName())
                .forEach(firstName -> System.out.println(firstName));

        System.out.println("---------------------------------------------------------------------");

        // Another more straightforward solution

        StreamSources.userStream()
                .filter(
                        user -> StreamSources.intNumbersStream().anyMatch(i -> i == user.getId())
                )
                .forEach(user -> System.out.println(user.getFirstName()));

        System.out.println("---------------------------------------------------------------------");


    }

}
