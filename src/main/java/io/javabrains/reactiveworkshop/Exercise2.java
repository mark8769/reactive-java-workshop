package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise2 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Print all numbers in the ReactiveSources.intNumbersFlux stream
        // TODO: Write code here

        // Subscribe is the equivalent of ForEach
        // Whenever this stream emits something(value)
        // Use this callback method (method reference/lambda)

        ReactiveSources.intNumbersFlux().subscribe(num -> System.out.println(num));

        // Print all users in the ReactiveSources.userFlux stream
        // TODO: Write code here
        ReactiveSources.userFlux().subscribe(user -> System.out.println(user));


        // The purpose of this...?
        // The program ends right away if this is commented out....

        // Explanation:
        // You told stream to do something when event gets emitted/triggered, e.g. call callback function.
        // When commenting this out, you are not waiting for the stream to emit a value/fire event
        // Java gets to end of method and ends process before stream can emit anything ...
        // E.g. Might also help looking at the ReactiveSources implementation ... (creating one element every second)
        // Java will run program in less than 1 second...

        System.out.println("Press a key to end");
        // This is a blocking operation...
        System.in.read();
    }

}
