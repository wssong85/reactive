
* 도커 이미지 생성
 
`Docker image pull redis`


* 도커 네트워크 생성

`docker network create redis-net`

* 도커 레디스 실행

`docker run -d --name redis -p 6379:6379 --network redis-net redis`


* 도커 레디스 cli 접속

`docker run -it --network redis-net --rm redis redis-cli -h redis`

* 도커 레디스 os 접속

`docker ps docker exec -it myredis /bin/bash`