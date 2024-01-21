package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Lec07MonoFromCallable {
    public static void main(String[] args) {

        Supplier<String> stringSupplier = () -> getName();
        Mono.fromSupplier(stringSupplier)
                        .subscribe(
                                Util.onNext()
                        );

        Callable<String> stringCallable = () -> getName();
        Mono.fromCallable(stringCallable)
                .subscribe(
                        Util.onNext()
                );


    }

    private static String getName(){
        System.out.println("Generating name ...");
        return Util.faker().name().firstName();
    }
}
