if [[ $ENV = "docker-uat" ]]; then
  echo $ENV
  sh /data/add-uat-hosts.sh
else
  echo "product"
fi

echo $ENV

/data/service/bin/start.sh;

sleep 10s

tail -f /data/logs/dubbo/*.log