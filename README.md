## Lilishop B2B2C商城系统

### 介绍
**官网**：https://pickmall.cn

Lilishop 是一款Java开发，基于SpringBoot的B2B2C多用户商城，前端使用 Vue、uniapp-app开发 **系统全端全部代码开源**

商城展示端包含 PC、H5、小程序、APP。

商城包含 会员模块、**第三方登录模块**、**第三方支付模块**、**楼层装修模块**、订单模块、分销模块、文章模块、系统设置模块、流量分析模块

系统包含各种中间件、搜索引擎、多级缓存、分布式事务、分布式任务调度等，支持Docker，支持k8s。是一款高性能，支持高并发等商城系统。

开箱即用，简单配置即可部署一套属于您的系统。

完美支持二开、学生毕业设计答辩等各个场景

### 文档

**产品文档**（需求、架构、使用、部署、开发）：https://docs.pickmall.cn


### 项目链接

**Java后台**：https://gitee.com/beijing_hongye_huicheng/lilishop.git

**Vue后台前端**： https://gitee.com/beijing_hongye_huicheng/lilishop-ui.git

**Uni-app**：https://gitee.com/beijing_hongye_huicheng/lilishop-uniapp.git

**docker一键部署**：https://gitee.com/beijing_hongye_huicheng/docker.git

### 演示地址

**运营后台**：https://admin-b2b2c.pickmall.cn 账号：admin/123456

**店铺后台**：https://store-b2b2c.pickmall.cn 账号：13011111111/111111

**用户前台**：https://pc-b2b2c.pickmall.cn

**移动端**：https://m-b2b2c.pickmall.cn

