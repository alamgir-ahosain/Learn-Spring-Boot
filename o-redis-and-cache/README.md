



#  Caching Demo with Redis

> Scenario    : call `getStudentById` 


| Feature        |  [Video 1 ](1-Before-Cache.mp4) |  [Video 2](2-After-Cache.mp4)  |
| -------------- | -------------------------------- | ------------------------------------ |
| Database Call  |  Yes (DB is queried)            |  No DB call                         |
| Service Layer  |  Executed                       |  Skipped                            |
| Cache Usage    | Data stored in Redis             | Data fetched from Redis              |
| Result         | First request always hits DB     | Subsequent requests use cache        |


