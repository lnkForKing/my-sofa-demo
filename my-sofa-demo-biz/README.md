# 主应用

打包后基于该应用执行FatJar   
执行命令: `java -Dcom.alipay.sofa.ark.master.biz=my-sofa-demo-biz -jar target\my-sofa-demo-biz-1.0-SNAPSHOT-ark-executable.jar`。   
命令中的 `-Dcom.alipay.sofa.ark.master.biz=my-sofa-demo-biz` 是指定服务的主应用，本应在 `bootstrap.properties` 配置的，但未找到打包该配置文件到 FatJar 包的方法。    