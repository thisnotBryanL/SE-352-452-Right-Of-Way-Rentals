## Right of Way Rentals
This is a car rental reservation application for DePaul SE352/452.

[![Build status](https://badge.buildkite.com/5f6feaa90aee763d56023c744c858ffe0840c978e7bb593da1.svg)](https://buildkite.com/depaul-university/right-of-way-rentals-pipeline)

<br/>

## Documentation
Swagger UI: http://localhost:8080/swagger-ui/index.html


## Tools

| Tool                                                                                    | Used for           | commands      |
|-----------------------------------------------------------------------------------------|--------------------|---------------|
| [IntelliJ](https://www.jetbrains.com/idea/)                                             | Code Editor        |               |
| [GitHub Desktop](https://desktop.github.com/)                                           | Manage Git         |               |
| [GitFlow](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow) | Branching Strategy | refer to link |
| [SonarLint](https://www.sonarsource.com/products/sonarlint/)                            | Clean code         | IDE plugin    |

## How to spin up via docker-compose
- In root directory, build the application image by executing `docker build -t rowr:latest .` 
  - The image is now available locally. To confirm, execute `docker image ls`
- 'cd' into `infra` directory
- run `docker-compose up -d`
- To verify the application is up/running - `docker ps` 
- To view application logs - `docker logs app [-f]`
  - `-f` to hang the terminal / follow along with logs

<br/>

## Contributors

| Contributors                                                                              | Contributions|
|-----------------------------------------------------------------------------------------|--------------------|
| Bryan Lee                                         | Service/Controller |
| Nermin Dedovic                                          | Service/Controller/Relationship for Models        |               
| Ethan Ly  | Relationship for Models | 
