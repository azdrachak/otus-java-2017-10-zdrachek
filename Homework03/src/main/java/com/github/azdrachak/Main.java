package com.github.azdrachak;

import java.util.Collections;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        Collections.addAll(myArrayList, 1, 3, 2, 5, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Test addAll from java.util.Collections:");
        Stream.of(myArrayList.toArray()).forEach(x -> System.out.print(x + " "));

        MyArrayList<Integer> listCopy = new MyArrayList<>();
        Collections.addAll(listCopy, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        Collections.copy(listCopy, myArrayList);
        System.out.println("\nTest copy from java.util.Collections");
        Stream.of(listCopy.toArray()).forEach(x -> System.out.print(x + " "));

        Collections.sort(myArrayList);
        System.out.println("\nTest sort from java.util.Collections");
        Stream.of(myArrayList.toArray()).forEach(x -> System.out.print(x + " "));
    }
}
