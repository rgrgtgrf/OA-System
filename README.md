# Java项目OA系统后端
## 技术栈
springboot, mysql, mybatis, maven, websocket, alioss对象存储, pagehelper, swagger，saToken等
## 项目简介
### 工具类包
- AliossUtil 将文件上传到阿里云对象存储服务上去，不用多次配置密钥域名之类的东西
- HttpClientUtil httpclient工具包用来发送和接受请求（貌似没用上）
- MessageUtil 将message转换成json格式数据传输
###  controller类
- User 用户端接口，主要功能有注册， 查询， 登录登出， 查询工作， 提交工作
- Request 请假， 转入部门， 转出部门接口， 主要功能有发布请求和审核请求
- Group 小组相关接口， 主要功能有新增小组， 查询工作进度， 和更新工作内容
- Dept 部门相关接口， 主要功能有查询部门及部门公告
- Common 上传文件（用户头像）的接口
- Announcement 发布公告
### 学习心得
- 在从头开始写一个小项目的过程中遇到了很多很纯的错误（比如启动类放错位置导致只扫描到了.server后缀的包），同时也上网寻找到了许多解决办法，对于一般bug有了更多的的经验。
- 学习了satoken的简单使用（权限认证，登录，登出，校验登录等简单api）
- 对websocket有了更多的了解（但貌似我找的教程中难度主要在前端？）
### 项目亮点
- 使用RBAC架构，首先建立用户与角色之间的映射，再建立角色与权限的映射以减少资源的消耗
- 使用PageHelper进行分页展示
- 密码进行MD5加密，具有更高的安全性
- 用户可以选择是否记住用户（30天内保持登录状态）
- 有聊天功能，可以上传头像
