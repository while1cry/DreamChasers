# RESTful API 文档

## 基础信息
- **Base URL**: `https://dreamchasers.top/api`
- **鉴权方式**: 在需要鉴权的接口请求头中添加`Authorization: Bearer {Token}`

---

## 通用响应格式
```json
{
    "code": 0,
    "message": "info",
    "data": []
}
```

## 用户相关接口

### 1. 用户注册
URL: `/auth/register`  
Method: `POST `  
Content-Type: `application/json  `  
请求体:

```json
{
    "username": "string",
    "password": "string",
    "registration": "string"
}
```
成功响应:

```json
{
    "code": 0,
    "message": "用户注册成功",
    "data": {
        "id": "114514",
        "username": "while1cry"
    }
}
```
### 2. 用户登录
URL: `/auth/login`  
Method: `POST`  
Content-Type: `application/json`  
Request Body:

```json
{
    "username": "string",
    "password": "string"
}
```
成功响应:

```json
{
    "code": 0,
    "message": "登录成功",
    "data": {
        "token": "xxxxxx"
    }
}
```
### 3. 获取当前用户信息
URL: `/users/me`  
Method: `GET`  
需要鉴权: ✔️  
成功响应:

```json
{
    "code": 0,
    "message": "OK",
    "data": {
        "id": "114514",
        "username": "while1cry",
        "registration": "1919810"
    }
}
```

### 4. 获取其他用户信息
URL: `/users/{id}`  
Method: `GET`  
需要鉴权: ✔️  
成功响应:

```json
{
    "code": 0,
    "message": "OK",
    "data": {
        "id": "${id}",
        "username": "while1smile",
        "registration": "1145141919810"
    }
}
```

## 音乐资源接口
### 1. 获取音乐列表
URL: `/music/list`  
Method: `GET`  

## 视频资源接口

## 任务管理接口

### 1. 创建任务
URL: `/tasks`  
Method: `POST`  
需要鉴权: ✔️  
Content-Type: `application/json`  
Request Body:

```json
{
    "title": "Process video",
    "description": "Video processing task"
}
```
响应示例:

```json
{
    "code": 0,
    "message": "Task created",
    "data": {
        "task_id": "t1",
        "status": "pending"
    }
}
```
### 2. 更新任务状态
URL: `/tasks/:id/status`  
Method: `PUT`  
需要鉴权: ✔️  
Content-Type: `application/json`  
Request Body:

```json
{
    "status": "processing"
}
```
成功响应:

```json
{
    "code": 0,
    "message": "Status updated",
    "data": null
}
```
