package com.example.demo.fluxandmono;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class MonoTest
{
    public static void main(String[] args)
    {
        Mono<String> empty = Mono.empty();
        Mono<String> data = Mono.just("foo");
        System.out.println(data.block());
        System.out.println("--------------------------------------");
        Flux<Integer> numbersFromFiveToSeven = Flux.range(5, 3);
        System.out.println(numbersFromFiveToSeven.blockFirst());

        Map<String, Object> map = new HashMap<>();
        System.out.println(String.valueOf(map.get("Aa")));
    }
}
