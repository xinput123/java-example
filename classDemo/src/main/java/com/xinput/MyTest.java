package com.xinput;

/**
 * TODO
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @since
 */
public class MyTest {
  public static void main(String[] args) {
    try {
      Class.forName("com.xinput.ClassForName");
      System.out.println("############ 分隔符 ############");
      ClassLoader.getSystemClassLoader().loadClass("com.xinput.ClassForName");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
