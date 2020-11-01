# Getting Started

### To Build
     gradlew build 
Also caching refresh time can be configured at application.yml in the caching.refresh property and caching.retry for number of time it should keep trying to fetch data

### To Run
After build run the following command for running application by default on port 8080
 ***java -jar ./agileengine-0.0.1-SNAPSHOT.jar***

### Endpoints
**GET /search?author=xxx&camera=xxx,&tags=xx,yy** it will search for image matching any of the queries criteria

### TODO

 [ ] Fix test
 [ ] increase fetch data performance
 [ ] Fix project structure (rename files and better design)
 [ ] Improve logging


