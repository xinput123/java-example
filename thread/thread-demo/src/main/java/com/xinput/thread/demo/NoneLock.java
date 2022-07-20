package com.xinput.thread.demo;

/**
 * 无锁
 * A 和 B 随机执行
 */
public class NoneLock {
  static class ThreadA implements Runnable {
    @Override
    public void run() {
      for (int i = 0; i < 100; i++) {
        System.out.println("Thread A " + i);
      }
    }
  }

  static class ThreadB implements Runnable {
    @Override
    public void run() {
      for (int i = 0; i < 100; i++) {
        System.out.println("Thread B " + i);
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    new Thread(new ThreadA()).start();
    new Thread(new ThreadB()).start();
  }
}
