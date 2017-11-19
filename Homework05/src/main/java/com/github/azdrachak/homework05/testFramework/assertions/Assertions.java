package com.github.azdrachak.homework05.testFramework.assertions;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class Assertions {

    public static void assertEquals(Object expected, Object actual) {
        assertThat(actual, is(equalTo(expected)));
    }
}
