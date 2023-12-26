# MongoDb test REST API

This API provides a CRUD interface for a Student model, which includes two embedded documents (Subject and Department). 
You can easily clone and build the project using Docker, and it doesn't require any additional tools except Docker Compose.

### How to run
1) clone repository
2) run follow command in project root directory
```shell
docker compose up --build
```
3) go to http://localhost:8080/swagger-ui/index.html#/
