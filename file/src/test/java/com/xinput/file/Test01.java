package com.xinput.file;

import com.github.xinput.commons.file.FileHelper;

import java.util.List;

public class Test01 {
  public static void main(String[] args) {
    List<String> ch1 = FileHelper.readFile("/Users/yuanlai/Desktop/当红艺人1.txt");
    List<String> ch2 = FileHelper.readFile("/Users/yuanlai/Desktop/优秀艺人2.txt");
    List<String> ch3 = FileHelper.readFile("/Users/yuanlai/Desktop/工会新主播3.txt");
    System.out.println(ch1.size());
    System.out.println(ch2.size());
    System.out.println(ch3.size());

//    List<String> ss = Lists.newArrayListWithCapacity(10000);
//    for (String s : ch3) {
//      ss.add(s);
//      if (ss.size() == 10000) {
//        System.out.println(JsonHelper.toJsonString(ss));
//        System.out.println("\n");
//        ss = Lists.newArrayListWithCapacity(10000);
//      }
//    }
//    System.out.println(JsonHelper.toJsonString(ss));
  }
}
