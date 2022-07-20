package com.xinput.thread.demo;

/**
 * 基于 volatile 实现一个简单的信号量.
 * A B 交替执行
 */
public class Signal {

  private static volatile int singal = 0;

  static class ThreadA implements Runnable {
    @Override
    public void run() {
      while (singal < 10) {
        if (singal % 2 == 0) {
          System.out.println("Thread A " + singal);
          singal++;
        }
      }
    }
  }

  static class ThreadB implements Runnable {
    @Override
    public void run() {
      while (singal < 10) {
        if (singal % 2 == 1) {
          System.out.println("Thread B " + singal);
          singal++;
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
