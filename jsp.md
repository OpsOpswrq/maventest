# javaweb开发

## 一.tomcat理解

### 1.发布自己的网站

​	将自己的html文档放在webapps中，index.html为默认的首页，加上自己目录路径来访问，这个是重点

### 2.jsp的examples

​	进入网站后，直接通过相关路径来访问/examples后，有examples学习

### 3.jsp的localhost更改

​	windows上的system32/etc/hosts中改hosts文件

​	tomcat中找到conf文件中的server.xml文件中的**<host></host>**改掉localhost，还可以改端口号

## 二.Http请求

### 1.Request

​	访问    访问方法：post/get     响应状态码：200 等    浏览器中按F12看例子   其中有很多方法

### 2.Response

​	响应    其中有很多方法

## 三. HelloServlet

### 1.servlet

​	servlet是配置动态界面，注意这里的文件配置

### 2.配置动态界面

​	pom.xml改动里面的依赖，加入servlet的依赖，这里上maven的仓库搜索，还有jsp的依赖，在web.xml	中还要注册servlet，<b><servlet></servlet></b>来设置servlet页面的名称并导入相应的class文件，<b><servlet-mapping></servlet-mapping></b>来设置页面的网络路径，注	意这是<b>相对路径</b>，文件的配置要好好的看，这里说的是servlet的注册，这里注意write(PrintWriter)(字节流)和print(PrintWriter)(string等)方法的区别

### 3.ServletContext

#### 			3.1 共享资源

​		ServletContext对象，是所有的servlet所共有的内容，可以得到ServletContex中的内容

​		其中有get和set的方法，先set再get

![image-20220302213101924](C:\Users\feng\Desktop\javaweb\jsp.assets\image-20220302213101924.png)

![image-20220302213116622](C:\Users\feng\Desktop\javaweb\jsp.assets\image-20220302213116622.png)

#### 			3.2 获取初始化参数

​		web.xml中的<context-param></context-param>中可以设置初始化参数,java类中可		以获得初始化参数的值

![image-20220302205612075](C:\Users\feng\Desktop\javaweb\jsp.assets\image-20220302205612075.png)

#### 			3.3 转发页面

​		getResquestDispatch的方法可以转发页面

![image-20220302213045890](C:\Users\feng\Desktop\javaweb\jsp.assets\image-20220302213045890.png)

#### 			3.4 获取资源文件

​		Properties文件，新建一个Properties文件，再load一下，再target中出，也就是	<b>classpath</b>，这个就是类的路径，getServletContext.getResourceAsStream获取WEB-INF中的文件，将其变为文件流，建立新的Properties文件，有两种路径，一个是resoureces下的properties，还有是再java包下的properties，第二种要再pom.xml中加入判定条件

![image-20220302213145688](C:\Users\feng\Desktop\javaweb\jsp.assets\image-20220302213145688.png)

#### 			3.5 servlet注册

![image-20220302213228642](C:\Users\feng\Desktop\javaweb\jsp.assets\image-20220302213228642.png)

## 四.HttpServletResponse

#### 	4.1 负责向浏览器发送数据

​		发送数据方法：PrintWriter方法 和  getOutputstream方法

​		浏览器响应头： setContentType等方法

​		浏览器响应状态码： 200等

#### 	4.2 下载文件

##### 			1.获取下载文件的地址

##### 			2.下载文件名

##### 			3.创建缓存区

##### 			4.获取FileInputStream流--文件获取流

##### 			5.获取ServletOutputStream流--文件下载流

##### 			6.关闭流

​	文件的路径要注意放在resources下，方便获取，要不然就会是绝对路径，这样不好，这里的<b>/</b>就是classpath的路径，也就是resource下的资源文件，classpath是指 WEB-INF文件夹下的classes目录 ，<b>"/"</b>表示当前web应用的根目录，注意getRealPath和getResourceAsStream的区别和相同

![image-20220303181645288](C:\Users\feng\Desktop\javaweb\jsp.assets\image-20220303181645288.png)

#### 4.3实现动态验证码

​	这里注意Graphic类的开发和ImageIO和BufferedImage的开发

![image-20220303185048462](C:\Users\feng\Desktop\javaweb\jsp.assets\image-20220303185048462.png)

#### 3.实现重定向

​	sendRedirect函数，路径要注意，要加上主目录路径

![image-20220303185135074](C:\Users\feng\Desktop\javaweb\jsp.assets\image-20220303185135074.png)

​	重定向和中转的区别，页面是否跳转

![image-20220303144757239](C:\Users\feng\Desktop\javaweb\jsp.assets\image-20220303144757239.png)

## 五.HttpServletRequest

​	可以通过实现request的getParamatar的方法来获取对应的value值，可以是post还可以是get的方法，这两种方法有不一样的地方，一个导航栏里有get的user的信息，而post没有

![image-20220303190715539](C:\Users\feng\Desktop\javaweb\jsp.assets\image-20220303190715539.png)

![image-20220303190703445](C:\Users\feng\Desktop\javaweb\jsp.assets\image-20220303190703445.png)

## 六. Cookies，Session

#### 1.Cookie和Session的区别

