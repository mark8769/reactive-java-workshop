package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise8 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()

        // Print values from intNumbersFluxWithException and print a message when error happens
        // TODO: Write code here
//        ReactiveSources
//                .intNumbersFluxWithException()
//                .subscribe(
//                        // Handle item event
//                        num -> System.out.println(num),
//                        // Handler error event
//                        err -> System.out.println("Error happened: " + err)
//                );

        // Print values from intNumbersFluxWithException and continue on errors
        // TODO: Write code here

        // DoOnError bubbles up error
        // When passing in subscribe we are handling the error
//        ReactiveSources
//                .intNumbersFluxWithException()
//                .doOnError(err -> System.out.println(err.getMessage()))
//                .subscribe(num -> System.out.println(num));


//        ReactiveSources
//                .intNumbersFluxWithException()
//                .onErrorContinue((e, item) -> System.out.println("Error!!! " + e.getMessage()))
//                .subscribe(num -> System.out.println(num));

        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
        // TODO: Write code here

        ReactiveSources
                .intNumbersFluxWithException()
                // Just creates a new flux, when error happens, return new flux with -1 & -2, subscribe will print out.
                // Return type is Flux<T>
                .onErrorResume(err -> Flux.just(-1, -2))
                .subscribe(num -> System.out.println(num));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
