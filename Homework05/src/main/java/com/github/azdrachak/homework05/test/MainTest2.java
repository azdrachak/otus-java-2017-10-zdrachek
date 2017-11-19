package com.github.azdrachak.homework05.test;

import com.github.azdrachak.homework05.testFramework.annotations.Test;

import static com.github.azdrachak.homework05.testFramework.assertions.Assertions.assertEquals;

public class MainTest2 {
    @Test
    public void test() {
        System.out.println("Test from second class");
        assertEquals("True", "True");
    }
}
