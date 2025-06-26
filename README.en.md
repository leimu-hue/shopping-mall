# shopping-mall

#### 介绍
谷粒商城是尚硅谷雷丰阳老师教学的一套B2C商城项目，项目由业务集群系统+后台管理系统构成，打通了分布式开发
及全栈开发技能，包含前后分离全栈开发、Restful接口、数据校验、网关、注册发现、配置中心、熔断、限流、
降级、链路追踪、性能监控、压力测试、系统预警、集群部署、持续集成、持续部署等

#### 软件架构

```angular2html
- shopping-front                        包括用户端和管理端的前端代码
- shopping-mall                         后端代码
    -- mall-common                      基础组件信息
    -- mall-coupon                      营销系统相关代码
    -- mall-member                      用户系统相关代码
    -- mall-order                       订单系统相关代码
    -- mall-product                     商品系统相关代码
    -- mall-ware                        库存系统相关代码
    -- ruoyi-boot                       若依开源框架，主要用来实现管理端
        -- 项目架构参考：https://gitee.com/y_project/RuoYi-Vue

```
技术选型方案：
1. shopping-front/client：前端技术

   | 技术           | 描述              |
      |--------------|-----------------|
   | Vue3         | 渐进式JavaScript框架 |
   | Element-Plus | Vue3 UI框架       |
   | Pinia        | Vue状态管理库        |
   | Vue-Router   | Vue客户端路由解决方案    |


2. shooping-fron/client
   主要采用ruoyi的前端代码： [ruoyi前端代码](https://gitee.com/y_project/RuoYi-Vue)


3. shopping-mall: 后端技术

| 技术                           | 描述         |
   |------------------------------|------------|
| SpringCloud Alibaba Nacos    | 注册中心以及配置中心 |
| SpringCloud OpenFeign        | 声明式HTTP客户端 |
| SpringCloud Alibaba Sentinel | 服务容错框架     |
| SpringCloud Gateway          | API网关      |
| Micrometer + Zipkin          | 调用链监控      |
| SpringCloud Alibaba Seata    | 分布式事务解决方案  |
| Redis                        | 开源的内存数据库   |
| MySQL                        | 开源的关系型数据库  |



#### 安装教程

1.  xxxx
2.  xxxx
3.  xxxx

#### 使用说明

1.  xxxx
2.  xxxx
3.  xxxx

#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request