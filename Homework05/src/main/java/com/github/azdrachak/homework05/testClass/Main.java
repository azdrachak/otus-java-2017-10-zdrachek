package com.github.azdrachak.homework05.testClass;

import com.github.azdrachak.homework05.testFramework.exceptions.NoTestsFoundException;
import com.github.azdrachak.homework05.testFramework.exceptions.TooManyAfterAnnotationsEsception;
import com.github.azdrachak.homework05.testFramework.exceptions.TooManyBeforeAnnotationsEsception;
import com.github.azdrachak.homework05.testFramework.tester.RunTestsInClass;
import com.github.azdrachak.homework05.testFramework.tester.RunTestsInPackage;

public class Main {
    public static void main(String[] args)
            throws NoTestsFoundException, TooManyAfterAnnotationsEsception, TooManyBeforeAnnotationsEsception, ClassNotFoundException {

        System.out.println("Run tests in the class:");
        RunTestsInClass.runTests(Class.forName("com.github.azdrachak.homework05.test.MainTest1"));

        System.out.println("\nRun tests in the package:");
        RunTestsInPackage.runTests("com.github.azdrachak.homework05.test");
    }
}
