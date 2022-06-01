package com.xinput;

public class ClassForName {

  // 静态代码块
  static {
    System.out.println("执行静态代码块");
  }

  // 静态变量
  private static String staticField = staticMethod();

  // 赋值静态变量的静态方法
  private static String staticMethod() {
    System.out.println("执行静态方法");
    return "给静态变量赋值";
  }
}
