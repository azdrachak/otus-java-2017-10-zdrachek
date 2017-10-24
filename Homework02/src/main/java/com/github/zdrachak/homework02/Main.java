package com.github.zdrachak.homework02;

import java.util.ArrayList;

public class Main {
    @SuppressWarnings("RedundantStringConstructorCall")
    public static void main(String[] args) throws InterruptedException {
        CalculateMemory calculator = new CalculateMemory(10_000_000, 5);

        System.out.print("Empty string size in bytes: ");
        System.out.println(calculator.calculate(() -> new String(new char[]{})));

        System.out.print("Empty Integer object size in bytes: ");
        System.out.println(calculator.calculate(IntegerClass::new));

        System.out.print("Empty ArrayList size in bytes: ");
        System.out.println(calculator.calculate(ArrayListClass::new));

        System.out.print("Empty array size in bytes: ");
        System.out.println(calculator.calculate(ArrayClass::new));

        System.out.print("Container with one element size in bytes: ");
        System.out.println(calculator.calculate(ObjectCLassOneElement::new));

        System.out.print("Container with two elements size in bytes: ");
        System.out.println(calculator.calculate(ObjectCLassTwoElements::new));

        System.out.print("Container with four elements size in bytes: ");
        System.out.println(calculator.calculate(ObjectCLassFourElements::new));

        System.out.print("Container with eight elements size in bytes: ");
        System.out.println(calculator.calculate(ObjectCLassEightElements::new));

    }

    private static class IntegerClass {
        private Integer i;
    }

    private static class ArrayListClass {
        private ArrayList<Integer> list;
    }

    private static class ArrayClass {
        private Object[] array;
    }

    private static class ObjectCLassOneElement {
        private Object obj;
    }

    private static class ObjectCLassTwoElements {
        private Object obj1;
        private Object obj2;
    }

    private static class ObjectCLassFourElements {
        private Object obj1;
        private Object obj2;
        private Object obj3;
        private Object obj4;
    }

    private static class ObjectCLassEightElements {
        private Object obj1;
        private Object obj2;
        private Object obj3;
        private Object obj4;
        private Object obj5;
        private Object obj6;
        private Object obj7;
        private Object obj8;
    }
}
