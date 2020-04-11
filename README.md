# Star Tiger Shopping
极简购物流程验证微服务架构Demo

## 技术栈


## 部署

#### 全局
1. 脚本授权
```bash
chmod u+x bin/*.sh
```

#### 模块部署
1. 应用数据库
    - 构建并运行docker容器  
        ```bash
        ./bin/db-build.sh
        ```
    - 配置主库  
        ```bash
        ./bin/db-init-master.sh
        ```
        根据控制台输出获取`File`和`Position`
    - 配置从库  
        ```bash
        ./bin/db-init-slave.sh $File $Position
        ```
        `$File` `$Position` 分别对应上述配置主库时的控制台输出
    - 初始化表结构  
        ```bash
        ./bin/db-init-data.sh
        ```

2. Nacos注册&配置中心
```bash
./bin/nacos-build.sh
```