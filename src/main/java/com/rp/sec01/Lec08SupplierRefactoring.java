package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec08SupplierRefactoring{
    public static void main(String[] args) {

        // Building pipeline
        getName();

        // Executing pipeline
        getName().subscribe(
                Util.onNext()
        );

        // Building pipeline
        getName();


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
