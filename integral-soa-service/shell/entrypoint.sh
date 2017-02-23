if [[ $ENV = "docker-uat" ]]; then
  echo $ENV
  sh /data/add-uat-hosts.sh
else
  echo "product"
fi

echo $ENV

/data/service/bin/start.sh; tail -f /data/logs/resin/*.log