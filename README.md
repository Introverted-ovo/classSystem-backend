# 课程排课系统后端

## 项目简介
这是一个基于SpringBoot + MyBatis的课程排课系统后端，提供了课程管理、教室管理、教师管理、学生管理以及课表管理等功能的REST API接口。

## 技术栈
- Spring Boot 2.7.6
- MyBatis 
- MySQL 8.0
- JWT (用于身份认证)
- PageHelper (用于分页)
- Hutool (工具库)

## 主要功能
1. 用户管理
   - 管理员/教师/学生的注册与登录
   - 用户信息的CRUD操作
   - 基于JWT的身份认证

2. 课程管理
   - 课程信息的添加、修改、删除
   - 课程信息的分页查询

3. 教室管理
   - 教室信息的CRUD操作
   - 教室信息的分页查询

4. 课表管理
   - 课表的添加、修改、删除
   - 按班级、教师等条件查询课表
   - 支持分页查询

## 项目结构
springboot_project/
├── src/main/java/org/example/springboot_project/
│   ├── common/           // 公共组件
│   │   ├── CorsConfig.java     // 跨域配置
│   │   ├── JwtInterceptor.java // JWT拦截器
│   │   ├── Result.java         // 统一返回结果
│   │   └── WebConfig.java      // Web配置
│   ├── controller/      // 控制器层
│   ├── dao/            // 数据访问层
│   ├── entity/         // 实体类
│   ├── exception/      // 异常处理
│   └── service/        // 服务层
└── resources/
    ├── application.yml  // 配置文件
    └── mapper/         // MyBatis映射文件

## 快速开始

### 环境要求
- JDK 1.8+
- Maven 3.6+
- MySQL 8.0+

### 配置数据库
1. 创建MySQL数据库：springboot
2. 修改`application.yml`中的数据库配置：
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/springboot?serverTimezone=UTC
    username: your_username
    password: your_password

### 运行项目
1. 克隆项目到本地
2. 使用IDE打开项目
3. 执行Maven构建
4. 运行`SpringbootProjectApplication.java`

### 接口说明
- 登录接口：`POST /api/admin/login`
- 注册接口：`POST /api/admin/register`
- 课程管理：`/api/course/**`
- 教室管理：`/api/classroom/**`
- 课表管理：`/api/timetable/**`

## 安全说明
- 使用JWT进行身份认证
- 所有API接口（除登录注册外）都需要携带token访问
- token默认有效期为2小时

## 注意事项
1. 首次使用需要配置好数据库连接
2. 默认用户密码为123456
3. 确保MySQL服务正常运行
4. 注意跨域配置的设置

## 贡献指南
欢迎提交Issue和Pull Request

## 许可证
MIT License 