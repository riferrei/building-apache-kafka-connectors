# Kafka Connect Sample Connector

This repository contains a sample project that can be used to start off your own source connector for Kafka Connect.

## Building the connector

The first thing you need to do to start using this connector is built it. To do that, you need to install the following dependencies:

- [Java 11+](https://openjdk.java.net/)
- [Apache Maven](https://maven.apache.org/)

After installing these dependencies, execute the following command:

```bash
mvn clean package
```

## Trying the connector

After building the connector, you can try it by using the Docker-based installation from this repository.

### 1 - Starting the environment

Start the environment with the following command:

```bash
docker-compose up
```

Wait until all containers are up so you can start the testing.

### 2 - Install the connector

Open a terminal to execute the following command:

```bash
curl -X POST -H "Content-Type:application/json" -d @examples/basic-example.json http://localhost:8083/connectors
```

### 4 - Check the data in Kafka

Open a terminal to execute the following command:

```bash
docker exec kafka kafka-console-consumer --bootstrap-server kafka:9092 --topic source-1 --from-beginning
```

# License

This project is licensed under the [Apache 2.0 License](./LICENSE).
