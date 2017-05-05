package com.winterbe.java8.samples.concurrent.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

import com.winterbe.java8.samples.concurrent.ConcurrentUtils;

/**
 * @author Benjamin Winterberg
 */
public class StampedLockDemo {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Map<String, String> map = new HashMap<>();
        StampedLock lock = new StampedLock();
        executor.submit(() -> {
            long stamp = lock.writeLock();
            try {
                ConcurrentUtils.sleep(1);
                map.put("foo", "bar");
            } finally {
                lock.unlockWrite(stamp);
            }
        });

        Runnable readTask = () -> {
            long stamp = lock.readLock();
            try {
                System.out.println("read: "+map.get("foo"));
                ConcurrentUtils.sleep(1);
            } finally {
                lock.unlockRead(stamp);
            }
        };
        executor.submit(readTask);
        executor.submit(readTask);

        ConcurrentUtils.stop(executor);
    }
}
