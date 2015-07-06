all: build push

build:
	docker build -t ${DOCKER_USER}/java-sni-test .

push: build
	docker push ${DOCKER_USER}/java-sni-test

test: build
	docker run -i ${DOCKER_USER}/java-sni-test /usr/bin/java HTTPSClient beta.chartmogul.com
	docker run -i ${DOCKER_USER}/java-sni-test /usr/bin/java HTTPSClient app.chartmogul.com
