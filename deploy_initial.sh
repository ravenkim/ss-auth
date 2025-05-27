#!/bin/bash

# 디비 생성
echo "디비 생성 중..."
# 데이터베이스 생성 명령어 (예: MySQL 또는 PostgreSQL을 사용한다고 가정)
# 예시: `mysql -u root -p -e "CREATE DATABASE mydb;"`
./deploy_db.sh


# 앱 배포
echo "앱 배포 중..."
# 앱 배포 명령어 (예: Docker, Kubernetes 또는 다른 배포 시스템에 맞게)
# 예시: `docker-compose up --build -d`
./deploy_app.sh


echo "배포 완료!"
