package com.zjnh.kotlin.generics;

public class Raw<T> {
    public static void main(String... args) {
        Raw raw = new Raw();
        System.out.println(raw);
    }

    public static Raw getRaw() {
        return new Raw();
    }
}

