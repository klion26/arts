1 云原生环境下 Pulsa 和 Kafka 的对比，为什么需要把 kafka 切换到 pulsa
2 LoggerFactory.getLogger 的执行流程是什么样的（从这一步到加载 log4j.properteis 配置文件这些）
```
   log4j:ERROR setFile(null,true) call failed.
java.io.FileNotFoundException:  (No such file or directory)
	at java.base/java.io.FileOutputStream.open0(Native Method)
	at java.base/java.io.FileOutputStream.open(FileOutputStream.java:298)
	at java.base/java.io.FileOutputStream.<init>(FileOutputStream.java:237)
	at java.base/java.io.FileOutputStream.<init>(FileOutputStream.java:158)
	at org.apache.log4j.FileAppender.setFile(FileAppender.java:294)
	at org.apache.log4j.RollingFileAppender.setFile(RollingFileAppender.java:207)
	at org.apache.log4j.FileAppender.activateOptions(FileAppender.java:165)
	at org.apache.log4j.config.PropertySetter.activate(PropertySetter.java:307)
	at org.apache.log4j.config.PropertySetter.setProperties(PropertySetter.java:172)
	at org.apache.log4j.config.PropertySetter.setProperties(PropertySetter.java:104)
	at org.apache.log4j.PropertyConfigurator.parseAppender(PropertyConfigurator.java:842)
	at org.apache.log4j.PropertyConfigurator.parseCategory(PropertyConfigurator.java:768)
	at org.apache.log4j.PropertyConfigurator.parseCatsAndRenderers(PropertyConfigurator.java:672)
	at org.apache.log4j.PropertyConfigurator.doConfigure(PropertyConfigurator.java:516)
	at org.apache.log4j.PropertyConfigurator.doConfigure(PropertyConfigurator.java:580)
	at org.apache.log4j.helpers.OptionConverter.selectAndConfigure(OptionConverter.java:526)
	at org.apache.log4j.LogManager.<clinit>(LogManager.java:127)
	at org.slf4j.impl.Log4jLoggerFactory.getLogger(Log4jLoggerFactory.java:81)
	at org.slf4j.LoggerFactory.getLogger(LoggerFactory.java:329)
	at org.slf4j.LoggerFactory.getLogger(LoggerFactory.java:349)
	at org.apache.flink.runtime.entrypoint.ClusterEntrypoint.<clinit>(ClusterEntrypoint.java:98)
```
