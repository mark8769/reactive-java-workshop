package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.Disposable;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        ReactiveSources.intNumberMono().subscribe(
                // Run this when item event happens
                num -> System.out.println(num),
                // Run this when error event happens
                err -> System.out.println(err.getMessage()),
                // Run this when complete event happens
                () -> System.out.println("Complete")
        );

        // Subscribe to a flux using the error and completion hooks
        // TODO: Write code here

        ReactiveSources.intNumbersFlux().subscribe(
                // Run this when item event happens
                num -> System.out.println(num),
                // Run this when error event happens
                err -> System.out.println(err.getMessage()),
                // Run this when complete event happens
                () -> System.out.println("Complete")
        );

        // Ex: This is taking 10 seconds to complete
        // Taking to long, and want to stop this process

        Disposable subscribe = ReactiveSources
                .intNumbersFlux()
                .subscribe(
                        num -> System.out.println(num),
                        err -> System.out.println(err),
                        () -> System.out.println("Completed"),
                        // This is deprecated! DO NOT USE THIS SIGNATURE..
                        subscriber -> {

                        }
                );

        // Subscribe to a flux using an implementation of BaseSubscriber
        // TODO: Write code here
        ReactiveSources.intNumbersFlux().subscribe(new MySubscriber<>());

        // ANOTHER WAY TO SUBSCRIBE without having to create all individual lambdas
        // BaseSubscriber is an implementation of classes that has all implementation
        // What to do when item/error/complete events happen, what to do when next item event happens...


        System.out.println("Press a key to end");
        System.in.read();
    }

}

/*
NOT WIDELY USED, BUT BENEFICIAL WHEN YOU WANT CONTROL OVER BACKPRESSURE... (KEEP IN MIND)
 */
class MySubscriber<T> extends BaseSubscriber<T> {

    // Hook for each thing that could happen

    // When subscribe happens there is a hook
    public void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscribe happend.");
        // I am ok with handling 2 items whenever they are ready
        // Until I request for more, don't give me more items.
        request(2);
    }

    // When a next event is triggered there is a hook
    // Need to do a request when using a subscription class like this
    // Seems really similar to next/iterator pattern.

    // This is related to backpressure
    // All these subscriptions have a way of telling Publisher how much
    // data they are fine processing. E.g. give me 10 values at a time
    // and then give me more whenever I am ready.

    // E.g need to ask for more items.
    // Also a another reason that subscribe method with 4 params is @deprecated
    public void hookOnNext(T value) {
        System.out.println(value.toString() + " received");
        request(2);
    }

}