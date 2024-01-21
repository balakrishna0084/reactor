package com.rp.sec01;

import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {
    public static void main(String[] args) {
        Mono<String> mono = Mono.just("ball");
        mono.subscribe(
                item -> System.out.println(item),
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Completed")
        );
    }
}
