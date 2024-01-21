package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise9 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Print size of intNumbersFlux after the last item returns
        // TODO: Write code here
        // Returns when terminal event happens (completion/error)
//        ReactiveSources
//                .intNumbersFlux()
//                // Non-blocking in comparison to converting to stream -> Then to list -> Getting count
//                // NOTE: If something returns MONO/FLUX = non-blocking OTHERWISE = blocking
//                .count()
//                .subscribe(System.out::println);

        // Collect all items of intNumbersFlux into a single list and print it
        // TODO: Write code here

//        ReactiveSources
//                .intNumbersFlux()
//                // Collect all elements emitted by this Flux into a List that is
//                // emitted by the resulting Mono when this sequence completes,
//                // emitting the empty List if the sequence was empty.
//                .collectList()
//                // Subscribe to MONO emit event
//                .subscribe(System.out::println);

        // Transform to a sequence of sums of adjacent two numbers
        // TODO: Write code here

        // Every 2 events in this flux -> Is equal to 1 element in new flux.
        // Returns Flux< List<T> > of size 2
        ReactiveSources
                .intNumbersFlux()
                .buffer(2)
                // Maps buffered flux to one element in a new flux
                .map(list -> list.get(0) + list.get(1))
                .subscribe(System.out::println);
    }

}
