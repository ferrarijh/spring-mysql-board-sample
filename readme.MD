# Online board sample with spring boot
Sample spring boot mvc application showcasing online board.

### Connecting to db
Two ways to handling data source:
1) configure `application.properties`
2) use `@Bean` annotation

### What's what
* Hikari CP: Connection pool which connects an app with db(like tomcat). Fast and reliable.
* MyBatis: Makes it much easier to exploit SQL statements by separating them to other files or parts such as `.xml` file
or to annotation rather than embedding them in java code.