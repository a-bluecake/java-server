# AdminServer
企业级SpringBoot Java后端基础脚手架，封装后端项目通用基础设施，快速开发后台管理系统。

## 框架介绍
本项目为一套可复用后端基础框架，内置权限认证、缓存、全局异常、AOP、接口文档、多环境等通用组件，采用标准三层架构。所有功能均按照企业实际开发标准设计，结构规范、分层清晰、可扩展性强，内置用户模块仅作为业务开发示例，新项目可基于脚手架快速开发业务，无需重复搭建底层基础。

### 技术栈
SpringBoot + MyBatis-Plus + MySQL + Redis + Sa-Token + Swagger + Maven

### 内置基础能力
- 三层架构，MyBatis-Plus CRUD、分页、字段自动填充
- Redis缓存，自定义序列化
- Sa-Token登录鉴权，Token存入Redis
- AOP环绕通知统一处理Controller
- 拦截器权限控制，规范401/403返回码
- 全局异常捕获 + 统一Result返回体
- Swagger在线API文档
- 多环境配置(dev/prod)

### 目录说明
- controller：接口控制层
- service：业务层
- mapper：MyBatisPlus数据访问层
- entity：数据库实体
- aspect：AOP切面
- config：各类组件配置
- handler：全局异常、自动填充处理器
- common：公共返回类、常量
- util：通用工具类
