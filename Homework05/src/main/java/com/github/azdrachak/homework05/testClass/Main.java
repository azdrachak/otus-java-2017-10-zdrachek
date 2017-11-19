package com.github.azdrachak.homework05.testClass;

import com.github.azdrachak.homework05.testFramework.exceptions.NoTestsFoundException;
import com.github.azdrachak.homework05.testFramework.exceptions.TooManyAfterAnnotationsEsception;
import com.github.azdrachak.homework05.testFramework.exceptions.TooManyBeforeAnnotationsEsception;
import com.github.azdrachak.homework05.testFramework.tester.RunTestsInClass;

public class Main {
    public static void main(String[] args)
            throws NoTestsFoundException, TooManyAfterAnnotationsEsception, TooManyBeforeAnnotationsEsception, ClassNotFoundException {

        RunTestsInClass.runTests(Class.forName("com.github.azdrachak.homework05.test.MainTest"));
    }
}
