package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Exercise6 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.unresponsiveFlux() and ReactiveSources.unresponsiveMono()

        // Get the value from the Mono into a String variable but give up after 5 seconds
        // TODO: Write code here
//        String s = ReactiveSources.unresponsiveMono().block(Duration.ofSeconds(5));

        // Get the value from unresponsiveFlux into a String list but give up after 5 seconds
        // Come back and do this when you've learnt about operators!
        // TODO: Write code here
        // javadoc.io/doc/io.projectreactor/reactor-core/latest/reactor/core/publisher/Flux.html#blockLast
//        String a = ReactiveSources.stringNumbersFlux().blockLast(Duration.ofSeconds(5));
//        System.out.println(a);

        List<String> l = ReactiveSources
                .unresponsiveFlux()
                .collectList()
                .block(Duration.ofSeconds(5));

        System.out.println(l);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
