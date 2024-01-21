package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise7 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Print all values from intNumbersFlux that's greater than 5
        // TODO: Write code here
        ReactiveSources.intNumbersFlux()
                .filter(x -> x > 5)
                .subscribe(x -> System.out.println(x));

        // Print 10 multiplied by each value from intNumbersFlux that's greater than 5
        // TODO: Write code here
        ReactiveSources.intNumbersFlux()
                .filter(x -> x > 5)
                .subscribe(x -> System.out.println(x * 10));

        ReactiveSources.intNumbersFlux()
                .filter(x -> x > 5)
                // Returns new flux with new mapped values.
                .map(e -> e * 10)
                .log()
                .subscribe(System.out::println);

        // Print 10 times each value from intNumbersFlux for the first 3 numbers emitted that's greater than 5
        // TODO: Write code here
        ReactiveSources.intNumbersFlux()
                .filter(x -> x > 5)
                .take(3)
                .subscribe(x -> System.out.println(x * 10));

        ReactiveSources.intNumbersFlux()
                .filter(x -> x > 5)
                .take(3)
                .map(x -> x * 10)
                .subscribe(System.out::println);

        // Print each value from intNumbersFlux that's greater than 20. Print -1 if no elements are found
        // TODO: Write code here
        Flux<Integer> aa = ReactiveSources.intNumbersFlux()
                .filter(x -> x > 20)
                .defaultIfEmpty(-1);

        aa.subscribe(x -> System.out.println(x));

        // Video solution (same, I do an assignment to make explicit)
        ReactiveSources.intNumbersFlux()
                .filter(x -> x > 20)
                .defaultIfEmpty(-1)
                .subscribe(x -> System.out.println(x));

        // Switch ints from intNumbersFlux to the right user from userFlux
        // TODO: Write code here
        ReactiveSources.intNumbersFlux()
                // This replaces every int with a Flux, use FlatMap instead....
                //.map(id -> ReactiveSources.userFlux().filter(user -> user.getId() == id))
                .flatMap(id -> ReactiveSources.userFlux().filter(user -> user.getId() == id))
                .subscribe(x -> System.out.println(x));


        // Print only distinct numbers from intNumbersFluxWithRepeat
        // TODO: Write code here
        ReactiveSources
                .intNumbersFluxWithRepeat()
                .distinct()
                .subscribe(System.out::println);

        // Print from intNumbersFluxWithRepeat excluding immediately repeating numbers
        // TODO: Write code here
        // ctrl + f: distinctUntilChanged() on docs
        ReactiveSources
                .intNumbersFluxWithRepeat()
                .distinctUntilChanged()
                .subscribe(x -> System.out.println(x));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
