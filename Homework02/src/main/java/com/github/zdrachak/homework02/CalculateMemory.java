package com.github.zdrachak.homework02;

import java.util.function.Supplier;

/**
 * Calculate memory used by supplied object
 */
class CalculateMemory {
    private Runtime runtime;
    private int objectCount;
    private int iterationsCount;

    /**
     * @param objectCount how many objects will be created
     * @param iterationsCount how many iterations will be performed
     */
    CalculateMemory(int objectCount, int iterationsCount) {
        this.runtime = Runtime.getRuntime();
        this.objectCount = objectCount;
        this.iterationsCount = iterationsCount;
    }

    /**
     * Calculation is performed by measuring memory used by application
     * Then multiple object exemplars are created
     * Then memory used by application is measured again
     * Actions above are performed in cycle and then average size is calculated
     * @param objectConstructor object of the particular class which size is to be measured
     * @return object size in bytes
     */
    long calculate(Supplier objectConstructor) throws InterruptedException {
        long memoryUsedByAllIterations = 0;
        long memoryUsageBefore;
        long memoryUsageAfter;
        Object[] objArray;

        for (int itrations = 0; itrations < this.iterationsCount; itrations++) {
            runGC();
            objArray = new Object[objectCount];
            memoryUsageBefore = getUsedMemory();

            for (int i = 0; i < objectCount; i++) {
                objArray[i] = objectConstructor.get();
            }

            memoryUsageAfter = getUsedMemory();
            memoryUsedByAllIterations += Math.round((double) (memoryUsageAfter - memoryUsageBefore) / objectCount);
        }
        return memoryUsedByAllIterations / iterationsCount;
    }

    private long getUsedMemory() {
        return runtime.totalMemory() - runtime.freeMemory();
    }

    private void runGC() throws InterruptedException {
        System.gc();
        Thread.sleep(300);
    }
}
