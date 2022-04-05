package com.xinput.mackdown;

import com.github.xinput.commons.StringHelper;
import com.google.common.collect.Lists;

import java.io.File;
import java.text.MessageFormat;
import java.util.List;

/**
 * 生成mackdown跳转链接
 */
public class MackdownDemo {

  private static final String rootPath = "/Users/yuanlai/github/about-me";

  private static final String path = "Redis";

  private static final List<String> filterFile = Lists.newArrayList("README.MD", "IMAGE", "IMAGES");

  private static final String FILE_MESSAGE_FORMAT = "- [{0}]({1})";

  public static void main(String[] args) {
    File file = new File(rootPath + File.separator + path);
    for (String s : file.list()) {
      if (filterFile.contains(s.toUpperCase())) {
        continue;
      }
      String title = StringHelper.substring(s, 0, s.indexOf(".md"));
      String link = "/" + path + "/" + s;
      System.out.println(MessageFormat.format(FILE_MESSAGE_FORMAT, title, link));
    }
  }
}
