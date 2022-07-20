package com.xinput.thread.demo;

/**
 * 等待/通知机制
 * A 和 B 轮流输出。
 * <p>
 * notify() 方法会随机叫醒一个正在等待的线程，而 notifyAll() 会叫醒所有正在等待的线程。
 */
public class WaitAndNotify {
  private static Object lock = new Object();

  static class ThreadA implements Runnable {
    @Override
    public void run() {
      synchronized (lock) { // 1.1 拿到锁
        for (int i = 0; i < 10; i++) {
          try {
            System.out.println("Thread A " + i);
            lock.notify(); // 1.2 通知其他线程不用等待了
            lock.wait(); // 1.3 释放锁
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }

  static class ThreadB implements Runnable {
    @Override
    public void run() {
      synchronized (lock) {
        for (int i = 0; i < 10; i++) {
          try {
            System.out.println("Thread B " + i);
            lock.notify();
            lock.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    new Thread(new ThreadA()).start();
    Thread.sleep(10);
    new Thread(new ThreadB()).start();
  }
}
