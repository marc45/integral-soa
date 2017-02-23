#!/bin/bash
cd `dirname $0`
if [ "$1" = "start" ]; then
	sh ./start.sh
else
	if [ "$1" = "stop" ]; then
		sh ./stop.sh
	else
		if [ "$1" = "debug" ]; then
			sh ./start.sh debug
		else
			if [ "$1" = "restart" ]; then
				sh ./restart.sh
			else
				if [ "$1" = "dump" ]; then
					sh ./dump.sh
				else
					echo "ERROR: Please input argument: start or stop or debug or restart or dump"
				    exit 1
				fi
			fi
		fi
	fi
fi
