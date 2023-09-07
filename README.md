# Wikimedia Kafka Application
A simple microservices application developed in Spring Boot to perform the following: 
- Read [Wikimedia](https://stream.wikimedia.org/v2/stream/recentchange) data.
- Publish and consume Wikimedia data from Kafka (using topics).
- Save Wikimedia data into MySQL DB via the Kafka consumer app.

### Tech Stack
- Spring Boot
- Kafka
- MySQL
- Docker

The project consists of following Kafka services.
- Zookeeper
- Brokers
- schema-registry

### Running the services on Docker
This will allow to build and run all the services in Docker.

- Spring Boot App (consumer and producer microservices)
- MySQL 8
- Zookeeper - 1
- Brokers - 3
- schema-registry - 1

<strong>Prerequisites</strong></br>
- Docker installation

<strong>Steps</strong></br>
- **Step 1:** The project needs to be built first using the command `mvn install -DskipTests` via intelliJ or in commandline. It should be executed under the root project `wikimedia-kafka` as shown below.
  ![](https://i.imgur.com/QVbx4Bw.png)
- **Step 2:** Execute the following docker command inside the `docker-compose` directory in order to bring up the Spring project and the Kafka servers.

    ```
    docker-compose up 
    ```
    ![](https://i.imgur.com/qU9fOpn.png)

### Running the project in IntelliJ
<strong>Prerequisites</strong></br>
- Java 17
- Docker installation

<strong>Steps</strong></br>
- **Step 1:** Execute thr following docker command inside the `docker-compose` directory in order to bring up the Kafka servers.

    ```
    docker-compose -f common.yml -f kafka_cluster.yml up 
    ```
- **Step 3:** Install and run MySQL locally with the DB `wikimeida` or create and run it as separate Docker container using `docker-mysql` available in `services.yml` file.

- **Step 2:** Build and run each microservice (`kafka-consumer-wikimedia` and `kafka-producer-wikimedia`) project in IntelliJ.

### Connecting to the MySQL
The [MySQL Workbench](https://www.mysql.com/products/workbench/) can be used with the configs defined in `services.yml` file for `docker-mysql`.
![](https://i.imgur.com/wJtl36p.png)
![](https://i.imgur.com/lFxhUAr.png)

### Connecting to the Kafka Server
The [Offset Explorer](https://www.kafkatool.com/) can be used with the following configs.
![](https://i.imgur.com/A6K4b8Y.png)
![](https://i.imgur.com/YBbZLAw.png)




### Checking Kafka messages inside a given topic
This can be done using [kafkacat](https://hub.docker.com/r/confluentinc/cp-kafkacat/).
```
docker run -it --network=host confluentinc/cp-kafkacat kafkacat -C -b  localhost:19092  -t wikimedia_recentchange
```

```
docker run -it --network=host confluentinc/cp-kafkacat kafkacat -C -b  localhost:39092  -t wikimedia_recentchange
```