APP = api-user-account
VERSION = 1.0.0
JAR = contract-${VERSION}.jar
BUILD_FOLDER = contract/build/libs
TARGET_JAR = ${BUILD_FOLDER}/${JAR}
#JAVA_OPTS = -Dserver.port=0
DOCKER_IMAGE = ${APP}:latest
DOCKER_CONF = Dockerfile
COMPOSE_CONF = docker-compose.yml
STACK_CONF = docker-stack.yml

# Gradle

clean:
	./gradlew clean

all: clean
	./gradlew build

install: clean
	./gradlew jar

check: clean
	./gradlew check

check-unit: clean
	./gradlew test

check-integration: clean
	./gradlew check

dist: clean
	./gradlew bootJar

dist-run: dist run

run:
	java ${JAVA_OPTS} -jar ${TARGET_JAR}

# Docker

dist-docker-build-deploy: dist docker-build stack-deploy

dist-docker-build: dist docker-build

dist-docker-build-push: dist docker-build docker-push

docker-build-push: docker-build docker-push

docker-build:
	DOCKER_BUILDKIT=1 docker build -f ${DOCKER_CONF} -t ${DOCKER_IMAGE} --build-arg=JAR_FILE=${JAR} ${BUILD_FOLDER}

docker-run:
	docker run -d \
		--restart=always \
		--net schambeck-net \
		--name ${APP} \
	  	--env SPRING_DATASOURCE_URL=jdbc:mysql://db:3306/user_account \
		--env SPRING_DATASOURCE_USERNAME=root \
		--env SPRING_DATASOURCE_PASSWORD=example \
		--publish 8080:8080 \
		${DOCKER_IMAGE}

--rm-docker-image:
	docker rmi ${DOCKER_IMAGE}

docker-bash:
	docker exec -it docker_web_1 /bin/bash

docker-tag:
	docker tag ${APP} ${DOCKER_IMAGE}

docker-push:
	docker push ${DOCKER_IMAGE}

docker-pull:
	docker pull ${DOCKER_IMAGE}

# Compose

dist-compose-up: dist compose-up

dist-docker-build-compose-up: dist docker-build compose-up

docker-build-compose-up: docker-build compose-up

compose-up:
	docker-compose -p ${APP} -f ${COMPOSE_CONF} up -d --build

compose-down: --compose-down

compose-down-rmi: --compose-down --rm-docker-image

--compose-down:
	docker-compose -p ${APP} -f ${COMPOSE_CONF} down

compose-logs:
	docker-compose -f ${COMPOSE_CONF} logs -f \web

# Swarm

stack-deploy:
	docker stack deploy -c ${STACK_CONF} --with-registry-auth ${APP}

service-logs:
	docker service logs ${APP}_web -f
