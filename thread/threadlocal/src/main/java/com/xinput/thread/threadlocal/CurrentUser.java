package com.xinput.thread.threadlocal;

public class CurrentUser {

  public static final ThreadLocal<UserInfo> USER_THREAD_LOCAL =
      new ThreadLocal();

  public static void set(UserInfo userInfo) {
    USER_THREAD_LOCAL.set(userInfo);
  }

  public static UserInfo get() {
    return USER_THREAD_LOCAL.get();
  }

  public static void remove() {
    USER_THREAD_LOCAL.remove();
  }
}
