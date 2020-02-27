# 微服务示例

本示例为一个使用springcloud gateway+spring cloud alibaba技术栈的可扩展的分布式应用系统脚手架，使用nacos作服务注册、发现及配置中心

## 服务列表

服务名称 | 服务描述
---|---
service-gateway | api路由
service-auth | 认证服务
service-a | rest template示例
service-a-openfeign | openfeign示例
service-rest-aa | 
service-b | 
service-dubbo-bb | dubbo调用示例

## 服务启动

1. 先安装nacos
2. 启动service-gateway网关
3. 启动其他服务

请求示例：

1. 获取token
   
```bash

curl --location --request GET 'localhost:8081/auth/login' \
--header 'Content-Type: application/json' \
--data-raw '{"username":"zhang1","password":"123"}'

```

2. 获取到的token代入header中Authorization参数，请求资源

```bash

curl --location --request GET 'localhost:8081/api/service_a/hello' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ6aGFuZ3NoYW4iLCJyb2xlcyI6IlJPTEVfQURNSU4iLCJpc3MiOiJyYXBoYS5pbyIsImV4cCI6MTU4Mjg1NTQ2MH0.S3wOd8RFf6ndEYtw25c9P444iJqV6ayVDmzzGUY0idw'

```

## 服务调用链

service-gateway -> service-auth

service-gateway -> service-a -> service-rest-aa

service-gateway -> service-a-openfeign -> service-rest-aa

service-gateway -> service-b -> service-dubbo-bb