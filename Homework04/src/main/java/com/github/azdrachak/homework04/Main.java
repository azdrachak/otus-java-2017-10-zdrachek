package com.github.azdrachak.homework04;

/*
JVM options:
-agentlib:jdwp=transport=dt_socket,address=14000,server=y,suspend=n
-Xms128m
-Xmx128m
-XX:MaxMetaspaceSize=256m
-XX:+UseG1GC
 */


/*
Мне в данном случае показался оптимальнее ConcurrentMarkSweep
G1 продержался дольше, но грузил процессор при работе намного сильнее
Results
1. Serial GC (-XX:+UseSerialGC)
    Uptime: 4 min 34 sec
    GC: Copy, runs: 5, duration: 208
    GC: MarkSweepCompact, runs: 68, duration: 15819
2. Parallel GC (-XX:+UseParallelGC)
    Uptime: 4 min 53 sec
    GC: PS MarkSweep, runs: 7, duration: 4514
    GC: PS Scavenge, runs: 3, duration: 279
3. Parallel Compacting GC (-XX:+UseParallelOldGC)
    Uptime: 4 min 08 sec
    GC: PS MarkSweep, runs: 8, duration: 5007
    GC: PS Scavenge, runs: 3, duration: 310
4. CMS GC (-XX:+UseConcMarkSweepGC -XX:+UseParNewGC)
    Uptime: 4 min 26 sec
    GC: ParNew, runs: 6, duration: 369
    GC: ConcurrentMarkSweep, runs: 152, duration: 41722
5. G1 (-XX:+UseG1GC)
    Uptime: 7 min 01 sec
    GC: G1 Young Generation, runs: 33, duration: 763
    GC: G1 Old Generation, runs: 8, duration: 2919
 */
import com.sun.management.GarbageCollectionNotificationInfo;

import javax.management.NotificationEmitter;
import javax.management.NotificationListener;
import javax.management.openmbean.CompositeData;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    private static HashMap<String, ArrayList<Long>> stats = new HashMap<>();
    private static long startTime;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("pid: " + ManagementFactory.getRuntimeMXBean().getName());

        startGCdataCollect();

        int size = 2_000_000;
        MemoryLeaker leaker = new MemoryLeaker(size);
        leaker.leak();
    }

    private static void startGCdataCollect() {
        startTime = System.currentTimeMillis();
        List<GarbageCollectorMXBean> gcBeans = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean gcBean : gcBeans) {
            NotificationEmitter emitter = (NotificationEmitter) gcBean;
            System.out.println(gcBean.getName());

            stats.put(gcBean.getName(), new ArrayList<>());

            NotificationListener listener = (notification, handback) -> {
                if (notification.getType().equals(GarbageCollectionNotificationInfo.GARBAGE_COLLECTION_NOTIFICATION)) {
                    GarbageCollectionNotificationInfo info = GarbageCollectionNotificationInfo.from((CompositeData) notification.getUserData());

                    long duration = info.getGcInfo().getDuration();
                    stats.get(info.getGcName()).add(duration);
                    printStats();
                }
            };

            emitter.addNotificationListener(listener, null, null);
        }
    }

    private static void printStats() {
        long uptime = System.currentTimeMillis() - startTime;
        for (String name : stats.keySet()) {
            ArrayList<Long> list = stats.get(name);
            long totalTimeMS = list.stream().mapToLong(Long::longValue).sum();
            System.out.println("GC: " + name + ", runs: " + list.size() + ", duration: " + totalTimeMS + ", application uptime: " + uptime);
        }
    }
}
