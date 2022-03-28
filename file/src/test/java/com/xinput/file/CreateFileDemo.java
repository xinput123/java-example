package com.xinput.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * 生成1000w随机文本文件
 */
public class CreateFileDemo {
  private static final String ENCODING = "UTF-8";
  private static File file = new File(ClassLoader.getSystemResource("").getPath() + File.separator + "test.txt");

  public static void main(String[] args) {
    String prefix = "您好";
    try (OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(file, true), ENCODING);) {
      // 随机生成数据
      for (long j = 0L; j < 100000000L; j++) {
        out.write(prefix + (int) (130000000 * Math.random()) + "\n");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println(file.getAbsolutePath());
  }
}
