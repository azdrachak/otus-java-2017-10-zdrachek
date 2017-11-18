package com.github.azdrachak.homework05.test;

import com.github.azdrachak.homework05.testFramework.annotations.After;
import com.github.azdrachak.homework05.testFramework.annotations.Before;
import com.github.azdrachak.homework05.testFramework.annotations.Test;

public class MainTest {
    @Before
    public void setUp(){
        System.out.println("Before method");
    }

    @Test
    public void test1() {
        System.out.println("Test method 1");
    }

    @Test
    public void test2() {
        System.out.println("Test method 2");
    }

    @After
    public void tearDown() {
        System.out.println("After method");
    }
}
