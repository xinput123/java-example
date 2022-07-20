package com.xinput.thread.demo;

/**
 * 对象锁
 * 先让A全部执行完，再执行B
 */
public class ObjectLock {
  private static Object lock = new Object();

  static class ThreadA implements Runnable {
    @Override
    public void run() {
      synchronized (lock) {
        for (int i = 0; i < 100; i++) {
          System.out.println("Thread A " + i);
        }
      }
    }
  }

  static class ThreadB implements Runnable {
    @Override
    public void run() {
      synchronized (lock) {
        for (int i = 0; i < 100; i++) {
          System.out.println("Thread B " + i);
        }
      }
    }
  }

  public static void main(String[] args) {
    new Thread(new ThreadA()).start();
    new Thread(new ThreadB()).start();
  }
}
