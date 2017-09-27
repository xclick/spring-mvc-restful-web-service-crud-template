# spring-mvc-restful-web-service-crud-template
缩写：restful-crud
这是一个模板工程，用于创建后台Restful API风格的后台Web应用
需要时，可以clone这个工程然后加入自己的应用

## Demo Database
```sql
CREATE DATABASE cruddb DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE USER cruduser IDENTIFIED BY 'password';

GRANT ALL PRIVILEGES ON cruddb.* TO 'cruduser'@'%' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON cruddb.* TO 'cruduser'@'localhost' IDENTIFIED BY 'password';
FLUSH PRIVILEGES;

use cruddb;

CREATE TABLE IF NOT EXISTS `user` (
  id   INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(200),
  PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;

```


## 测试
### 1. 新增
http://192.168.1.33:8080/restful-crud/users/create
POST
```json
{
	"name":"Bill"
}
```

### 2. 更新
http://192.168.1.33:8080/restful-crud/users/update/{id}
POST
```json
{
	"id":1,
	"name":"Gates"
}
```
### 3. 获取所有
http://192.168.1.33:8080/restful-crud/users/list
GET

### 4. 获取某笔记录
http://192.168.1.33:8080/restful-crud/users/get/{id}
GET

### 5. 删除
DELETE
http://192.168.1.33:8080/restful-crud/users/delete/{id}
