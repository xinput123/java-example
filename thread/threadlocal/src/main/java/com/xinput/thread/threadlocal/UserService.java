package com.xinput.thread.threadlocal;

/**
 * 在业务代码中调用 CurrentUser 类。
 */
public class UserService {

  public void doSomeThing(UserDto userDto) {
    UserInfo userInfo = convert(userDto);
    try {
      CurrentUser.set(userInfo);

      // ...
//    //业务代码
//    UserInfo userInfo = CurrentUser.get();
      // ...
    } finally {
      // 使用 ThreadLocal 后，使用完成后，需要清理没用的数据
      CurrentUser.remove();
    }
  }

  private UserInfo convert(UserDto userDto) {
    return new UserInfo();
  }
}
