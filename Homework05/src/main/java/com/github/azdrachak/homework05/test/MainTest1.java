package com.github.azdrachak.homework05.test;

import com.github.azdrachak.homework05.testFramework.annotations.After;
import com.github.azdrachak.homework05.testFramework.annotations.Before;
import com.github.azdrachak.homework05.testFramework.annotations.Test;

import static com.github.azdrachak.homework05.testFramework.assertions.Assertions.assertEquals;

public class MainTest1 {
    @Before
    public void setUp(){
        System.out.println("Before method");
    }

    @Test
    public void test1() {
        System.out.println("Test method 1");
        assertEquals(2, 1 + 1);
    }

    @Test
    public void test2() {
        System.out.println("Test method 2");
        assertEquals(4, 2 * 2);
    }

    @After
    public void tearDown() {
        System.out.println("After method");
    }
}
