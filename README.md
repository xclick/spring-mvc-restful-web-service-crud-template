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
  id   VARCHAR(100) NOT NULL,
  name VARCHAR(200)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;

ALTER TABLE `user` ADD PRIMARY KEY (id);

```
