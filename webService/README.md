## WebService 示例

#### 1、创建服务接口

```java

@WebService
public interface ReportServices {
  String report(String message);
}
```

#### 2、接口实现

```java

@WebService(endpointInterface = "com.xinput.web.service.ReportServices", serviceName = "ReportServices")
public class ReportServicesImpl implements ReportServices {

  @Override
  public String report(String message) {
    return "report: " + message;
  }
}
```

#### 3、启动服务

```java
public class WebServiceApp {

  private final static String address = "http://127.0.0.1:8092/ReportServices";

  public static void main(String[] args) {
    System.out.println("web service start");
    ReportServices reportServices = new ReportServicesImpl();
    Endpoint.publish(address, reportServices);
    System.out.println("web service started");
  }
}
```

#### 4、使用服务

```java
public class WebClient {
  public static void main(String[] args) {
    String message = "测试";
    try {
      Object[] objects = WsUtils.webService(message);
      System.out.println(String.valueOf(objects[0]));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
```