![image-20210511171611793](https://pickmall.cn/assets/imgs/h5-qrcode.png)

### 3行命令搭建本地环境

##### 下载docker脚本
`git clone https://gitee.com/beijing_hongye_huicheng/docker.git `
##### 部署基础环境
`docker-compose up -d`
##### 部署应用
`docker-compose -f docker-compose-application.yml up -d`

| API           | 地址            |
| -------------- | --------------- |
| 买家api       | http://127.0.0.1:8888     |
| 商家api        | http://127.0.0.1:8889      |
| 管理端api       | http://127.0.0.1:8887   |
| 通用api       | http://127.0.0.1:8890     |

| 演示           | 地址            |
| -------------- | --------------- |
| PC       | http://127.0.0.1:10000     |
| WAP        | http://127.0.0.1:10001      |
| 商家       | http://127.0.0.1:10002   |
| 管理端       | http://127.0.0.1:10003     |



### 技术选型

##### Java后台

| 说明           | 框架            |
| -------------- | --------------- |
| 基础框架       | Spring Boot     |
| MVC框架        | Spring MVC      |
| 持久框架       | Mybatis-Plus    |
| 程序构建       | Maven           |
| 关系型数据库   | MySQL           |
| 消息中间件AMQP | RocketMQ        |
| 缓存           | Redis +MongoDB  |
| 搜索引擎       | Elasticsearch   |
| 安全框架       | Spring Security |
| 数据库连接池   | Druid           |
| 数据库分库分表 | sharding        |
| 定时任务       | xxl-job         |
| 负载均衡       | Nginx           |
| 静态资源       | 阿里云OSS       |
| 短信           | 阿里云短信      |
| 日志处理       | Log4j           |
| 接口规范       | RESTful         |
| 接口文档       | Swagger         |
| 认证           | JWT             |

##### 前端-运营后台、店铺后台

| 说明       | 框架       |
| ---------- | ---------- |
| 构建工具   | webpack    |
| JS版本     | ES6        |
| 基础JS框架 | Vue.js     |
| 视频播放器 | Dplayer    |
| 路由管理   | Vue Router |
| 状态管理   | Vuex       |
| 基础UI库   | iView      |
| UI界面基于 | iView      |
| 网络请求   | axios      |
| CSS预处理  | scss       |
| 代码检查   | ESLint     |
| 数据可视化 | AntV g2    |
| 地图引擎   | amap       |

##### 前端-移动端

| 说明      | 架构    |
| --------- | ------- |
| 基础UI库  | uViewui |
| 基础框架  | uni-app |
| CSS预处理 | scss    |
| 地图引擎  | amap    |



### 功能列表

<table>
  <tr><td colspan="2">运营后台功能</td></tr>
  <tr><td>首页</td><td>平台统计、待办事项、流量统计</td></tr>
  <tr><td rowspan="5">会员</td><td>会员列表</td></tr>
  <tr><td>评价列表</td></tr>
  <tr><td>积分历史</td></tr>
  <tr><td>会员资金</td></tr>
  <tr><td>充值记录</td></tr>
  <tr><td rowspan="6">订单</td><td>商品订单</td></tr>
  <tr><td>订单售后</td></tr>
  <tr><td>交易投诉</td></tr>
  <tr><td>售后原因</td></tr>
  <tr><td>收款流水</td></tr>
  <tr><td>退款流水</td></tr>
  <tr><td rowspan="6">商品</td><td>商品列表</td></tr>
  <tr><td>商品审核</td></tr>
  <tr><td>商品分类</td></tr>
  <tr><td>商品品牌</td></tr>
  <tr><td>商品规格</td></tr>
  <tr><td>计量单位</td></tr>
  <tr><td rowspan="5">促销</td><td>优惠券</td></tr>
  <tr><td>秒杀活动</td></tr>
  <tr><td>拼团活动</td></tr>
  <tr><td>积分商品</td></tr>
  <tr><td>积分分类</td></tr>
  <tr><td rowspan="5">店铺</td><td>店铺管理</td></tr>
  <tr><td>店铺结算</td></tr>
  <tr><td>店铺结算</td></tr>
  <tr><td>店铺结算</td></tr>
  <tr><td>店铺对账</td></tr>
  <tr><td rowspan="9">运营</td><td>店铺对账</td></tr>
  <tr><td>PC端楼层装修</td></tr>
  <tr><td>移动端楼层装修</td></tr>
  <tr><td>分销管理</td></tr>
  <tr><td>文章管理</td></tr>
  <tr><td>意见反馈</td></tr>
  <tr><td>站内信</td></tr>
   <tr><td>短信管理</td></tr>
   <tr><td>APP版本管理</td></tr>
   <tr><td rowspan="4">统计</td><td>会员统计</td></tr>
   <tr><td>订单统计</td></tr>
   <tr><td>商品统计</td></tr>
   <tr><td>流量统计</td></tr>
   <tr><td rowspan="11">设置</td><td>用户管理</td></tr>
   <tr><td>菜单管理</td></tr>
   <tr><td>部门管理</td></tr>
   <tr><td>系统设置</td></tr>
   <tr><td>OSS资源</td></tr>
   <tr><td>行政地区</td></tr>
   <tr><td>物流公司</td></tr>
   <tr><td>信任登录</td></tr>
   <tr><td>支付设置</td></tr>
   <tr><td>验证码管理</td></tr>
   <tr><td>敏感词管理</td></tr>
</table>

<table>
  <tr><td colspan="2">店铺后台功能列表</td></tr>
  <tr><td rowspan="3">首页</td><td>店铺信息</td></tr>
  <tr><td>待办事项</td></tr>
  <tr><td>平台公告</td></tr>
  <tr><td rowspan="3">商品</td><td>商品发布</td></tr>
  <tr><td>商品列表</td></tr>
  <tr><td>店铺商品分类</td></tr>
  <tr><td rowspan="5">订单</td><td>商品订单</td></tr>
  <tr><td>退货管理</td></tr>
  <tr><td>退款管理</td></tr>
  <tr><td>投诉管理</td></tr>
  <tr><td>评价管理</td></tr>
  <tr><td rowspan="3">财务</td><td>财务对账</td></tr>
  <tr><td>店铺结算</td></tr>
  <tr><td>发票管理</td></tr>
  <tr><td rowspan="5">促销</td><td>拼团管理</td></tr>
  <tr><td>秒杀活动</td></tr>
  <tr><td>满额活动</td></tr>
  <tr><td>优惠券</td></tr>
  <tr><td>分销商品</td></tr>
  <tr><td rowspan="2">统计</td><td>商品统计</td></tr>
  <tr><td>订单统计</td></tr>
  <tr><td rowspan="5">设置</td><td>配送模板</td></tr>
  <tr><td>物流公司</td></tr>
  <tr><td>店铺设置</td></tr>
  <tr><td>自提点管理</td></tr>
  <tr><td>系统消息</td></tr>
</table>

### 技术亮点


    1.后端框架基于Springboot，构建基于maven，持久层使用MyBatisPlus。使用elasticsearch、redis、mongodb、rocketmq 等各种中间健。都是主流架构，轻松应对各种环境。

    2.支持集群、分布式，支持docker 轻松部署，解决各种复杂场景！

    3.代码模块清晰，主要分为三端api（买家、卖家、管理），各端API互相隔离，自己鉴权，自己操作业务。

    4.使用阿里开源的RocketMQ，基于mq解决各种并发场景，解决事务一致性，解决搞并发延迟场景问题。

    5.项目使用多级缓存，应用不同场景，redis缓存业务数据、mongodb缓存关系型多对多关系问题、nginx缓存高频访问低频修改的页面。

    6.支持各种联合登陆，支持各种客户端的支付问题，灵活配置灵活开启。

    7.内置完善的楼层装修机制，各种拖拉拽，维护跳转页面或外网，即便是一个什么都不懂的运营也可以轻松掌握。

    8.内置阿里短信接口，可以在线申请短信模版。内置阿里oss系统，可以对文件执行各种操作。oss商家端资源相互隔离。

    10.强大的统计报表，统计效果，可以实现各个场景，包含在线人数，历史在线人数，活跃人数等信息。

    11.标准Api接口、提供swagger文档，快速二开。

    12.分布式调度任务中心，解决分布式定时任务多次执行问题。

    13.代码注释完善，快速上手。

    14.非移动端采用IView框架，各种自定义插件、选择器实现。移动端采用uniapp，一次编写，全端使用

    15.已经对接好各种第三方插件，支持各种复杂等联合登陆，联合支付等场景。


### 授权
Lilishop学习免费，限制商用，如果需要商业使用请联系我们。QQ3409056806

### 交流群

**QQ群**：961316482
