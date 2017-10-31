package com.github.azdrachak;

import java.util.Collections;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        Collections.addAll(myArrayList, 1, 3, 2, 5, 4);
        System.out.println("Test addAll from java.util.Collections:");
        Stream.of(myArrayList.toArray()).forEach(x -> System.out.print(x + " "));

        MyArrayList<Integer> listCopy = new MyArrayList<>();
        listCopy.add(0);
        listCopy.add(0);
        listCopy.add(0);
        listCopy.add(0);
        listCopy.add(0);
        Collections.copy(listCopy, myArrayList);
        System.out.println("\nTest copy from java.util.Collections");
        Stream.of(listCopy.toArray()).forEach(x -> System.out.print(x + " "));

        Collections.sort(myArrayList);
        System.out.println("\nTest sort from java.util.Collections");
        Stream.of(myArrayList.toArray()).forEach(x -> System.out.print(x + " "));
    }
}
