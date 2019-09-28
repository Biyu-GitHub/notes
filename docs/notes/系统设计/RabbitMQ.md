# RabbitMQ

## 1 安装

* erlang

```bash
sudo apt-get install erlang
```

* RabbitMq

```bash
wget -O- https://www.rabbitmq.com/rabbitmq-release-signing-key.asc | sudo apt-key add -

sudo apt-get update

apt-get install rabbitmq-server

# 可视化
rabbitmq-plugins enable rabbitmq_management   # 启用插件
service rabbitmq-server restart    # 重启

# 添加用户，默认用户为guest，guest
# 添加用户名为root，密码为rabbitmq的用户
sudo rabbitmqctl add_user root rabbitmq   # 增加普通用户
sudo rabbitmqctl set_user_tags root administrator    # 给普通用户分配管理员角色
sudo rabbitmqctl set_permissions -p / root ".*" ".*" ".*"
```

## 2 可视化

```http
http://127.0.0.1:15672
```

