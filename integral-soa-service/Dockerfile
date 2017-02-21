From dockerhub.lefile.cn/dubbo:jdk7

MAINTAINER shaoyh2@lenovo.com

ADD target/*.tar.gz /data/service/

ADD shell/entrypoint.sh /data/
ADD shell/add-uat-hosts.sh /data/

RUN chmod +x /data/entrypoint.sh
RUN chmod +x /data/add-uat-hosts.sh

#ENTRYPOINT ["sh", "/data/service/bin/start.sh"]
CMD /data/entrypoint.sh