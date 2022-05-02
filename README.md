# 微服务

```
actuator 健康检查、审计、统计和监控
lombok 简化get set
Mapper 使用通用Mapper简化不必要sql，例如CRUD
mybatis-generator-maven-plugin 自动生成实体类和Mapper文件
赋值对象和对象的属性值使用spring提供的BeanUtils.copyProperties(Object source, Object target) 
整合spring-cloud、spring-cloud-alibaba版本管理
nacos 服务发现、服务配置、服务元数据及流量管理
      1.namespace 命名空间: 对不同环境隔离
      2.cluster-name 集群名称: 对相同划分优先调用
      3.metadata 元数据: 提供描述信息，微服务版本控制
ribbon 客户端负载均衡，使用spring-cloud-starter-loadbalancer让@LoadBalanced注解生效
openfeign 声明式、模板化的HTTP客户端
      配置:
          1.Feign.Builder: Feign的入口
          2.Client: Feign底层用什么去请求
          3.Contract: 注解支持，例如SpringMvc
          4.Encoder: 编码器，用于将对象转换成HTTP请求消息体
          5.Decoder: 解码器，将响应消息体转换成对象
          6.Logger: 日志管理器
          7.RequestInterceptor: 用于为每个请求添加通用逻辑，例如添加请求头
      请求:
          Get: 使用@SpringQueryMap注解封装对象，使用@RequestParam("id")注解传递属性
          Post: 使用@RequestBody注解封装对象
sentinel 流控防护组件
      思维:
          1.超时: 限制访问时间 (释放够快就不容易崩)
          2.限流: 限制访问数量 (只有1碗饭量，给再多也只吃1碗)
          3.仓壁: 隔离请求（鸡蛋不放在一个篮子里）
          4.断路器: 监控+开关+半开关 (电流过大就跳闸)
      控制台:
          1.github下载: https://github.com/alibaba/Sentinel/tags
          2.docker下载: bladex/sentinel-dashboard
      操作:
          1.流控 
                --模式: 直接、关联、链路
                --效果: 快速失败、warm up、排队等待   
          2.降级
                --熔断策略: 慢调用比例、异常比例、异常数
          3.热点
                --参数索引: 对指定位置的参数限流，也能对参数传递的值进行限流，例如热点新闻
          4.系统
                --Load 自适应（仅对 Linux/Unix-like 机器生效）：系统的 load1 作为启发指标，进行自适应系统保护。当系统 load1 超过设定的启发值，且系统当前的并发线程数超过估算的系统容量时才会触发系统保护（BBR 阶段）。系统容量由系统的 maxQps * minRt 估算得出。设定参考值一般是 CPU cores * 2.5
                --CPU usage（1.5.0+ 版本）：当系统 CPU 使用率超过阈值即触发系统保护（取值范围 0.0-1.0），比较灵敏
                --平均 RT：当单台机器上所有入口流量的平均 RT 达到阈值即触发系统保护，单位是毫秒
                --并发线程数：当单台机器上所有入口流量的并发线程数达到阈值即触发系统保护
                --入口 QPS：当单台机器上所有入口流量的 QPS 达到阈值即触发系统保护
          5.授权Sentinel与控制台通信
                --注册: Sentinel注册到控制台后，会定时发送心跳 (服务发现)
                --调用: 控制台添加规则，就会调用Sentinel监控规则的api (ip+port+apiAddress)
      全局:
          1.异常处理: 
                    --描述: 对所有流控规则异常进行统一处理
                    --实现: 实现BlockExceptionHandler接口，加上@Component注解生效
          2.针对来源: 
                    --描述: 对所有请求返回针对来源，可以在请求和sentinel之间添加自定义处理
                    --实现: 实现RequestOriginParser接口，加上@Component注解生效
          3.REST风格API:
                    --描述: 对RESTURL统一处理，例如: /clean/{id} 这个URL，统一归集到 /clean/* 资源下
                    --实现: 实现UrlCleaner接口，加上@Component注解生效
RocketMQ 消息队列
Gateway 网关
      核心:
          1.Route (路由): SpringCloudGateway的基础元素，是一个转发规则。包含: ID、目标URI、Predicate集合、Filter集合
          2.Predicate (谓词): 路由匹配
          3.Filter (过滤器): 修改请求以及响应
      自定义Predicate:
          1.yml文件predicates属性下自定义: - TimeBetween=2022-05-02 09:10:00,2022-05-02 18:10:00
          2.创建TimeBetweenRoutePredicateFactory类(类名格式：自定义名称 + RoutePredicateFactory)，继承AbstractRoutePredicateFactory类，实现apply(是否能访问)、shortcutFieldOrder(获取参数)方法
      filters过滤器工厂:
          1.Spring Cloud Gateway的路由过滤器允许以某种方式修改传入的HTTP请求或输出的HTTP响应。只作用于特定的路由
          2.添加请求头: AddRequestHeader=selfhead, selfridicule 
          3.自定义，创建PreLogGatewayFilterFactory类(类名格式：自定义名称 + GatewayFilterFactory)，继承AbstractNameValueGatewayFilterFactory类，实现apply(对请求进行过滤操作)
```