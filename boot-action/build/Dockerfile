# 拉取指定的镜像文件
FROM hub.c.163.com/library/java:latest

# MAINTAINER 指令允许你给将要制作的镜像设置作者信息
MAINTAINER byron <byron4j@126.com>
# 容器内创建一个 apps 目录，用来挂载 jar 包
RUN mkdir -p /apps
# 将 passjavas-demo-1.0 jar 包复制到 /apps/passjava-demo.jar
ADD boot-action-0.0.1-SNAPSHOT.jar /apps/boot-action.jar
# 设置时区
ENV TZ "Asia/Shanghai"
# 设置暴露的端口
EXPOSE 9600
#dockerfile中增加健康检查，interval表示每个5分钟检查一次，timeout每次超过5秒钟认定为失败，retries失败后轮询3次认定为容器不健康，考虑重启。
#HEALTHCHECK --interval=60s --timeout=5s --retries=6 \
#  CMD curl -f http://localhost:8989/health || exit 1
# 运行 Java 应用程序的命令
ENTRYPOINT ["java","-jar","/apps/boot-action.jar"]