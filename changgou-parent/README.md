#### create data 2022/10/21 by zhaozl

###### 模块介绍 ######

1.changgou-parent
项目整体工程父模块，所以服务需要共享的微服务版本以及所以服务需要使用的依赖。
2.changgou-common
项目公共服务模块,独立出所有模块可以共享使用的Entity、Utils、Exception处理 、
微服务配置文件等等
3.changgou-common-db
项目数据库公共服务模块,独立出所有模块可以共享使用的数据库依赖以及微服务配置文件等等


#### 启动类  *SpringBoorApplication

1、在加入需要包扫描的类时，需要同时加入control、service扫描，否则springboot会忽略
service等需要交互的层次
2、springcloud项目时，需要注册的服务模块需要加入@EnableEurekaClient注解，开启服务客户端注册
3、mybatis框架需要开启@MapperScan注解，同时加入dao层扫描，否则会导致找不到dao映射

#### 控制器  *Controller
1、springcloud项目时、模块跨越时，需要开启@CrossOrigin允许跨越注解
2、springboot项目时，@RestController注解即代表@ResponseBody和@Controller注解，
   无需再像springMVC一样需要额外单独引入@ResponseBody注解和@Controller注解
    
#### 全局异常处理
1、创建全局异常类，需要引入@RestControllerAdvice注解，这将会拦截所有RequestMapping所响应的异常，
注：在springboot中有@ControllerAdvice和@RestControllerAdvice两种全局异常注解,而@RestConerollerAdvice注解在springboot源码中已经引入了@ControllerAdvice注解，
故两者引入@RestControllerAdvcie即可，实现方式也是一致的。同时，在异常处理方法需要引入@ExceptionHandler异常处理对象，以及需要统一返回结果集的返回类型，通常为json，方法需要添加@ResponseBody注解


2、在全局异常的配置上，通常是需要独立到公共服务模块与其他消费服务共享的，所以一般消费服务需要引用到公共模块。
注：在消费服务模块启动类需要扫描全局异常所在包并且需要依赖公共服务模块