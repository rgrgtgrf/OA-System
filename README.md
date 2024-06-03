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
对项目有了更深的理解， 学习了satoken的使用， 对websocket有了更多的了解， 对遇到bug有了更丰富的处理经验
### 项目亮点
亮点