​	[Cookie和Session的区别](https://www.jianshu.com/p/2f7031a69f43)

#### 2. Cookies的方法例子

![image-20220303205435193](C:\Users\feng\Desktop\javaweb\jsp.assets\image-20220303205435193.png)

#### 3. Session的方法例子

![image-20220303205449906](C:\Users\feng\Desktop\javaweb\jsp.assets\image-20220303205449906.png)

![image-20220303205500066](C:\Users\feng\Desktop\javaweb\jsp.assets\image-20220303205500066.png)

### 七.jsp学习

#### 1.原理

在IDEA的文件下会有一个work的文件夹，里面有jsp文件的内容，但是这个jsp是jsp.java，对，也就是java文件，底层逻辑将jsp文件转化为java文件，也就是web页面的内容是java文件来显示的

#### 2.九大内置底层变量

* PageContent

  ```java
  final javax.servlet.jsp.PageContext pageContext;    //pageContext
  ```

* Request

  ```java
  HttpServletRequest request;             //Request
  ```

* Response

  ```java
  HttpServletResponse response;       //Response
  ```

* Session

  ```java
  javax.servlet.http.HttpSession session = null;   //session
  ```

* Application

  ```java
  final javax.servlet.ServletContext application;   //application
  ```

* Config

  ```java
  final javax.servlet.ServletConfig config;       //config
  ```

* out

  ```java
  javax.servlet.jsp.Jspwriter out = null;       //out
  ```

* page

  ```java
  final java.lang.Object page = this;       //page
  ```

* exception

  ### important!      这个在scope的属性中有用，设置作用域的

  pageContext保存的数据只在一个界面中有效

  request保存的数据只在一次请求中有效，请求转发会携带这个数据

  session保存的数据只在一次会话中有效，从打开浏览器到关闭浏览器

  application保存的数据只在服务器中有效，从打开服务器到关闭服务器

#### 3.jsp语法   [jsp 语法 ](https://www.runoob.com/jsp/jsp-syntax.html)

**<%   %>**   中间可以存放java代码片段

**<%@ page language="java" contenType="text/html;charset="utf-8" pageEncoding="utf-8"%>**  这个可以解决页面中文乱码问题

**<%! declaration;%>** 这个可以声明变量，只不过放在java的全局变量中

**<%= 表达式%>**  这个是先转化为String，再插入到表达式出现的地方

**<%--文字--%>**   这个是jsp的注释

**<%@ direction attribute="value" %>**  这个是jsp指令

**<jsp:action_name attribute="value">**  这个是jsp行为

#### 4. error界面

通过修改web.xml文件，添加**<error-page></error-page>**可以自定error的界面

#### 区别

![image-20220304203039286](C:\Users\feng\Desktop\javaweb\jsp.assets\image-20220304203039286.png)

#### 5.EL表达式  [EL表达式](http://c.biancheng.net/jsp2/el.html)

**$()**   1.获取form表单数据   2.执行运算  3.获取web开发的常用对象

![image-20220304213648267](C:\Users\feng\Desktop\javaweb\jsp.assets\image-20220304213648267.png)

下面的这个是jsp文件，所以action可以使用jstl标准库函数

![image-20220304213829966](C:\Users\feng\Desktop\javaweb\jsp.assets\image-20220304213829966.png)

#### 6.jstl表达式

```java
前提引入：<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
```

**核心标签**   [JSP 标准标签库](https://www.runoob.com/jsp/jsp-jstl.html)

**< c:if >**  **< c:out >**  **< c:choose >**  **< c:when >**  **< c:forEach >**

![image-20220304213225469](C:\Users\feng\Desktop\javaweb\jsp.assets\image-20220304213225469.png)

## 八. Filter       

这个用来过滤数据，处理过来的数据   这个Filter通过实现Filter的接口类           idea实现一个小的项目

![image-20220305182325551](C:\Users\feng\Desktop\javaweb\jsp.assets\image-20220305182325551.png)

Filter还要配置web.xml的Filter的注册

![image-20220305182548542](C:\Users\feng\Desktop\javaweb\jsp.assets\image-20220305182548542.png)

## 九. 监听器

#### 1. GUI布局下可以使用它来监测GUI的window事件的发生

Listener有很多种，这个可以自行摸索

![image-20220305183520836](C:\Users\feng\Desktop\javaweb\jsp.assets\image-20220305183520836.png)

#### 2. 在javaweb中实现监听页面变化

在web.xml中注册listener的注册

![image-20220305183649487](C:\Users\feng\Desktop\javaweb\jsp.assets\image-20220305183649487.png)

## 十. JDBC

 这里有两种操作数据库的操作    但是连接数据库的操作只有这一个

![image-20220306150542715](C:\Users\feng\Desktop\javaweb\jsp.assets\image-20220306150542715.png)

#### JDBC的固定步骤

1.加载驱动

2.连接数据库，代表数据库

3.向数据库发送SQL的对象Statement:CRUD   增，读，加，删

4.编写SQL (根据业务，不同的SQL语句)

5.执行SQL

6.从近到外，依次关闭连接

#### 小插曲   @Test的使用    可以使方法直接使用

![image-20220305214131487](C:\Users\feng\Desktop\javaweb\jsp.assets\image-20220305214131487.png)



![image-20220306144707079](C:\Users\feng\Desktop\javaweb\jsp.assets\image-20220306144707079.png)

![image-20220306144923248](C:\Users\feng\Desktop\javaweb\jsp.assets\image-20220306144923248.png)

![image-20220306145503188](C:\Users\feng\Desktop\javaweb\jsp.assets\image-20220306145503188.png)

![image-20220306145754923](C:\Users\feng\Desktop\javaweb\jsp.assets\image-20220306145754923.png)

![image-20220306145854812](C:\Users\feng\Desktop\javaweb\jsp.assets\image-20220306145854812.png)

![image-20220306150639007](C:\Users\feng\Desktop\javaweb\jsp.assets\image-20220306150639007.png)

![image-20220306150740968](C:\Users\feng\Desktop\javaweb\jsp.assets\image-20220306150740968.png)

![image-20220306150948620](C:\Users\feng\Desktop\javaweb\jsp.assets\image-20220306150948620.png)

![image-20220306153503363](C:\Users\feng\Desktop\javaweb\jsp.assets\image-20220306153503363.png)
