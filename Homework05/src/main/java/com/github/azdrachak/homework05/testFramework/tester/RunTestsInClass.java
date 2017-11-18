package com.github.azdrachak.homework05.testFramework.tester;

import com.github.azdrachak.homework05.testFramework.exceptions.NoTestsFoundException;
import com.github.azdrachak.homework05.testFramework.exceptions.TooManyAfterAnnotationsEsception;
import com.github.azdrachak.homework05.testFramework.exceptions.TooManyBeforeAnnotationsEsception;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

public class RunTestsInClass {
    @SuppressWarnings("unchecked")
    public static void runTests(String clazz)
            throws TooManyBeforeAnnotationsEsception, TooManyAfterAnnotationsEsception, NoTestsFoundException {

        Class testClass = null;
        try {
            testClass = Class.forName(clazz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        HashMap<String, List<Method>> methods = ReflectionHelper.getTestAnnotatedMethods(ReflectionHelper.instantiate(testClass));

        if (methods.get("Before").size() > 1) throw new TooManyBeforeAnnotationsEsception();
        if (methods.get("After").size() > 1) throw new TooManyAfterAnnotationsEsception();
        if (methods.get("Test").size() < 1) throw new NoTestsFoundException();

        Method before = methods.get("Before").size() == 1 ? methods.get("Before").get(0) : null;
        Method after = methods.get("After").size() == 1 ? methods.get("After").get(0) : null;
        List<Method> tests = methods.get("Test");

        for (Method test : tests) {
            Object object = ReflectionHelper.instantiate(testClass);
            if (before != null) ReflectionHelper.callMethod(object, before.getName());
            ReflectionHelper.callMethod(object, test.getName());
            if (after != null) ReflectionHelper.callMethod(object, after.getName());
        }
    }
}
