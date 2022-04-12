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
      1.Client: Feign底层用什么去请求
      2.Contract: 注解支持，例如SpringMvc
      3.Encoder: 编码器，用于将对象转换成HTTP请求消息体
      4.Decoder: 解码器，将响应消息体转换成对象
      5.RequestInterceptor: 用于为每个请求添加通用逻辑，例如添加请求头
```