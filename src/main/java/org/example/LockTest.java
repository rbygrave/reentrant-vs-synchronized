package org.example;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

  private static final Object lock = new Object();
  private static final ReentrantLock reentrantLock = new ReentrantLock();
  private static long cnt = 0;

  @Benchmark
  @Measurement(iterations = 3)
  @Threads(10)
  @Fork(2)
  @Warmup(iterations = 5, time = 10)
  public long testWithoutLock(){
    return doSomething();
  }

  @Benchmark
  @Measurement(iterations = 3)
  @Threads(10)
  @Fork(2)
  @Warmup(iterations = 5, time = 10)
  public long testReentrantLock(){
    reentrantLock.lock();
    try {
      return doSomething();
    } finally {
      reentrantLock.unlock();
    }
  }

  @Benchmark
  @Measurement(iterations = 3)
  @Threads(10)
  @Fork(2)
  @Warmup(iterations = 5, time = 10)
  public long testSynchronized(){
    synchronized (lock) {
      return doSomething();
    }
  }

  private long doSomething() {
//    long cnt = 0;
//    Random random = new Random();
//    for (int i = 0; i < 2; i++) {
//      cnt += random.nextInt();
//    }
    cnt += 1;
    if (cnt == (Long.MAX_VALUE)) {
      cnt = 0;
    }
    return cnt;
  }

//  public static void main(String[] args) {
//    Options options = new OptionsBuilder().include(LockTest.class.getSimpleName()).build();
//    try {
//      new Runner(options).run();
//    } catch (Exception e) {
//
//    } finally {
//    }
//  }
}
