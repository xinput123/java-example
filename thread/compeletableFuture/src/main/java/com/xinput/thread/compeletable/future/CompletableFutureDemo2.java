package com.xinput.thread.compeletable.future;

import com.xinput.thread.compeletable.future.domain.MedalInfo;
import com.xinput.thread.compeletable.future.domain.UserInfo;
import com.xinput.thread.compeletable.future.service.MedalService;
import com.xinput.thread.compeletable.future.service.UserInfoService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * {@link CompletableFuture} 自定义线程池示例
 * <p>
 * CompletableFuture线程池策略最好使用AbortPolicy
 */
public class CompletableFutureDemo2 {
  public static void main(String[] args) throws InterruptedException, TimeoutException, ExecutionException {
    // 自定义线程池
    ExecutorService executor = Executors.newCachedThreadPool();

    UserInfoService userInfoService = new UserInfoService();
    MedalService medalService = new MedalService();
    long id = 1L;
    long startTime = System.currentTimeMillis();

    // 调用用户服务获取用户基本信息
    CompletableFuture<UserInfo> completableUserInfoFuture = CompletableFuture.supplyAsync(() -> userInfoService.getUserInfo(id), executor);

    Thread.sleep(500); //模拟主线程其它操作耗时

    CompletableFuture<MedalInfo> completableMedalInfoFuture = CompletableFuture.supplyAsync(() -> medalService.getMedalInfo(id), executor);

    UserInfo userInfo = completableUserInfoFuture.get(2, TimeUnit.SECONDS);//获取个人信息结果
    MedalInfo medalInfo = completableMedalInfoFuture.get();//获取勋章信息结果

    System.out.println(userInfo.toString());
    System.out.println(medalInfo.toString());
    System.out.println("总共用时" + (System.currentTimeMillis() - startTime) + "ms");
  }
}
