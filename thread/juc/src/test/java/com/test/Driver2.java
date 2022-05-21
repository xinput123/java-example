package com.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Driver2 {
  public static void main(String[] args) throws InterruptedException {
    CountDownLatch doneSignal = new CountDownLatch(10);
    Executor e = Executors.newFixedThreadPool(8);

    // 创建 N 个任务，提交给线程池来执行
    for (int i = 0; i < 10; ++i) // create and start threads
      e.execute(new WorkerRunnable(doneSignal, i));

    // 等待所有的任务完成，这个方法才会返回
    doneSignal.await(); // wait for all to finish
  }
}

class WorkerRunnable implements Runnable {
  private final CountDownLatch doneSignal;
  private final int i;

  WorkerRunnable(CountDownLatch doneSignal, int i) {
    this.doneSignal = doneSignal;
    this.i = i;
  }

  public void run() {
    doWork(i);
    // 这个线程的任务完成了，调用 countDown 方法
    doneSignal.countDown();
  }

  void doWork(int i) {
    System.out.println(i);
  }
}