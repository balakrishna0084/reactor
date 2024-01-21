package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Lec10MonoBlock {
    public static void main(String[] args) {

        // Building pipeline
        getName();

        // Executing pipeline
        String name = getName()
                .subscribeOn(Schedulers.boundedElastic())
                .block();
        System.out.println(name);

        // Building pipeline
        getName();

        Util.sleepSeconds(4);

    }

    private static Mono<String> getName(){
        System.out.println("Entered getName method");
        return Mono.fromSupplier(() -> {
            System.out.println("Generating name...");
            Util.sleepSeconds(3);
            return Util.faker().name().firstName();
        }).map(String::toUpperCase);
    }
}

