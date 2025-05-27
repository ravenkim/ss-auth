#!/bin/bash

set -e

# .env에서 DB_TYPE 읽기
DB_TYPE=$(grep DB_TYPE .env | cut -d '=' -f2 | tr -d '\r' | xargs)

echo "Deploying database: $DB_TYPE"

# DB_TYPE에 따라 컨테이너 이름 및 프로필 지정
case "$DB_TYPE" in
  mariadb)
    CONTAINER_NAME="ss-auth-mariadb"
    PROFILE="mariadb"
    ;;
  postgresql)
    CONTAINER_NAME="ss-auth-postgresql"
    PROFILE="postgresql"
    ;;
  mongodb)
    CONTAINER_NAME="ss-auth-mongodb"
    PROFILE="mongodb"
    ;;
  *)
    echo "지원하지 않는 DB_TYPE입니다: $DB_TYPE"
    exit 1
    ;;
esac

# 기존 컨테이너 중지 및 삭제
if [ "$(docker ps -aq -f name="^${CONTAINER_NAME}$")" ]; then
  echo "기존 컨테이너 [$CONTAINER_NAME]가 존재합니다. 삭제 중..."
  docker stop "$CONTAINER_NAME" && docker rm "$CONTAINER_NAME"
fi

# 새로 컨테이너 실행
docker compose --env-file .env --profile "$PROFILE" up -d

echo "디비 배포 완료!"
