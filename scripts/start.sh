#!/usr/bin/env bash

PROJECT_ROOT="/home/ubuntu/app"
JAR_FILE="$PROJECT_ROOT/spring-webapp.jar"

APP_LOG="$PROJECT_ROOT/application.log"
ERROR_LOG="$PROJECT_ROOT/error.log"
DEPLOY_LOG="$PROJECT_ROOT/deploy.log"

TIME_NOW=$(date +%c)

# build 파일 복사
echo "$TIME_NOW > $JAR_FILE 파일 복사" >> $DEPLOY_LOG
cp $PROJECT_ROOT/build/libs/*.jar $JAR_FILE

# jar 파일 실행
echo "$TIME_NOW > $JAR_FILE 파일 실행" >> $DEPLOY_LOG
nohup java -jar $JAR_FILE --spring.profiles.active=prod > $APP_LOG 2> $ERROR_LOG &

CURRENT_PID=$(pgrep -f $JAR_FILE)
echo "$TIME_NOW > 실행된 프로세스 아이디 $CURRENT_PID 입니다." >> $DEPLOY_LOG

# 애플리케이션 상태 확인
sleep 10  # 애플리케이션이 시작될 시간을 줍니다.
if curl -s http://localhost:8080/actuator/health | grep -q '"status":"UP"'; then
  echo "$TIME_NOW > 애플리케이션이 정상적으로 시작되었습니다." >> $DEPLOY_LOG
else
  echo "$TIME_NOW > 애플리케이션 시작에 실패했습니다." >> $DEPLOY_LOG
  exit 1
fi