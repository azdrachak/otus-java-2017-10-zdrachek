package com.github.azdrachak.homework05.testFramework.tester;

import com.github.azdrachak.homework05.testFramework.exceptions.NoTestsFoundException;
import com.github.azdrachak.homework05.testFramework.exceptions.TooManyAfterAnnotationsEsception;
import com.github.azdrachak.homework05.testFramework.exceptions.TooManyBeforeAnnotationsEsception;
import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;

import java.io.IOException;

public class RunTestsInPackage {
    public static void runTests(String testPackage)
            throws NoTestsFoundException, TooManyBeforeAnnotationsEsception, TooManyAfterAnnotationsEsception {
        // Find all classes in package
        ClassPath cp = null;
        try {
            cp = ClassPath.from(ClassLoader.getSystemClassLoader());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImmutableSet<ClassPath.ClassInfo> classes = cp != null ? cp.getTopLevelClasses(testPackage) : null;

        if (classes == null) throw new NoTestsFoundException();

        // For each found class:
        // - Load it with ClassLoader
        // - Use RunTestsInClass.runTests() on it
        for (ClassPath.ClassInfo aClass : classes) {
            try {
                ClassLoader.getSystemClassLoader().loadClass(aClass.getName());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                RunTestsInClass.runTests(Class.forName(aClass.getName()));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
}
