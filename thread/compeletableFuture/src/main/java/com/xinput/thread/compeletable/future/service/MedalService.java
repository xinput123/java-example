package com.xinput.thread.compeletable.future.service;

import com.xinput.thread.compeletable.future.domain.MedalInfo;

public class MedalService {

  public MedalInfo getMedalInfo(long mediaId) {
    try {
      Thread.sleep(1000); //模拟调用耗时
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return new MedalInfo(String.valueOf(mediaId), "跑步达人");
  }
}
