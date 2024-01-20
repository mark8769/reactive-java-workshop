package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.Optional;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        // TODO: Write code here
        ReactiveSources.intNumbersFlux().subscribe(num -> System.out.println(num));

        // Get the value from the Mono into an integer variable
        // TODO: Write code here

        // This is a blocking operation since num has to be populated/allocated
        // first before being able to do anything with the variable.
        Integer num = ReactiveSources.intNumberMono().block();

        // Avoid blocking because goes against REACTIVE programming...
        Optional<Integer> number = ReactiveSources.intNumberMono().blockOptional();

        if (number.isPresent()) {
            System.out.println("Number is present: " + number.get());
        } else {
            System.out.println("Number is not present.");
        }

        System.out.println("Press a key to end");
        System.in.read();
    }

}
