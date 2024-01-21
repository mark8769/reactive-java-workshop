package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.List;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        // TODO: Write code here

        // FLUX is a series of items over time (asynchronous)
        // STREAM is a series of items all available at once (synchronous)

        // This line will take 10 seconds, since FLUX is emitting one element every second.
        // Blocking operation ... (making the list) -> Have to wait for list to be allocated...
        // E.g. program will stop here before continuing
        List<Integer> nums = ReactiveSources
                .intNumbersFlux()
                .log()
                .toStream()
                .toList();

        // These next lines won't execute until nums is allocated... (10 seconds)
        System.out.println("Size: " + nums.size());
        System.out.println("List is " + nums);


        // This is no longer needed, since we have a blocking operation before this.
        System.out.println("Press a key to end");
        System.in.read();
    }

}
