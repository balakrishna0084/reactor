package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec04MonoSubscribeError {
    public static void main(String[] args) {

        Mono<Integer> mono = Mono.just("ball")
                        .map(String::length)
                        .map(i -> i/0);

        mono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}
